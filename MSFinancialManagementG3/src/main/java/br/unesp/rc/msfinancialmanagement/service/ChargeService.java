package br.unesp.rc.msfinancialmanagement.service;

import br.unesp.rc.msfinancialmanagement.entity.Charge;
import br.unesp.rc.msfinancialmanagement.repository.ChargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChargeService {

    @Autowired
    private ChargeRepository repository;

    public ChargeService() {
    }

    public Charge save(Charge resident) {
        return repository.save(resident);
    }

    public Charge findById(long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Charge update(Charge resident) {
        return repository.save(resident);
    }

    public List<Charge> findAll() {
        return repository.findAll();
    }
}
