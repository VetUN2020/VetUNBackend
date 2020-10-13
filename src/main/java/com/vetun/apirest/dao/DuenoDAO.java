package com.vetun.apirest.dao;

import com.vetun.apirest.entity.Dueno;
import com.vetun.apirest.entity.Mascota;

import java.util.List;

public interface DuenoDAO {

    public List<Dueno> findAll();

    public List<Mascota> findMascota(String id);

    public Dueno findById(int id);

    public void save(Dueno dueno);

    public Dueno findByEmail(String email);

    public boolean findEmail(String email);
}
