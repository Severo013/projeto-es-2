package br.unesp.rc.msaccesscontrol.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "visitor")
@Data
@NoArgsConstructor
public class Visitor extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    @Column(name = "visitor_type", nullable = false)
    private VisitorType visitorType;

    @OneToMany(mappedBy = "visitor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Visit> visits;
}
