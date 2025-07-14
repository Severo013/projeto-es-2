package br.unesp.rc.msaccesscontrol.dto.assembler;

import br.unesp.rc.msaccesscontrol.dto.VisitDTO;
import br.unesp.rc.msaccesscontrol.entity.Visit;
import br.unesp.rc.msaccesscontrol.entity.VisitorStatus;

public class VisitAssembler {

    private VisitAssembler() {
        // Private constructor to prevent instantiation
    }

    public static Visit dtoToEntityModel(VisitDTO dto) {
        if (dto == null) {
            return null;
        }

        Visit visit = new Visit();
        visit.setId(dto.getId());
        visit.setEntry(dto.getEntry());
        visit.setExit(dto.getExit());
        visit.setStatus(dto.getStatus());

        return visit;
    }
}
