package com.vetun.apirest.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

@Entity
@Table(name="mascotas")
public class Mascota {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_mascota")
    private int idMascota;

    @ManyToOne
    @JoinColumn(name="cedula_dueno")
    private Dueno cedulaDueno;

    @Column(name="nombre_mascota")
    private String nombreMascota;

    @Column(name="especie")
    private String especie;

    @Column(name="raza")
    private String raza;

    public Mascota(){}

    public Mascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public Dueno getCedulaDueno() {
        return cedulaDueno;
    }

    public void setCedulaDueno(Dueno cedulaDueno) {
        this.cedulaDueno = cedulaDueno;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "idMascota=" + idMascota +
                ", cedulaDueno='" + cedulaDueno + '\'' +
                ", nombreMascota='" + nombreMascota + '\'' +
                ", especie=" + especie +
                ", raza='" + raza + '\'' +
                '}';
    }
}
