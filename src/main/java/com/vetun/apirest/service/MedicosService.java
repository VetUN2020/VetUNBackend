package com.vetun.apirest.service;

import com.vetun.apirest.entity.Medicos;

import java.util.List;

public interface MedicosService {
    public List<Medicos> findAll();

    public Medicos findById(int id);
}
