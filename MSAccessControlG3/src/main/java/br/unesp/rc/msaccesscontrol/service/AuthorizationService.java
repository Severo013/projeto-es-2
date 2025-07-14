package br.unesp.rc.msaccesscontrol.service;

import br.unesp.rc.msaccesscontrol.entity.Authorization;
import br.unesp.rc.msaccesscontrol.repository.AuthorizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorizationService {

    @Autowired
    private AuthorizationRepository repository;

    public AuthorizationService() {
    }

    public Authorization save(Authorization authorization) {
        return repository.save(authorization);
    }

    public Optional<Authorization> findById(Long id) {return repository.findById(id);}

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Authorization update(Authorization authorization) {
        return repository.save(authorization);
    }

    public List<Authorization> findAll() {
        return repository.findAll();
    }
}
