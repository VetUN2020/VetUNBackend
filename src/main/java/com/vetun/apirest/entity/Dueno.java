package com.vetun.apirest.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="duenos")
public class Dueno {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="cedula_dueno")
    private int id;

    @Column(name="nombre_dueno")
    private String nombre;

    @Column(name="apellido_dueno")
    private String apellido;

    @Column(name="telefono_dueno")
    @CreationTimestamp
    private int telefono;

    @Column(name="direccion_casa")
    @UpdateTimestamp
    private String direccion;

    @Column(name="correo_electronico")
    @UpdateTimestamp
    private String correo;

    @Column(name="contrasenia_dueno")
    @UpdateTimestamp
    private String contrasenia;

    public Dueno(int id,String correo, String contrasenia) {
        this.id = id;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Dueno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono=" + telefono +
                ", direccion='" + direccion + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                '}';
    }
}
