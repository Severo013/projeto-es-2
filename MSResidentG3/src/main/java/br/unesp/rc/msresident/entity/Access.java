package br.unesp.rc.msresident.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "access")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Access implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user", nullable = false, unique = true, length = 50)
    private String user;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    public Access() {
    }
}
