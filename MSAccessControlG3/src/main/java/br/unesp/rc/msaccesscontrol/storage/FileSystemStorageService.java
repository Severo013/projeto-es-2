package br.unesp.rc.msaccesscontrol.storage;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import br.unesp.rc.msaccesscontrol.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileSystemStorageService implements StorageService {

    private final Path rootLocation;

    @Autowired
    public FileSystemStorageService(StorageProperties properties) {

        if (properties.getLocation().trim().length() == 0) {
            throw new StorageException("File upload location can not be Empty.");
        }

        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public void store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file.");
            }

            // Garante que o diretório existe
            if (!Files.exists(this.rootLocation)) {
                System.out.println("Creating directory: " + this.rootLocation);
                Files.createDirectories(this.rootLocation);
            }

            // Verifica permissões de escrita
            if (!Files.isWritable(this.rootLocation)) {
                throw new StorageException("No write permission for directory: " + this.rootLocation);
            }

            Path destinationFile = this.rootLocation.resolve(
                            Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();

            if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
                throw new StorageException("Cannot store file outside current directory.");
            }

            // Log para debug
            System.out.println("Saving file to: " + destinationFile);
            System.out.println("Directory exists: " + Files.exists(destinationFile.getParent()));
            System.out.println("Directory writable: " + Files.isWritable(destinationFile.getParent()));

            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("File saved successfully: " + destinationFile);
            }
        } catch (IOException e) {
            System.err.println("Error storing file: " + e.getMessage());
            System.err.println("Root location: " + this.rootLocation.toAbsolutePath());
            e.printStackTrace();
            throw new StorageException("Failed to store file.", e);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(this.rootLocation::relativize);
        } catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }

    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new StorageFileNotFoundException(
                        "Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @Override
    public void init() {
        try {
            if (!Files.exists(rootLocation)) {
                Files.createDirectories(rootLocation);
                System.out.println("Storage directory created: " + rootLocation.toAbsolutePath());
            }

            // Verifica se tem permissão de escrita
            if (!Files.isWritable(rootLocation)) {
                System.err.println("WARNING: No write permission for: " + rootLocation.toAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("Failed to create storage directory: " + rootLocation.toAbsolutePath());
            throw new StorageException("Could not initialize storage", e);
        }
    }
}