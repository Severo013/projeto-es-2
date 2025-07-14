package br.unesp.rc.msaccesscontrol.dto;

import br.unesp.rc.msaccesscontrol.entity.AuthorizationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizationDTO {

    private Long id;
    private LocalDateTime authorizationDateTime;
    private AuthorizationStatus status;
    private Long residentId;
    private List<Long> visitIds;
}
