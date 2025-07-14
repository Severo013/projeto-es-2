package br.unesp.rc.msaccesscontrol.dto.assembler;

import br.unesp.rc.msaccesscontrol.dto.VisitDTO;
import br.unesp.rc.msaccesscontrol.entity.Visit;
import br.unesp.rc.msaccesscontrol.entity.Visitor;
import br.unesp.rc.msaccesscontrol.entity.VisitorStatus;
import br.unesp.rc.msaccesscontrol.repository.VisitorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VisitAssembler {

    @PersistenceContext
    private EntityManager entityManager;

    public Visit dtoToEntityModel(VisitDTO dto) {
        if (dto == null) return null;

        Visit visit = new Visit();
        visit.setId(dto.getId());
        visit.setEntry(dto.getEntry());
        visit.setExit(dto.getExit());
        visit.setStatus(dto.getStatus() != null ? VisitorStatus.valueOf(dto.getStatus()) : null);

        if (dto.getVisitorId() != null) {
            Visitor visitor = entityManager.getReference(Visitor.class, dto.getVisitorId());
            visit.setVisitor(visitor);
        }

        return visit;
    }
}
