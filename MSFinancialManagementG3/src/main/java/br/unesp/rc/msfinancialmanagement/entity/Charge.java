package br.unesp.rc.msfinancialmanagement.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.io.Serializable;

@Document(collection = "charges")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Charge implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private double value;
    private Date emissionDate;
    private Date dueDate;
    private String status;
    private ChargeType chargeType;
    private List<Payment> payments;
    private Resident resident;

    //remover?
    @DBRef
    private Unit unit;
}
