package br.unesp.rc.msfinancialmanagement.service;

import br.unesp.rc.msfinancialmanagement.entity.Charge;
import br.unesp.rc.msfinancialmanagement.repository.ChargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ChargeService {

    @Autowired
    private ChargeRepository repository;

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
}
