package br.unesp.rc.msfinancialmanagement.service;

import br.unesp.rc.msfinancialmanagement.entity.Charge;
import br.unesp.rc.msfinancialmanagement.utils.InstanceGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChargeServiceTest {

    private Charge entity = InstanceGenerator.getCharge();

    @Autowired
    private ChargeService residentService = new ChargeService();

    @Test
    void save() {
        System.out.println("Charge entity created: " + entity);
        Charge savedEntity = residentService.save(entity);
        System.out.println("Charge entity saved: " + savedEntity);
        assertEquals(entity, savedEntity);
    }

    @Test
    void findByCpf() {
        Optional<Charge> foundEntity = residentService.findById(entity.getId());
        System.out.println("Charge entity found: " + foundEntity);
        assertNotNull(foundEntity);
        assertEquals(entity, foundEntity);
    }

    @Test
    void update() {
        entity.setValue(1000);
        Charge updatedEntity = residentService.update(entity);
        System.out.println("Charge entity updated: " + updatedEntity);
        assertNotNull(updatedEntity);
        assertEquals(1000, updatedEntity.getValue());
    }

    @Test
    void delete() {
        String id = entity.getId();
        residentService.delete(id);
        Optional<Charge> deletedEntity = residentService.findById(entity.getId());
        System.out.println("Charge entity after deletion: " + deletedEntity);
        assertNull(deletedEntity);
    }

    @Test
    void findAll() {
        List<Charge> result = residentService.findAll();
        for (Charge resident : result) {
            System.out.println("Charge entity: " + resident);
        }
        assertNotNull(result);
    }
}