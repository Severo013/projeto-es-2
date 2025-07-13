package br.unesp.rc.msfinancialmanagement.resource;

import br.unesp.rc.msfinancialmanagement.dto.ChargeDTO;
import br.unesp.rc.msfinancialmanagement.dto.assembler.ChargeAssembler;
import br.unesp.rc.msfinancialmanagement.entity.Charge;
import br.unesp.rc.msfinancialmanagement.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public Charge save(@RequestBody ChargeDTO chargeDto) {
        Charge charge = ChargeAssembler.dtoToEntityModel(chargeDto);
        return chargeService.save(charge);
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable String id, @RequestBody ChargeDTO chargeDto) {
        Optional<Charge> existingCharge = chargeService.findById(id);
        if (existingCharge.isPresent()) {
            Charge charge = ChargeAssembler.dtoToEntityModel(chargeDto);
            chargeService.save(charge);
            return true;
        } else {
            return false;
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
}
