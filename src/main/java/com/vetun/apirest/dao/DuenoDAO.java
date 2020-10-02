package com.vetun.apirest.dao;

import com.vetun.apirest.entity.Dueno;
import com.vetun.apirest.entity.Mascota;
import com.vetun.apirest.entity.Usuario;

import java.util.List;

public interface DuenoDAO {

    public List<Dueno> findAll();

    public List<Mascota> findMascota(String id);

    public Dueno findById(String id);

}
