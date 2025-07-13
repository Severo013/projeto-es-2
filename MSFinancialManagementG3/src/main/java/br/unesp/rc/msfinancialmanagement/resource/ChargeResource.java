package br.unesp.rc.msfinancialmanagement.resource;

import br.unesp.rc.msfinancialmanagement.entity.Charge;
import br.unesp.rc.msfinancialmanagement.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/charges/v1")
public class ChargeResource {

    @Autowired
    private ChargeService chargeService;

    @GetMapping("/")
    public List<Charge> getAllCharges() {
        return chargeService.findAll();
    }

    @GetMapping("/report/{id}")
    public String getChargeReport(@PathVariable long id) {
        Charge charge = chargeService.findById(id);
        if (charge != null) {
            return "Charge Report: " + charge.toString();
        } else {
            return "Charge not found";
        }
    }
}
