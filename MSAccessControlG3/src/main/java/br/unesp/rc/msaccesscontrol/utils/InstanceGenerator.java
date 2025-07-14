package br.unesp.rc.msaccesscontrol.utils;

import br.unesp.rc.msaccesscontrol.entity.Authorization;
import br.unesp.rc.msaccesscontrol.entity.AuthorizationStatus;
import br.unesp.rc.msaccesscontrol.entity.Visit;
import br.unesp.rc.msaccesscontrol.entity.VisitorStatus;

import java.time.LocalDateTime;
import java.util.Date;

public class InstanceGenerator {

    private InstanceGenerator() {
        // Private constructor to prevent instantiation
    }

    public static Visit getVisit() {
        return Visit.builder()
                .id(1L)
                .entry(new Date())
                .exit(null)
                .status(VisitorStatus.WAITING)
                .visitor(null)
                .authorizations(null)
                .build();
    }

    public static Authorization getAuthorization() {
        return Authorization.builder()
                .id(1L)
                .authorizationDateTime(LocalDateTime.now())
                .status(AuthorizationStatus.PENDING)
                .resident(null)
                .visit(null)
                .build();
    }
}
