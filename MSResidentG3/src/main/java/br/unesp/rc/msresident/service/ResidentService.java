package br.unesp.rc.msresident.service;

import br.unesp.rc.msresident.dto.AccessDTO;
import br.unesp.rc.msresident.dto.ResidentChargeDTO;
import br.unesp.rc.msresident.dto.assembler.AccessAssembler;
import br.unesp.rc.msresident.entity.Access;
import br.unesp.rc.msresident.entity.Resident;
import br.unesp.rc.msresident.repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class ResidentService {

    @Autowired
    private ResidentRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ResidentRepository residentRepository;

    public ResidentService() {
    }

    public Resident save(Resident resident) {
        return repository.save(resident);
    }

    public Resident findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Resident update(Resident resident) {
        return repository.save(resident);
    }

    public List<Resident> findAll() {
        return repository.findAll();
    }

    public boolean alugarUnidade(Resident resident) {
        Resident createdResident = repository.save(resident);

        System.out.println("Residente cadastrado: " + createdResident.toString());

        System.out.println("Gerando cobrança para o residente: " + createdResident.getId());

        String url = "http://localhost:8086/charges/v1/gerarCobranca"; // URL do serviço de cobrança

        ResidentChargeDTO dto = new ResidentChargeDTO(createdResident.getId(), createdResident.getResidentType().name());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ResidentChargeDTO> request = new HttpEntity<>(dto, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        System.out.println("Cobrança gerada: " + response.getBody());

        return true;
    }

public Long validarAcesso(AccessDTO accessDto) {
    Access access = AccessAssembler.dtoToEntityModel(accessDto);
    // Query using the actual field values instead of the entity
    Resident resident = residentRepository.findByAccessUserAndAccessPassword(
        access.getUser(), access.getPassword());

    if (resident != null) {
        System.out.println("Acesso validado para o residente: " + resident.getName());
        return resident.getId();
    } else {
        System.out.println("Acesso inválido para o usuário: " + accessDto.getUser());
        return 0L;
    }
}
}
