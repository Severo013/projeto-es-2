package br.unesp.rc.msaccesscontrol.service;

import br.unesp.rc.msaccesscontrol.entity.Authorization;
import br.unesp.rc.msaccesscontrol.entity.AuthorizationStatus;
import br.unesp.rc.msaccesscontrol.utils.InstanceGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorizationServiceTest {

    private Authorization entity = InstanceGenerator.getAuthorization();

    @Autowired
    private AuthorizationService authorizationService = new AuthorizationService();

    @Test
    void save() {
        System.out.println("Authorization entity created: " + entity);
        Authorization savedEntity = authorizationService.save(entity);
        System.out.println("Authorization entity saved: " + savedEntity);
        assertEquals(entity, savedEntity);
    }

    @Test
    void findByCpf() {
        Optional<Authorization> foundEntity = authorizationService.findById(entity.getId());
        System.out.println("Authorization entity found: " + foundEntity);
        assertNotNull(foundEntity);
        assertEquals(entity, foundEntity);
    }

    @Test
    void update() {
        entity.setStatus(AuthorizationStatus.APPROVED);
        Authorization updatedEntity = authorizationService.update(entity);
        System.out.println("Authorization entity updated: " + updatedEntity);
        assertNotNull(updatedEntity);
        assertEquals(AuthorizationStatus.APPROVED, updatedEntity.getStatus());
    }

    @Test
    void delete() {
        Long id = entity.getId();
        authorizationService.delete(id);
        Optional<Authorization> deletedEntity = authorizationService.findById(entity.getId());
        System.out.println("Authorization entity after deletion: " + deletedEntity);
        assertNull(deletedEntity);
    }

    @Test
    void findAll() {
        List<Authorization> result = authorizationService.findAll();
        for (Authorization authorization : result) {
            System.out.println("Authorization entity: " + authorization);
        }
        assertNotNull(result);
    }
}