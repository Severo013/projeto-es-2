package br.unesp.rc.msresident.dto.assembler;

import br.unesp.rc.msresident.dto.ResidentDTO;
import br.unesp.rc.msresident.entity.Access;
import br.unesp.rc.msresident.entity.Resident;
import br.unesp.rc.msresident.entity.Address;
import br.unesp.rc.msresident.entity.ResidentType;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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
        try {
            resident.setBirthDate(dto.getBirthDate() != null ? new java.text.SimpleDateFormat("yyyy-MM-dd").parse(dto.getBirthDate()) : null);
        } catch (ParseException e) {
            resident.setBirthDate(new Date()); // Default to current date if parsing fails
        }
        resident.setCpf(dto.getCpf());
        resident.setResidentType(dto.getResidentType() != null ? ResidentType.valueOf(dto.getResidentType()) : ResidentType.OTHER);
        resident.setContact(ContactAssembler.dtoToEntityModel(dto.getContact()));

        if (dto.getAccess() != null) {
            Access access = new Access();
            access.setId(dto.getAccess().getId()); // Importante: definir o ID para update
            access.setUser(dto.getAccess().getUser());
            access.setPassword(dto.getAccess().getPassword());
            resident.setAccess(access);
        }

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
