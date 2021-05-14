package com.medinatello.apifarmacias.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity(name = "Pharmacy")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Double id;


    private String fecha;
    private Double local_id;
    private String local_nombre;
    private String comuna_nombre;
    private String localidad_nombre;
    private String local_direccion;
    private String funcionamiento_hora_apertura;
    private String funcionamiento_hora_cierre;
    private String local_telefono;
    private String local_lat;
    private String local_lng;
    private String funcionamiento_dia;
    private Integer fk_region;
    private Integer fk_comuna;

    public void setId(Double id) {
        this.id = id;
    }


    public Double getId() {
        return id;
    }

    public Double getLocal_id() {
        return local_id;
    }

    public void setLocal_id(Double local_id) {
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

    public String getFuncionamiento_hora_apertura() {
        return funcionamiento_hora_apertura;
    }

    public void setFuncionamiento_hora_apertura(String funcionamiento_hora_apertura) {
        this.funcionamiento_hora_apertura = funcionamiento_hora_apertura;
    }

    public String getFuncionamiento_hora_cierre() {
        return funcionamiento_hora_cierre;
    }

    public void setFuncionamiento_hora_cierre(String funcionamiento_hora_cierre) {
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

    public String getLocal_lng() {
        return local_lng;
    }

    public void setLocal_lng(String local_lng) {
        this.local_lng = local_lng;
    }

    public String getFuncionamiento_dia() {
        return funcionamiento_dia;
    }

    public void setFuncionamiento_dia(String funcionamiento_dia) {
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
