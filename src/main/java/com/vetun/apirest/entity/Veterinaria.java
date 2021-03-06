package com.vetun.apirest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="veterinaria")
public class Veterinaria {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_veterinaria")
    private int idVeterinaria;

    @Column(name="nombre_veterinaria")
    private String nombreVeterinaria;

    @Column(name="direccion_veterinaria")
    private String direccionVeterinaria;

    @Column(name="telefono_veterinaria")
    private int telefonoVeterinaria;

    @Column(name="localizacion")
    private String localizacion;

    @Column(name="tipo_veterinaria")
    private String tipoVeterinaria;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idVeterinaria")
    private List<Medicos> medicos;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idVeterinaria")
    private List<Citas> citas;

    public Veterinaria() {

    }

    public int getIdVeterinaria() {
        return idVeterinaria;
    }

    public void setIdVeterinaria(int idVeterinaria) {
        this.idVeterinaria = idVeterinaria;
    }

    public String getNombreVeterinaria() {
        return nombreVeterinaria;
    }

    public void setNombreVeterinaria(String nombreVeterinaria) {
        this.nombreVeterinaria = nombreVeterinaria;
    }

    public String getDireccionVeterinaria() {
        return direccionVeterinaria;
    }

    public void setDireccionVeterinaria(String direccionVeterinaria) {
        this.direccionVeterinaria = direccionVeterinaria;
    }

    public int getTelefonoVeterinaria() {
        return telefonoVeterinaria;
    }

    public void setTelefonoVeterinaria(int telefonoVeterinaria) {
        this.telefonoVeterinaria = telefonoVeterinaria;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getTipoVeterinaria() {
        return tipoVeterinaria;
    }

    public void setTipoVeterinaria(String tipoVeterinaria) {
        this.tipoVeterinaria = tipoVeterinaria;
    }

    public List<Medicos> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medicos> medicos) {
        this.medicos = medicos;
    }

    public List<Citas> getCitas() {
        return citas;
    }

    public void setCitas(List<Citas> citas) {
        this.citas = citas;
    }

    @Override
    public String toString() {
        return "Veterinaria{" +
                "idVeterinaria=" + idVeterinaria +
                ", nombreVeterinaria=" + nombreVeterinaria +
                ", direccionVeterinaria=" + direccionVeterinaria +
                ", telefonoVeterinaria=" + telefonoVeterinaria +
                ", localizacion=" + localizacion +
                ", tipoVeterinaria=" + tipoVeterinaria +
                ", medicos=" + medicos +
                '}';
    }
}
