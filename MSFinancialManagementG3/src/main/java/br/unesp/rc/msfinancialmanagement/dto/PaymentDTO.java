package br.unesp.rc.msfinancialmanagement.dto;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PaymentDTO {
    private Date paymentDate;
    private double amountPaid;
    private String paymentMethod;
}
