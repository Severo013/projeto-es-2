package br.unesp.rc.msresident.service;

import br.unesp.rc.msresident.entity.Resident;
import br.unesp.rc.msresident.utils.InstanceGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResidentServiceTest {

    private Resident entity = InstanceGenerator.getResident("12345678900", "John");;

    @Autowired
    private ResidentService residentService = new ResidentService();

    @Test
    void save() {
        System.out.println("Resident entity created: " + entity);
        Resident savedEntity = residentService.save(entity);
        System.out.println("Resident entity saved: " + savedEntity);
        assertEquals(entity, savedEntity);
    }

    @Test
    void findByCpf() {
        String cpf = "12345678900";
        Resident foundEntity = residentService.findByCpf(cpf);
        System.out.println("Resident entity found: " + foundEntity);
        assertNotNull(foundEntity);
        assertEquals(entity, foundEntity);
    }

    @Test
    void update() {
        entity.setName("Updated Name");
        Resident updatedEntity = residentService.update(entity);
        System.out.println("Resident entity updated: " + updatedEntity);
        assertNotNull(updatedEntity);
        assertEquals("Updated Name", updatedEntity.getName());
    }

    @Test
    void delete() {
        Long id = entity.getId();
        residentService.delete(id);
        Resident deletedEntity = residentService.findByCpf(entity.getCpf());
        System.out.println("Resident entity after deletion: " + deletedEntity);
        assertNull(deletedEntity);
    }

    @Test
    void findAll() {
        List<Resident> result = residentService.findAll();
        for (Resident resident : result) {
            System.out.println("Resident entity: " + resident);
        }
        assertNotNull(result);
    }
}