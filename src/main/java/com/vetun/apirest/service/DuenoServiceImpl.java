package com.vetun.apirest.service;

import com.vetun.apirest.dao.DuenoDAO;
import com.vetun.apirest.entity.Dueno;
import com.vetun.apirest.entity.Mascota;
import com.vetun.apirest.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuenoServiceImpl implements DuenoService{

    private DuenoDAO duenoDao;

    @Autowired
    public void setDuenoDao (DuenoDAO duenoDao) {
        this.duenoDao = duenoDao;
    }

    @Override
    public List<Mascota> findMascota(String id) {
        List<Mascota> listMascotas= duenoDao.findMascota(id);
        return listMascotas;
    }

    @Override
    public Dueno findById(String id) {
        Dueno dueno = duenoDao.findById(id);
        return dueno;
    }
}
