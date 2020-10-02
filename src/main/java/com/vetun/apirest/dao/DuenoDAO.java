package com.vetun.apirest.dao;

import com.vetun.apirest.entity.Dueno;
import com.vetun.apirest.entity.Mascota;

import java.util.List;

public interface DuenoDAO {
    public List<Mascota> findMascota(String id);

    public Dueno findById(String id);

}
