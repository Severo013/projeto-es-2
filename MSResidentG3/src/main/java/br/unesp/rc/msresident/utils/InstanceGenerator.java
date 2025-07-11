package br.unesp.rc.msresident.utils;

import br.unesp.rc.msresident.entity.*;

import java.util.Date;

public class InstanceGenerator {

    private InstanceGenerator() {
        // Private constructor to prevent instantiation
    }

    public static Resident getResident(String cpf, String user) {
        Resident resident = new Resident();

        resident.setResidentType(ResidentType.TENANT);

        resident.setName("John Doe");
        resident.setBirthDate(new Date());
        resident.setCpf(cpf);

        Access access = new Access();
        access.setUser(user);
        access.setPassword("password123");
        resident.setAccess(access);

        Address address = new Address();
        address.setStreet("123 Main St");
        address.setCity("Springfield");
        address.setState("IL");
        address.setZipCode("62701");
        address.setNumber("1A");
        address.setNeighborhood("Downtown");
        resident.setAddress(address);

        Contact contact = new Contact();
        contact.setEmail("email@email.com");
        contact.setCellPhone("19123123123");
        contact.setPhoneHome("123456789012312");
        contact.setPhoneCommercial("123456789012312");
        resident.setContact(contact);

        return resident;
    }
}
