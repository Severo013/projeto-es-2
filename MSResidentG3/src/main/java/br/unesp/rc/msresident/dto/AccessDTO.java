package br.unesp.rc.msresident.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccessDTO {
    private Long id;
    private String user;
    private String password;
}
