package br.unesp.rc.msaccesscontrol.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "resident")
@Data
@NoArgsConstructor
public class Resident extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    @Column(name = "resident_type", nullable = false)
    private ResidentType residentType;

    @Column(name = "unit_id", nullable = false)
    private Long unitId;

    @OneToMany(mappedBy = "resident", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Authorization> authorizations;
}
