package br.unesp.rc.msfinancialmanagement.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

@Document(collection = "units")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Unit implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String unitId;

    private String location;
    private double sizeSM;
    private String condominiumId;

    public Unit() {
    }
}
