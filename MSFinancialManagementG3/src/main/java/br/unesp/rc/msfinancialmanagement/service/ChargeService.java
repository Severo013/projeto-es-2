package br.unesp.rc.msfinancialmanagement.service;

import br.unesp.rc.msfinancialmanagement.dto.ResidentAccessDTO;
import br.unesp.rc.msfinancialmanagement.entity.Charge;
import br.unesp.rc.msfinancialmanagement.entity.ChargeType;
import br.unesp.rc.msfinancialmanagement.entity.Resident;
import br.unesp.rc.msfinancialmanagement.repository.ChargeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
public class ChargeService {

    @Autowired
    private ChargeRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public ChargeService() {
    }

    public Charge save(Charge charge) {
        return repository.save(charge);
    }

    public Optional<Charge> findById(String id) {
        return repository.findById(id);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public Charge update(Charge charge) {
        return repository.save(charge);
    }

    public List<Charge> findAll() {
        return repository.findAll();
    }

    public Charge gerarCobranca(Resident resident) {
        Charge charge = new Charge();
        charge.setResident(resident);
        charge.setValue(100.0); // Exemplo de valor fixo, pode ser dinâmico
        charge.setEmissionDate(new Date());
        charge.setDueDate(new Date(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000)); // Vencimento em 30 dias
        charge.setStatus("PENDING"); // Status inicial da cobrança
        charge.setChargeType(ChargeType.MONTHLY_QUOTA);
        return repository.save(charge);
    }

    public List<Charge> obterRelatorios(ResidentAccessDTO accessDto) {
        String url = "http://localhost:8084/graphql"; // URL do serviço de cobrança

        String query = String.format(
                "query ValidarAcesso { validarAcesso(accessDto: { user: \"%s\" password: \"%s\" }) }",
                accessDto.getUser(),
                accessDto.getPassword()
        );

        Map<String, String> requestBody = Map.of("query", query);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        // Parsear JSON
        JsonNode root = null;
        try {
            root = objectMapper.readTree(response.getBody());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        String residentId = root.path("data").path("validarAcesso").asText();

        if (!Objects.equals(residentId, "0")) {
            // Se o acesso for validado, buscar as cobranças
            return repository.findAllByResidentResidentId(residentId);
        } else {
            throw new RuntimeException("Acesso não autorizado");
        }
    }
}
