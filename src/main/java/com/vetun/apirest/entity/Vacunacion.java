package com.vetun.apirest.entity;

import javax.persistence.*;

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
    @JoinColumn(name="cedula_medico")
    private Medicos cedulaMedico;

    @Column(name="descripcion_vacuna")
    private String descripcionVacuna;

    @Column(name="fecha_vacuna")
    private String fechaVacuna;

    public Vacunacion() {

    }

    public Vacunacion(int idVacuna, String descripcionVacuna, String fechaVacuna) {
        this.idVacuna = idVacuna;
        this.descripcionVacuna = descripcionVacuna;
        this.fechaVacuna = fechaVacuna;
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

    public Medicos getCedulaMedico() {
        return cedulaMedico;
    }

    public void setCedulaMedico(Medicos cedulaMedico) {
        this.cedulaMedico = cedulaMedico;
    }

    public String getDescripcionVacuna() {
        return descripcionVacuna;
    }

    public void setDescripcionVacuna(String descripcionVacuna) {
        this.descripcionVacuna = descripcionVacuna;
    }

    public String getFechaVacuna() {
        return fechaVacuna;
    }

    public void setFechaVacuna(String fechaVacuna) {
        this.fechaVacuna = fechaVacuna;
    }

    @Override
    public String toString() {
        return "Vacunacion{" +
                "idVacuna=" + idVacuna +
                ", idMascota='" + idMascota + '\'' +
                ", cedulaMedico='" + cedulaMedico + '\'' +
                ", descripcionVacuna='" + descripcionVacuna + '\'' +
                ", fechaVacuna='" + fechaVacuna + '\'' +
                '}';
    }
}
