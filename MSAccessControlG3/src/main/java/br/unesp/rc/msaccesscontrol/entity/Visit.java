package br.unesp.rc.msaccesscontrol.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "visit")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Visit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "entry", nullable = true)
    private Date entry;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "exit_time", nullable = true)
    private Date exit;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private VisitorStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visitor_id", nullable = true)
    private Visitor visitor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authorization_id", nullable = true)
    private Authorization authorization;
}