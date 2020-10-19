package com.vetun.apirest.service;

import com.vetun.apirest.entity.Veterinaria;

import java.util.List;

public interface VeterinaryService {

    public List<Veterinaria> findAll();

    public Veterinaria findById(int id);

    public void save(Veterinaria veterinaria);

    public List<String> findAllName();

}
