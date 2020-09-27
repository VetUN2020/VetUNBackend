package com.vetun.apirest.dao;

import com.vetun.apirest.entity.Usuario;

import java.util.List;

public interface UserDAO {

    public List<Usuario> findAll();

    public Usuario findById(int id);

    public void save(Usuario usuario);

    public void deleteById(int id);
}
