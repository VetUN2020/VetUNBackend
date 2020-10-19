package com.vetun.apirest.service;

import com.vetun.apirest.entity.Citas;

import java.util.Date;
import java.util.List;

public interface CitasService {

    public List<Citas> findAll();

    public void save(Citas cita);

    public Citas findById(int id);

    public List<Citas> findByFecha(Date date);

    public List<Citas> findByIdMascota(int IdMascota);

    public List<Citas> findByVeterinaryAndDate(int IdVeterinary, Date fecha);

    public boolean checkAvailabilityByDateAndIdVeterinary(Date fecha, int IdVeterinaria);

}
