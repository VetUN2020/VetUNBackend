package com.vetun.apirest.service;

import com.vetun.apirest.dao.CitasDAO;
import com.vetun.apirest.entity.Citas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CitasServiceImpl implements CitasService{

    private CitasDAO citasDao;

    @Autowired
    public void setCitasDao (CitasDAO citasDao) {
        this.citasDao = citasDao;
    }

    @Override
    public void save(Citas cita) {
        citasDao.save(cita);
    }

    @Override
    public List<Citas> findAll() {
        return citasDao.findAll();
    }

    @Override
    public Citas findById(int id) {
        return citasDao.findById(id);
    }

    @Override
    public List<Citas> findByFecha(Date date) {
        return citasDao.findByFecha(date);
    }

    @Override
    public List<Citas> findByIdMascota(int IdMascota) {
        return citasDao.findByIdMascota(IdMascota);
    }

    @Override
    public List<Citas> findByVeterinaryAndDate(int IdVeterinary, Date fecha) {
        return citasDao.findByVeterinaryAndDate(IdVeterinary,fecha);
    }

    @Override
    public List<Citas> findByVeterinary(int IdVeterinary) {
        return citasDao.findByVeterinary(IdVeterinary);
    }

    @Override
    public boolean checkAvailabilityByDateAndIdVeterinary(Date fecha, int IdVeterinaria) {
        return citasDao.checkAvailabilityByDateAndIdVeterinary(fecha,IdVeterinaria);
    }

}
