package br.unesp.rc.msaccesscontrol.dto;

import br.unesp.rc.msaccesscontrol.entity.VisitorStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitDTO {

    private Long id;
    private Date entry;
    private Date exit;
    private VisitorStatus status;
    private Long visitorId;
    private Long authorizationId;
}
