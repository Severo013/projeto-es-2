package br.unesp.rc.msfinancialmanagement.entity;

import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment  {
    private Date paymentDate;
    private double amountPaid;
    private String paymentMethod;
}
