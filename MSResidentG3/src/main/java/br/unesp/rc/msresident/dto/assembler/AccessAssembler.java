package br.unesp.rc.msresident.dto.assembler;

import br.unesp.rc.msresident.dto.AccessDTO;
import br.unesp.rc.msresident.entity.Access;

public class AccessAssembler {

    private AccessAssembler() {

    }

    public static Access dtoToEntityModel(AccessDTO dto) {
        if (dto == null) {
            return null;
        }

        Access access = new Access();
        access.setId(dto.getId());
        access.setUser(dto.getUser());
        access.setPassword(dto.getPassword());

        return access;
    }
}
