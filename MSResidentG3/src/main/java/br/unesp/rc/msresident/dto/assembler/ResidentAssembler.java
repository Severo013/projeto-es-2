package br.unesp.rc.msresident.dto.assembler;

import br.unesp.rc.msresident.dto.ResidentDTO;
import br.unesp.rc.msresident.entity.Resident;
import br.unesp.rc.msresident.entity.Address;

import java.util.ArrayList;
import java.util.List;

public class ResidentAssembler {

    private ResidentAssembler() {

    }

    public static Resident dtoToEntityModel(ResidentDTO dto){
        if (dto == null) {
            return null;
        }

        Resident resident = new Resident();
        resident.setId(dto.getId());
        resident.setName(dto.getName());
        resident.setBirthDate(dto.getBirthDate());
        resident.setCpf(dto.getCpf());
        resident.setResidentType(dto.getResidentType());
        resident.setContact(ContactAssembler.dtoToEntityModel(dto.getContact()));
        resident.setAccess(AccessAssembler.dtoToEntityModel(dto.getAccess()));
        resident.setUnit(UnitAssembler.dtoToEntityModel(dto.getUnit()));

        // Convert List<AddressDTO> to List<Address>
        if (dto.getAddresses() != null) {
            List<Address> addresses = new ArrayList<>();
            for (var addressDTO : dto.getAddresses()) {
                addresses.add(AddressAssembler.dtoToEntityModel(addressDTO));
            }
            resident.setAddresses(addresses);
        }

        return resident;
    }
}
