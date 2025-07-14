package br.unesp.rc.msaccesscontrol.resource;

import br.unesp.rc.msaccesscontrol.dto.AuthorizationDTO;
import br.unesp.rc.msaccesscontrol.dto.assembler.AuthorizationAssembler;
import br.unesp.rc.msaccesscontrol.entity.Authorization;
import br.unesp.rc.msaccesscontrol.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Authorizations/v1")
public class AuthorizationResource {

    @Autowired
    private AuthorizationService AuthorizationService;

    @GetMapping("/")
    public List<Authorization> getAllAuthorizations() {
        return AuthorizationService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Authorization> getById(@PathVariable Long id) {
        Optional<Authorization> Authorization = AuthorizationService.findById(id);
        if (Authorization.isPresent()) {
            return Authorization;
        } else {
            return null;
        }
    }

    @PostMapping("/")
    public Authorization save(@RequestBody AuthorizationDTO AuthorizationDto) {
        Authorization Authorization = AuthorizationAssembler.dtoToEntityModel(AuthorizationDto);
        return AuthorizationService.save(Authorization);
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable Long id, @RequestBody AuthorizationDTO AuthorizationDto) {
        Optional<Authorization> existingAuthorization = AuthorizationService.findById(id);
        if (existingAuthorization.isPresent()) {
            Authorization Authorization = AuthorizationAssembler.dtoToEntityModel(AuthorizationDto);
            AuthorizationService.save(Authorization);
            return true;
        } else {
            return false;
        }
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        Optional<Authorization> existingAuthorization = AuthorizationService.findById(id);
        if (existingAuthorization.isPresent()) {
            AuthorizationService.delete(id);
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/report/{id}")
    public String getAuthorizationReport(@PathVariable Long id) {
        Optional<Authorization> Authorization = AuthorizationService.findById(id);
        if (Authorization.isPresent()) {
            return "Authorization Report: " + Authorization.toString();
        } else {
            return "Authorization not found";
        }
    }
}
