package br.unesp.rc.msaccesscontrol.service;

import br.unesp.rc.msaccesscontrol.entity.Visit;
import br.unesp.rc.msaccesscontrol.repository.VisitRepository;
import br.unesp.rc.msaccesscontrol.storage.FileSystemStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Component
public class VisitService {

    @Autowired
    private VisitRepository repository;

    @Autowired
    private FileSystemStorageService storageService;

    public VisitService() {
    }

    public Visit save(Visit visit) {
        return repository.save(visit);
    }

    public Optional<Visit> findById(Long id) { return repository.findById(id);}

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Visit update(Visit visit) {
        return repository.save(visit);
    }

    public List<Visit> findAll() {
        return repository.findAll();
    }

    public String registrarVisita(Visit visit) {
        Visit createdVisit = repository.save(visit);

        // Create a mock file with visit information
        try {
            String fileContent = "Visita registrada em: " + java.time.LocalDateTime.now() +
                                "\nVisitante: " + visit.getVisitor().getName();

            MultipartFile mockFile = new MockMultipartFile(
                "visita_" + createdVisit.getId() + ".txt",
                "visita_" + createdVisit.getId() + ".txt",
                "text/plain",
                fileContent.getBytes()
            );

            storageService.store(mockFile);
            System.out.println("Arquivo salvo: " + mockFile.getOriginalFilename());

        } catch (Exception e) {
            System.err.println("Erro ao salvar arquivo: " + e.getMessage());
            return "Visita registrada, mas houve erro ao salvar o arquivo.";
        }

        System.out.println("Visita registrada: " + createdVisit.toString());
        return "Visita registrada com sucesso!";
    }
}
