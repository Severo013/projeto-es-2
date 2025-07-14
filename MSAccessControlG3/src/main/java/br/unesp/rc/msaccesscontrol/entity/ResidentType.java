package br.unesp.rc.msaccesscontrol.entity;

import java.io.Serializable;

public enum ResidentType implements Serializable {
    OWNER,
    TENANT,
    OTHER;

    private static final long serialVersionUID = 1L;
}