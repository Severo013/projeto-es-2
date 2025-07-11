package br.unesp.rc.msresident.service;

import br.unesp.rc.msresident.entity.Resident;
import br.unesp.rc.msresident.repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResidentService {

    @Autowired
    private ResidentRepository repository;

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
}
