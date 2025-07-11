package br.unesp.rc.msresident.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private Long id;
    private String street;
    private String number;
    private String neighborhood;
    private String zipCode;
    private String city;
    private String state;
}
