package br.unesp.rc.msresident.resource;

import br.unesp.rc.msresident.dto.ResidentDTO;
import br.unesp.rc.msresident.dto.assembler.ResidentAssembler;
import br.unesp.rc.msresident.entity.Resident;
import br.unesp.rc.msresident.entity.Unit;
import br.unesp.rc.msresident.service.ResidentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ResidentResource {

    private final ResidentService residentService;

    public ResidentResource(ResidentService residentService) {
        this.residentService = residentService;
    }

    @QueryMapping
    public List<Resident> findAllResidents() {
        return residentService.findAll();
    }

    @QueryMapping
    public Resident findResidentByCpf(@Argument String cpf) {
        return residentService.findByCpf(cpf);
    }

    @MutationMapping
    public Resident saveResident(@Argument ResidentDTO residentDto) {
        Resident resident = ResidentAssembler.dtoToEntityModel(residentDto);
        return residentService.save(resident);
    }

    @MutationMapping
    public Resident updateResident(@Argument ResidentDTO residentDto) {
        Resident resident = ResidentAssembler.dtoToEntityModel(residentDto);
        return residentService.update(resident);
    }

    @MutationMapping
    public Boolean deleteResident(@Argument Long id) {
        try {
            residentService.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
