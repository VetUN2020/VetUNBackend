package com.vetun.apirest.dao;

import com.vetun.apirest.entity.Medicos;
import java.util.List;

public interface MedicosDAO {

    public List<Medicos> findAll();

    public Medicos findById(String id);
}
