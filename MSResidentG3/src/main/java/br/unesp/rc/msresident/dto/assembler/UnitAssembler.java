package br.unesp.rc.msresident.dto.assembler;

import br.unesp.rc.msresident.dto.UnitDTO;
import br.unesp.rc.msresident.entity.Unit;

public class UnitAssembler {

    private UnitAssembler() {

    }

    public static Unit dtoToEntityModel(UnitDTO dto) {
        if (dto == null) {
            return null;
        }

        Unit unit = new Unit();
        unit.setUnitId(dto.getUnitId());
        unit.setLocation(dto.getLocation());
        unit.setSizeSM(dto.getSizeSM());
        unit.setCondominiumId(dto.getCondominiumId());

        // Note: We don't set the resident here to avoid circular reference issues
        // The resident relationship should be managed at the service level

        return unit;
    }
}
