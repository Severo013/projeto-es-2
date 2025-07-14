package br.unesp.rc.msaccesscontrol.resource;

import br.unesp.rc.msaccesscontrol.dto.VisitDTO;
import br.unesp.rc.msaccesscontrol.dto.assembler.VisitAssembler;
import br.unesp.rc.msaccesscontrol.dto.assembler.VisitAssembler;
import br.unesp.rc.msaccesscontrol.entity.Visit;
import br.unesp.rc.msaccesscontrol.entity.Visit;
import br.unesp.rc.msaccesscontrol.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/visits/v1")
public class VisitResource {

    @Autowired
    private VisitAssembler visitAssembler;

    @Autowired
    private VisitService VisitService;

    @GetMapping("/")
    public List<Visit> getAllVisits() {
        return VisitService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Visit> getById(@PathVariable Long id) {
        return VisitService.findById(id);
    }

    @PostMapping("/")
    public boolean save(@RequestBody VisitDTO visitDto) {
        boolean insert = false;

        Visit visit = visitAssembler.dtoToEntityModel(visitDto);
        Visit visitInsert = VisitService.save(visit);

        if (visitInsert != null) {
            insert = true;
        }

        return insert;
    }

    @PostMapping("/registrarVisita")
    public String registrarVisita(@RequestBody VisitDTO visitDto) {
        Visit visit = visitAssembler.dtoToEntityModel(visitDto);
        return VisitService.registrarVisita(visit);
    }

    @PutMapping("/")
    public boolean update(@RequestBody VisitDTO visitDto) {
        Optional<Visit> existingVisit = VisitService.findById(visitDto.getId());
        if (existingVisit.isPresent()) {
            Visit Visit = visitAssembler.dtoToEntityModel(visitDto);
            VisitService.update(Visit);
            return true;
        } else {
            return false;
        }
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        Optional<Visit> existingVisit = VisitService.findById(id);
        if (existingVisit.isPresent()) {
            VisitService.delete(id);
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/report/{id}")
    public String getVisitReport(@PathVariable Long id) {
        Optional<Visit> Visit = VisitService.findById(id);
        if (Visit.isPresent()) {
            return "Visit Report: " + Visit.toString();
        } else {
            return "Visit not found";
        }
    }
}
