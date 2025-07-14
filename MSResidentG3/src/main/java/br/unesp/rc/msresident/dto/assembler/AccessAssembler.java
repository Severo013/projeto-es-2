package br.unesp.rc.msresident.dto.assembler;

public class AccessAssembler {

    private AccessAssembler() {
        // Private constructor to prevent instantiation
    }

    public static br.unesp.rc.msresident.entity.Access dtoToEntityModel(br.unesp.rc.msresident.dto.AccessDTO dto) {
        if (dto == null) {
            return null;
        }

        br.unesp.rc.msresident.entity.Access entity = new br.unesp.rc.msresident.entity.Access();
        entity.setId(dto.getId());
        entity.setUser(dto.getUser());
        entity.setPassword(dto.getPassword());

        return entity;
    }
}
