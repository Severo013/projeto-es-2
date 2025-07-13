package br.unesp.rc.msfinancialmanagement.service;

import br.unesp.rc.msfinancialmanagement.entity.Charge;
import br.unesp.rc.msfinancialmanagement.utils.InstanceGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChargeServiceTest {

    private Charge entity = InstanceGenerator.getCharge();

    @Autowired
    private ChargeService residentService = new ChargeService();

    @Test
    void save() {
//        entity = InstanceGenerator.getCharge();
        System.out.println("Charge entity created: " + entity);
        Charge savedEntity = residentService.save(entity);
        System.out.println("Charge entity saved: " + savedEntity);
        assertEquals(entity, savedEntity);
    }

    @Test
    void findByCpf() {
        long id = 1L; // Assuming the ID is known or set in the test data
        Charge foundEntity = residentService.findById(id);
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
        Long id = entity.getId();
        residentService.delete(id);
        Charge deletedEntity = residentService.findById(entity.getId());
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