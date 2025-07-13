package br.unesp.rc.msfinancialmanagement.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import lombok.*;
import java.util.Date;
import java.util.List;

@Document(collection = "charges")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Charge {

    @Id
    private long id;

    private double value;
    private Date emissionDate;
    private Date dueDate;
    private String status;
    private ChargeType chargeType;

    @DBRef
    private Unit unit;

    @DBRef
    private Resident resident;

    @DBRef
    private List<Payment> payments;
}
