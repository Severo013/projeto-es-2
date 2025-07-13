package br.unesp.rc.msfinancialmanagement.entity;

import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import java.io.Serializable;

@Document(collection = "residents")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, includeFieldNames=true)
public class Resident implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private long residentId;
    private ResidentType residentType;

    @DBRef
    private Charge charge;
}
