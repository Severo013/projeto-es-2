package br.unesp.rc.msaccesscontrol.entity;

import java.io.Serializable;

public enum VisitorType implements Serializable {
    RELATIVE,
    SERVICE_PROVIDER,
    OTHER;

    private static final long serialVersionUID = 1L;
}
