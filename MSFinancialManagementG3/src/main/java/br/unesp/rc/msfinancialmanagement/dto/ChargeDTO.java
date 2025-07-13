package br.unesp.rc.msfinancialmanagement.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ChargeDTO {

    private String id;
    private String residentId;
    private String unitId;
    private double value;
    private Date emissionDate;
    private Date dueDate;
    private String status;
    private String chargeType;

    private List<PaymentDTO> payments;
}
