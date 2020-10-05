package com.vetun.apirest.service;


import com.vetun.apirest.dao.VeterinaryDAO;
import com.vetun.apirest.entity.Veterinaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinaryServiceImpl implements VeterinaryService {
    private VeterinaryDAO veterinaryDAO;

    @Autowired
    public void setVeterinaryDAO (VeterinaryDAO veterinaryDAO) {
        this.veterinaryDAO = veterinaryDAO;
    }

    @Override
    public List<Veterinaria> findAll() {
        List<Veterinaria> listVeterinarias= veterinaryDAO.findAll();
        return listVeterinarias;
    }

    @Override
    public Veterinaria findById(int id) {
        Veterinaria veterinaria = veterinaryDAO.findById(id);
        return veterinaria;
    }

    @Override
    public void save(Veterinaria veterinaria) {
        veterinaryDAO.save(veterinaria);

    }




}
