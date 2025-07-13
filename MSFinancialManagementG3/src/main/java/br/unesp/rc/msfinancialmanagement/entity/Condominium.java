package br.unesp.rc.msfinancialmanagement.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import lombok.*;
import java.util.List;

@Document(collection = "condominiums")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Condominium {

    @Id
    private String id;

    private String name;
    private CondominiumType type;

    private Address address;

    @DBRef
    private List<Unit> units;
}
