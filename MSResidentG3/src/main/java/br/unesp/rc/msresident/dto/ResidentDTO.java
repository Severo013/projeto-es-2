package br.unesp.rc.msresident.dto;

import br.unesp.rc.msresident.entity.ResidentType;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ResidentDTO extends PersonDTO {
    private ResidentType residentType;
    private UnitDTO unit;

    public ResidentDTO(long id, String name, Date birthDate, String cpf, ContactDTO contact, List<AddressDTO> addresses, AccessDTO access, ResidentType residentType, UnitDTO unit) {
        super(id, name, birthDate, cpf, contact, addresses, access);
        this.residentType = residentType;
        this.unit = unit;
    }
}
