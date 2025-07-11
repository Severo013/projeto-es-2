package br.unesp.rc.msresident.dto.assembler;

import br.unesp.rc.msresident.dto.PersonDTO;
import br.unesp.rc.msresident.entity.Person;
import br.unesp.rc.msresident.entity.Address;

import java.util.ArrayList;
import java.util.List;

public class PersonAssembler {

    private PersonAssembler() {

    }

    public static Person dtoToEntityModel(PersonDTO dto) {
        if (dto == null) {
            return null;
        }

        Person person = new Person();
        person.setId(dto.getId());
        person.setName(dto.getName());
        person.setBirthDate(dto.getBirthDate());
        person.setCpf(dto.getCpf());
        person.setContact(ContactAssembler.dtoToEntityModel(dto.getContact()));
        person.setAccess(AccessAssembler.dtoToEntityModel(dto.getAccess()));

        // Convert List<AddressDTO> to List<Address>
        if (dto.getAddresses() != null) {
            List<Address> addresses = new ArrayList<>();
            for (var addressDTO : dto.getAddresses()) {
                addresses.add(AddressAssembler.dtoToEntityModel(addressDTO));
            }
            person.setAddresses(addresses);
        }

        return person;
    }
}
