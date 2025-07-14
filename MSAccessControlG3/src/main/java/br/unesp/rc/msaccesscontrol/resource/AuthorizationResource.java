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
@RequestMapping("/authorizations/v1")
public class AuthorizationResource {

    @Autowired
    private AuthorizationService AuthorizationService;

    @GetMapping("/")
    public List<Authorization> getAllAuthorizations() {
        return AuthorizationService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Authorization> getById(@PathVariable Long id) {
        return AuthorizationService.findById(id);
    }

    @PostMapping("/")
    public boolean save(@RequestBody AuthorizationDTO authorizationDto) {
        boolean insert = false;

        Authorization Authorization = AuthorizationAssembler.dtoToEntityModel(authorizationDto);
        Authorization authorizationInsert = AuthorizationService.save(Authorization);

        if (authorizationInsert != null) {
            insert = true;
        }

        return insert;
    }

    @PutMapping("/")
    public boolean update(@RequestBody AuthorizationDTO authorizationDto) {
        Optional<Authorization> existingAuthorization = AuthorizationService.findById(authorizationDto.getId());
        if (existingAuthorization.isPresent()) {
            Authorization Authorization = AuthorizationAssembler.dtoToEntityModel(authorizationDto);
            AuthorizationService.update(Authorization);
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
