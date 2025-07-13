package br.unesp.rc.msfinancialmanagement.dto.assembler;

import br.unesp.rc.msfinancialmanagement.dto.ChargeDTO;
import br.unesp.rc.msfinancialmanagement.entity.Charge;
import br.unesp.rc.msfinancialmanagement.entity.ChargeType;

public class ChargeAssembler {

    private ChargeAssembler() {
        // Private constructor to prevent instantiation
    }

    public static Charge dtoToEntityModel(ChargeDTO dto) {
        if (dto == null) {
            return null;
        }

        Charge charge = new Charge();
        charge.setId(dto.getId());
        charge.setValue(dto.getValue());
        charge.setDueDate(dto.getDueDate());
        charge.setEmissionDate(dto.getEmissionDate());
        charge.setChargeType(dto.getChargeType() != null ? ChargeType.valueOf(dto.getChargeType()) : null);

        return charge;
    }
}
