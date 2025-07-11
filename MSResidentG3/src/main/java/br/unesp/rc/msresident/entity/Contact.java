package br.unesp.rc.msresident.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contact")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "phone_home", length = 15)
    private String phoneHome;

    @Column(name = "phone_commercial", length = 15)
    private String phoneCommercial;

    @Column(name = "cell_phone", length = 15)
    private String cellPhone;

    @Column(name = "email", length = 100)
    private String email;

    public Contact() {
    }
}
