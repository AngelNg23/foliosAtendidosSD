package com.telcel.dashboard.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
public class FoliosSD implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NO_INCIDENTE")
    private String noIncidente;
    @Column(name = "DESCRIPION")
    private String descripcion;
    @Column(name = "ESTATUS")
    private String estatus;
    @Column(name = "FECHA_HORA_CREACION")
    private Date fechaHoraCreacion;
    @Column(name = "FECHA_HORA_ATENCION")
    private Date fechaHoraAtencion;
    @Column(name = "ASIGNADO")
    private String asignado;
    @Column(name = "CATEGORIA")
    private String categoria;
    @Column(name = "MOTIVO_INCIDENTE")
    private String motivoIncidente;
    @Column(name = "GRUPO")
    private String grupo;
    @Column(name = "LOG_SOLUTION")
    private String logSolution;

}
