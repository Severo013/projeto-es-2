package br.unesp.rc.msresident.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ResidentDTO extends PersonDTO {
    private String residentType;

    public ResidentDTO(long id, String name, String birthDate, String cpf, ContactDTO contact, List<AddressDTO> addresses, AccessDTO access, String residentType, UnitDTO unit) {
        super(id, name, birthDate, cpf, contact, addresses, access);
        this.residentType = residentType;
    }
}
