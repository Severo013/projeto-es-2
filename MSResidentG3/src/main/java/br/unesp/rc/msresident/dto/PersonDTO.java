package br.unesp.rc.msresident.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    private long id;
    private String name;
    private Date birthDate;
    private String cpf;
    private ContactDTO contact;
    private List<AddressDTO> addresses;
    private AccessDTO access;
}
