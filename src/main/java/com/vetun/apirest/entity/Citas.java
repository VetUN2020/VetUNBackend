package com.vetun.apirest.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="citas")
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
}
