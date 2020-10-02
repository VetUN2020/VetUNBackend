package com.vetun.apirest.service;

import com.vetun.apirest.entity.Dueno;
import com.vetun.apirest.entity.Mascota;

import java.util.List;

public interface DuenoService {

    public List<Dueno> findAll();

    public List<Mascota> findMascota(String id);

    public Dueno findById(String id);
}
