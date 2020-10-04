package com.vetun.apirest.service;

import com.vetun.apirest.dao.MedicosDAO;
import com.vetun.apirest.entity.Dueno;
import com.vetun.apirest.entity.Mascota;
import com.vetun.apirest.entity.Medicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicosServiceImpl implements MedicosService{
    private MedicosDAO medicosDao;

    @Autowired
    public void setDuenoDao (MedicosDAO medicosDao) {
        this.medicosDao = medicosDao;
    }

    @Override
    public List<Medicos> findAll() {
        List<Medicos> listMedicos= medicosDao.findAll();
        return listMedicos;
    }

    @Override
    public Medicos findById(int id) {
        Medicos medico = medicosDao.findById(id);
        return medico;
    }
}
