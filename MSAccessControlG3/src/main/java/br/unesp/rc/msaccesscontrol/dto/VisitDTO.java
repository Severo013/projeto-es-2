package br.unesp.rc.msaccesscontrol.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitDTO {

    private Long id;
    private Date entry;
    private Date exit;
    private String status;
    private Long visitorId;
    private List<AuthorizationDTO> authorizations;
}
