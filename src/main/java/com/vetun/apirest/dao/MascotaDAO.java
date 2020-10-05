package com.vetun.apirest.dao;

import com.vetun.apirest.entity.Mascota;

import java.util.List;

public interface MascotaDAO {

    public void save(Mascota mascota);

    public List<Mascota> findAll();

    public Mascota findById(int id);

    //Busca mascota segun el id del dueño y el nombre de la mascota
    public Mascota findByName(String name, int id);
}
