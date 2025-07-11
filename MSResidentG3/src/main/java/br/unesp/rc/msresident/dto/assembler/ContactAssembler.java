package br.unesp.rc.msresident.dto.assembler;

import br.unesp.rc.msresident.dto.ContactDTO;
import br.unesp.rc.msresident.entity.Contact;

public class ContactAssembler {

    private ContactAssembler() {

    }

    public static Contact dtoToEntityModel(ContactDTO dto) {
        if (dto == null) {
            return null;
        }

        Contact contact = new Contact();
        contact.setId(dto.getId());
        contact.setPhoneHome(dto.getPhoneHome());
        contact.setPhoneCommercial(dto.getPhoneCommercial());
        contact.setCellPhone(dto.getCellPhone());
        contact.setEmail(dto.getEmail());

        return contact;
    }
}
