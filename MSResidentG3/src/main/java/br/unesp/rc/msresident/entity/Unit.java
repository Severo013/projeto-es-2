package br.unesp.rc.msresident.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "unit")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Unit implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_id")
    private long unitId;

    @Column(name = "location", nullable = false, length = 100)
    private String location;

    @Column(name = "size_sm", nullable = false)
    private double sizeSM;

    @Column(name = "condominium_id", nullable = false)
    private long condominiumId;

    @OneToOne(mappedBy = "unit", fetch = FetchType.LAZY)
    private Resident resident;

    public Unit() {
    }
}
