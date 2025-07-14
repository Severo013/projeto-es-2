package br.unesp.rc.msfinancialmanagement.dto;

import lombok.Getter;

@Getter
public class ResidentAccessDTO {

    private ResidentAccessDTO() {
        // Default constructor
    }

    private Long id;
    private String user;
    private String password;
}
