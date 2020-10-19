package com.vetun.apirest.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="cita")
public class Citas {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_cita")
    private int idCita;

    @ManyToOne
    @JoinColumn(name="id_veterinaria")
    private Veterinaria idVeterinaria;


    @ManyToOne
    @JoinColumn(name="id_mascota")
    private Mascota idMascota;

    @Column(name="fecha_cita")
    private Date fechaCita;

    @Column(name="tipo_cita")
    private String tipoCita;

    public Citas() {

    }

    public Citas(int idCita, Date fechaCita, String tipoCita) {
        this.idCita = idCita;
        this.fechaCita = fechaCita;
        this.tipoCita = tipoCita;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Veterinaria getIdVeterinaria() {
        return idVeterinaria;
    }

    public void setIdVeterinaria(Veterinaria idVeterinaria) {
        this.idVeterinaria = idVeterinaria;
    }

    public Mascota getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Mascota idMascota) {
        this.idMascota = idMascota;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(String tipoCita) {
        this.tipoCita = tipoCita;
    }
}
