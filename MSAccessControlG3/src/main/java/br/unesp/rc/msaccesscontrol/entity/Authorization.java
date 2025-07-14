package br.unesp.rc.msaccesscontrol.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "authorization")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Authorization implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authorization_date_time", nullable = false)
    private LocalDateTime authorizationDateTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AuthorizationStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resident_id", nullable = true)
    private Resident resident;

    @OneToMany(mappedBy = "authorization", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Visit> visits;
}
