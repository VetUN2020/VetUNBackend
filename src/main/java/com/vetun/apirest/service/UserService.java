package com.vetun.apirest.service;

import com.vetun.apirest.entity.Usuario;

import java.util.List;

public interface UserService {

    public List<Usuario> findAll();

    public Usuario findById(int id);

    public void save(Usuario user);

    public void deleteById(int id);
}
