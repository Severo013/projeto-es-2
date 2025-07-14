package br.unesp.rc.msaccesscontrol.dto.assembler;

import br.unesp.rc.msaccesscontrol.dto.AuthorizationDTO;
import br.unesp.rc.msaccesscontrol.entity.Authorization;
import br.unesp.rc.msaccesscontrol.entity.AuthorizationStatus;

public class AuthorizationAssembler {

    private AuthorizationAssembler() {
        // Private constructor to prevent instantiation
    }

    public static Authorization dtoToEntityModel(AuthorizationDTO dto) {
        if (dto == null) {
            return null;
        }

        Authorization authorization = new Authorization();
        authorization.setId(dto.getId());
        authorization.setAuthorizationDateTime(dto.getAuthorizationDateTime());
        authorization.setStatus(dto.getStatus() != null ? AuthorizationStatus.valueOf(dto.getStatus()) : null);

        return authorization;
    }
}
