package com.vetun.apirest.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="vacunacion")
public class Vacunacion {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_vacuna")
    private int idVacuna;

    @ManyToOne
    @JoinColumn(name="id_mascota")
    private Mascota idMascota;

    @ManyToOne
    @JoinColumn(name="id_medico")
    private Medicos idMedico;

    @Column(name="descripcion_vacuna")
    private String descripcionVacuna;

    @Column(name="fecha_vacuna")
    private Date fechaVacuna;

    public Vacunacion() {

    }

    public Vacunacion(int idVacuna, String descripcionVacuna, Date fechaVacuna) {
        this.idVacuna = idVacuna;
        this.descripcionVacuna = descripcionVacuna;
        this.fechaVacuna = fechaVacuna;
    }

    public Date getFechaVacuna() {
        return fechaVacuna;
    }

    public void setFechaVacuna(Date fechaVacuna) {
        this.fechaVacuna = fechaVacuna;
    }

    public Medicos getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Medicos idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(int idVacuna) {
        this.idVacuna = idVacuna;
    }

    public Mascota getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Mascota idMascota) {
        this.idMascota = idMascota;
    }

    public String getDescripcionVacuna() {
        return descripcionVacuna;
    }

    public void setDescripcionVacuna(String descripcionVacuna) {
        this.descripcionVacuna = descripcionVacuna;
    }

    @Override
    public String toString() {
        return "Vacunacion{" +
                "idVacuna=" + idVacuna +
                ", idMascota=" + idMascota +
                ", idMedico=" + idMedico +
                ", descripcionVacuna='" + descripcionVacuna + '\'' +
                ", fechaVacuna=" + fechaVacuna +
                '}';
    }
}
