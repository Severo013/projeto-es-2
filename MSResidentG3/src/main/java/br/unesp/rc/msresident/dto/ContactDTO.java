package br.unesp.rc.msresident.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {
    private Long id;
    private String phoneHome;
    private String phoneCommercial;
    private String cellPhone;
    private String email;
}
