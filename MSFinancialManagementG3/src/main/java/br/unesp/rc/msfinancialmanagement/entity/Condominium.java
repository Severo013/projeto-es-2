package br.unesp.rc.msfinancialmanagement.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import lombok.*;
import java.util.List;
import java.io.Serializable;

@Document(collection = "condominiums")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Condominium implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String name;
    private CondominiumType type;

    private Address address;

    @DBRef
    private List<Unit> units;
}
