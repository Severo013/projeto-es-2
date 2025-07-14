package br.unesp.rc.msfinancialmanagement.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;
import java.io.Serializable;

@Document(collection = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String street;
    private int number;
    private String neighborhood;
    private String zipCode;
    private String city;
    private String state;
}
