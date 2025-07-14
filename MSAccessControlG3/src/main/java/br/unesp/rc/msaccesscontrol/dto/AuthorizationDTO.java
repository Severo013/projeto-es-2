package br.unesp.rc.msaccesscontrol.dto;

import br.unesp.rc.msaccesscontrol.entity.AuthorizationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizationDTO {

    private Long id;
    private LocalDateTime authorizationDateTime;
    private String status;
    private Long residentId;
    private Long visitId;
}
