package br.unesp.rc.msresident.dto.assembler;

import br.unesp.rc.msresident.dto.AddressDTO;
import br.unesp.rc.msresident.entity.Address;

public class AddressAssembler {

    private AddressAssembler() {

    }

    public static Address dtoToEntityModel(AddressDTO dto) {
        if (dto == null) {
            return null;
        }

        Address address = new Address();
        address.setId(dto.getId());
        address.setStreet(dto.getStreet());
        address.setNumber(dto.getNumber());
        address.setNeighborhood(dto.getNeighborhood());
        address.setZipCode(dto.getZipCode());
        address.setCity(dto.getCity());
        address.setState(dto.getState());

        return address;
    }
}
