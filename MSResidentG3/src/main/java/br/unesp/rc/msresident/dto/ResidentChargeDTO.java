package br.unesp.rc.msresident.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResidentChargeDTO {

    private Long residentId;
    private String residentType;
}
