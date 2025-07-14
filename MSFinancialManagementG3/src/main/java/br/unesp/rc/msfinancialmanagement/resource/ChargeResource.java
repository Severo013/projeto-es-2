package br.unesp.rc.msfinancialmanagement.resource;

import br.unesp.rc.msfinancialmanagement.dto.ChargeDTO;
import br.unesp.rc.msfinancialmanagement.dto.ResidentAccessDTO;
import br.unesp.rc.msfinancialmanagement.dto.ResidentDTO;
import br.unesp.rc.msfinancialmanagement.dto.assembler.ChargeAssembler;
import br.unesp.rc.msfinancialmanagement.dto.assembler.ResidentAssembler;
import br.unesp.rc.msfinancialmanagement.entity.Charge;
import br.unesp.rc.msfinancialmanagement.entity.Resident;
import br.unesp.rc.msfinancialmanagement.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/charges/v1")
public class ChargeResource {

    @Autowired
    private ChargeService chargeService;

    @GetMapping("/")
    public List<Charge> getAllCharges() {
        return chargeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Charge> getById(@PathVariable String id) {
        Optional<Charge> charge = chargeService.findById(id);
        if (charge.isPresent()) {
            return charge;
        } else {
            return null;
        }
    }

    @PostMapping("/")
    public boolean save(@RequestBody ChargeDTO chargeDto) {
        boolean insert = false;

        Charge charge = ChargeAssembler.dtoToEntityModel(chargeDto);
        Charge chargeInsert = chargeService.save(charge);

        if (chargeInsert != null) {
            insert = true;
        }

        return insert;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Charge> update(@PathVariable String id, @RequestBody ChargeDTO chargeDto) {
        try {
            Optional<Charge> existingCharge = chargeService.findById(id);

            if (existingCharge.isPresent()) {
                Charge charge = ChargeAssembler.dtoToEntityModel(chargeDto);
                charge.setId(id); // Garantir que o ID seja mantido

                Charge updatedCharge = chargeService.update(charge);
                return ResponseEntity.ok(updatedCharge);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id) {
        Optional<Charge> existingCharge = chargeService.findById(id);
        if (existingCharge.isPresent()) {
            chargeService.delete(id);
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/report/{id}")
    public String getChargeReport(@PathVariable String id) {
        Optional<Charge> charge = chargeService.findById(id);
        if (charge.isPresent()) {
            return "Charge Report: " + charge.toString();
        } else {
            return "Charge not found";
        }
    }

    @PostMapping("/gerarCobranca")
    public String gerarCobranca(@RequestBody ResidentDTO residentDto) {
        System.out.println("Gerando cobrança para o residente: " + residentDto.toString());
        Resident resident = ResidentAssembler.dtoToEntityModel(residentDto);
        return chargeService.gerarCobranca(resident).toString();
    }

    @GetMapping("/obterRelatorio")
    public List<Charge> obterRelatorios(@RequestBody ResidentAccessDTO accessDto) {
        return chargeService.obterRelatorios(accessDto);
    }
}
