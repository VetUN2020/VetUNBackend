package com.vetun.apirest.dao;

import com.vetun.apirest.entity.Veterinaria;
import java.util.List;

public interface VeterinaryDAO {
    public List<Veterinaria> findAll();

    public Veterinaria findById(int id);

    public void save(Veterinaria veterinaria);

    public List<String> findAllName();
}
