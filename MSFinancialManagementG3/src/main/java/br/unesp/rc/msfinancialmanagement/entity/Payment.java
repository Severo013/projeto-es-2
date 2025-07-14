package br.unesp.rc.msfinancialmanagement.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import lombok.*;
import java.util.Date;
import java.io.Serializable;

@Document(collection = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private Date paymentDate;
    private double amountPaid;
    private String paymentMethod;

    @DBRef
    private Charge charge;
}
