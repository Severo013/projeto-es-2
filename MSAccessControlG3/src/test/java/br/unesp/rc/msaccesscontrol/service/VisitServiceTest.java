package br.unesp.rc.msaccesscontrol.service;

import br.unesp.rc.msaccesscontrol.entity.Visit;
import br.unesp.rc.msaccesscontrol.entity.VisitorStatus;
import br.unesp.rc.msaccesscontrol.utils.InstanceGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VisitServiceTest {

    private Visit entity = InstanceGenerator.getVisit();

    @Autowired
    private VisitService residentService = new VisitService();

    @Test
    void save() {
        System.out.println("Visit entity created: " + entity);
        Visit savedEntity = residentService.save(entity);
        System.out.println("Visit entity saved: " + savedEntity);
        assertEquals(entity, savedEntity);
    }

    @Test
    void findByCpf() {
        Optional<Visit> foundEntity = residentService.findById(entity.getId());
        System.out.println("Visit entity found: " + foundEntity);
        assertNotNull(foundEntity);
        assertEquals(entity, foundEntity);
    }

    @Test
    void update() {
        entity.setStatus(VisitorStatus.AUTHORIZED);
        Visit updatedEntity = residentService.update(entity);
        System.out.println("Visit entity updated: " + updatedEntity);
        assertNotNull(updatedEntity);
        assertEquals(VisitorStatus.AUTHORIZED, updatedEntity.getStatus());
    }

    @Test
    void delete() {
        Long id = entity.getId();
        residentService.delete(id);
        Optional<Visit> deletedEntity = residentService.findById(entity.getId());
        System.out.println("Visit entity after deletion: " + deletedEntity);
        assertNull(deletedEntity);
    }

    @Test
    void findAll() {
        List<Visit> result = residentService.findAll();
        for (Visit resident : result) {
            System.out.println("Visit entity: " + resident);
        }
        assertNotNull(result);
    }
}