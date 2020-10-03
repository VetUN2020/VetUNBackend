package com.vetun.apirest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="dueno")
public class Dueno {
    @Id
    @Column(name="id_dueno")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idDueno;

    @Column(name="cedula_dueno")
    private String cedulaDueno;

    @Column(name="nombre_dueno")
    private String nombreDueno;

    @Column(name="apellido_dueno")
    private String apellidoDueno;

    @Column(name="telefono_dueno")
    private int telefonoDueno;

    @Column(name="direccion_casa")
    private String direccionCasa;

    @Column(name="correo_electronico")
    private String correoElectronico;

    @Column(name="contrasenia_dueno")
    private String contraseniaDueno;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idDueno")
    private List<Mascota> mascotas;

    public Dueno(){

    }

    public Dueno(int idDueno, String correoElectronico, String contraseniaDueno) {
        this.idDueno = idDueno;
        this.correoElectronico = correoElectronico;
        this.contraseniaDueno = contraseniaDueno;
    }

    public int getIdDueno() {
        return idDueno;
    }

    public void setIdDueno(int idDueno) {
        this.idDueno = idDueno;
    }

    public Dueno(String cedulaDueno) {
        this.cedulaDueno = cedulaDueno;
    }

    public String getCedulaDueno() {
        return cedulaDueno;
    }

    public void setCedulaDueno(String cedulaDueno) {
        this.cedulaDueno = cedulaDueno;
    }

    public String getNombreDueno() {
        return nombreDueno;
    }

    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }

    public String getApellidoDueno() {
        return apellidoDueno;
    }

    public void setApellidoDueno(String apellidoDueno) {
        this.apellidoDueno = apellidoDueno;
    }

    public int getTelefonoDueno() {
        return telefonoDueno;
    }

    public void setTelefonoDueno(int telefonoDueno) {
        this.telefonoDueno = telefonoDueno;
    }

    public String getDireccionCasa() {
        return direccionCasa;
    }

    public void setDireccionCasa(String direccionCasa) {
        this.direccionCasa = direccionCasa;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContraseniaDueno() {
        return contraseniaDueno;
    }

    public void setContraseniaDueno(String contraseniaDueno) {
        this.contraseniaDueno = contraseniaDueno;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public String toString() {
        return "Dueno{" +
                "idDueno=" + idDueno +
                ", cedulaDueno='" + cedulaDueno + '\'' +
                ", nombreDueno='" + nombreDueno + '\'' +
                ", apellidoDueno='" + apellidoDueno + '\'' +
                ", telefonoDueno=" + telefonoDueno +
                ", direccionCasa='" + direccionCasa + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", contraseniaDueno='" + contraseniaDueno + '\'' +
                ", mascotas=" + mascotas +
                '}';
    }
}
