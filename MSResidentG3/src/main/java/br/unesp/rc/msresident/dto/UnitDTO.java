package br.unesp.rc.msresident.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnitDTO {
    private long unitId;
    private String location;
    private double sizeSM;
    private long condominiumId;
    private ResidentDTO resident;
}
