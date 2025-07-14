package br.unesp.rc.msfinancialmanagement.dto.assembler;

import br.unesp.rc.msfinancialmanagement.dto.ResidentDTO;
import br.unesp.rc.msfinancialmanagement.entity.Resident;
import br.unesp.rc.msfinancialmanagement.entity.ResidentType;

public class ResidentAssembler {

    private ResidentAssembler() {
        // Private constructor to prevent instantiation
    }

    public static Resident dtoToEntityModel(ResidentDTO dto) {
        if (dto == null) {
            return null;
        }

        Resident entity = new Resident();
        entity.setResidentId(String.valueOf(dto.getResidentId()));
        entity.setResidentType(ResidentType.valueOf(dto.getResidentType()));

        return entity;
    }
}
