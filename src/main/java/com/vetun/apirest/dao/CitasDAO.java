package com.vetun.apirest.dao;

import com.vetun.apirest.entity.Citas;
import com.vetun.apirest.entity.Mascota;
import com.vetun.apirest.entity.Veterinaria;

import java.util.List;
import java.util.Date;

public interface CitasDAO {

    public List<Citas> findAll();

    public void save(Citas cita);

    public Citas findById(int id);

    public List<Citas> findByFecha(Date date);

    public List<Citas> findByIdMascota(int IdMascota);

    public List<Citas> findByVeterinaryAndDate(int IdVeterinary, Date fecha);

    public List<Citas> findByVeterinary(int IdVeterinary);

    public boolean checkAvailabilityByDateAndIdVeterinary(Date fecha, int IdVeterinaria);

}
