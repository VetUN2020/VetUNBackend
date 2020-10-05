package com.vetun.apirest.dao;

import com.vetun.apirest.entity.Dueno;
import com.vetun.apirest.entity.Medicos;
import java.util.List;

public interface MedicosDAO {

    public List<Medicos> findAll();

    public Medicos findById(int id);

    public void save(Medicos medico);

    public Medicos findByEmail(String email, String password);

    public boolean findEmail(String email);
}
