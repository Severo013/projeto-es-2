package br.unesp.rc.msaccesscontrol.service;

import br.unesp.rc.msaccesscontrol.entity.Visit;
import br.unesp.rc.msaccesscontrol.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VisitService {

    @Autowired
    private VisitRepository repository;

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
}
