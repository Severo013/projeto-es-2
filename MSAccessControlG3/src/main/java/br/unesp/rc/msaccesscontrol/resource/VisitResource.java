package br.unesp.rc.msaccesscontrol.resource;

import br.unesp.rc.msaccesscontrol.dto.VisitDTO;
import br.unesp.rc.msaccesscontrol.dto.assembler.VisitAssembler;
import br.unesp.rc.msaccesscontrol.entity.Visit;
import br.unesp.rc.msaccesscontrol.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Visits/v1")
public class VisitResource {

    @Autowired
    private VisitService VisitService;

    @GetMapping("/")
    public List<Visit> getAllVisits() {
        return VisitService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Visit> getById(@PathVariable Long id) {
        Optional<Visit> Visit = VisitService.findById(id);
        if (Visit.isPresent()) {
            return Visit;
        } else {
            return null;
        }
    }

    @PostMapping("/")
    public Visit save(@RequestBody VisitDTO VisitDto) {
        Visit Visit = VisitAssembler.dtoToEntityModel(VisitDto);
        return VisitService.save(Visit);
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable Long id, @RequestBody VisitDTO VisitDto) {
        Optional<Visit> existingVisit = VisitService.findById(id);
        if (existingVisit.isPresent()) {
            Visit Visit = VisitAssembler.dtoToEntityModel(VisitDto);
            VisitService.save(Visit);
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
