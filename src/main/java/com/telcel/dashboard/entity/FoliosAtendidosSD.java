/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.dashboard.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author Angel
 */
@Entity
@Data
public class FoliosAtendidosSD implements Serializable{
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "NUM_INCIDENTE")
    private long numIncidente;
    @Column(name = "DESCRIPCION")
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
    @Column(name = "CI_RELACIONADO")
    private String ciRelacionado;
    @Column(name = "MOTIVO_DE_INCIDENCIA")
    private String motivoDeIncidencia;
    @Column(name = "GRUPO")
    private String grupo;
    @Column(name = "LOG_SOLUTION")
    private String logSolution;
    
}
