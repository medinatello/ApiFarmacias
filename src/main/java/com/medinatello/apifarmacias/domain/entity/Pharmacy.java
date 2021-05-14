package com.medinatello.apifarmacias.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Calendar;

@Entity(name = "Pharmacy")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(insertable = true, updatable = false, nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar fecha;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long local_id;
    private String local_nombre;
    private String comuna_nombre;
    private String localidad_nombre;
    private String local_direccion;
    private Calendar funcionamiento_hora_apertura;
    private Calendar funcionamiento_hora_cierre;
    private String local_telefono;
    private String local_lat;
    private Long local_lng;
    private Long funcionamiento_dia;
    private Integer fk_region;
    private Integer fk_comuna;

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public Long getLocal_id() {
        return local_id;
    }

    public void setLocal_id(Long local_id) {
        this.local_id = local_id;
    }

    public String getLocal_nombre() {
        return local_nombre;
    }

    public void setLocal_nombre(String local_nombre) {
        this.local_nombre = local_nombre;
    }

    public String getComuna_nombre() {
        return comuna_nombre;
    }

    public void setComuna_nombre(String comuna_nombre) {
        this.comuna_nombre = comuna_nombre;
    }

    public String getLocalidad_nombre() {
        return localidad_nombre;
    }

    public void setLocalidad_nombre(String localidad_nombre) {
        this.localidad_nombre = localidad_nombre;
    }

    public String getLocal_direccion() {
        return local_direccion;
    }

    public void setLocal_direccion(String local_direccion) {
        this.local_direccion = local_direccion;
    }

    public Calendar getFuncionamiento_hora_apertura() {
        return funcionamiento_hora_apertura;
    }

    public void setFuncionamiento_hora_apertura(Calendar funcionamiento_hora_apertura) {
        this.funcionamiento_hora_apertura = funcionamiento_hora_apertura;
    }

    public Calendar getFuncionamiento_hora_cierre() {
        return funcionamiento_hora_cierre;
    }

    public void setFuncionamiento_hora_cierre(Calendar funcionamiento_hora_cierre) {
        this.funcionamiento_hora_cierre = funcionamiento_hora_cierre;
    }

    public String getLocal_telefono() {
        return local_telefono;
    }

    public void setLocal_telefono(String local_telefono) {
        this.local_telefono = local_telefono;
    }

    public String getLocal_lat() {
        return local_lat;
    }

    public void setLocal_lat(String local_lat) {
        this.local_lat = local_lat;
    }

    public Long getLocal_lng() {
        return local_lng;
    }

    public void setLocal_lng(Long local_lng) {
        this.local_lng = local_lng;
    }

    public Long getFuncionamiento_dia() {
        return funcionamiento_dia;
    }

    public void setFuncionamiento_dia(Long funcionamiento_dia) {
        this.funcionamiento_dia = funcionamiento_dia;
    }

    public Integer getFk_region() {
        return fk_region;
    }

    public void setFk_region(Integer fk_region) {
        this.fk_region = fk_region;
    }

    public Integer getFk_comuna() {
        return fk_comuna;
    }

    public void setFk_comuna(Integer fk_comuna) {
        this.fk_comuna = fk_comuna;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }
}
