package com.vetun.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vetun.apirest.dao.UserDAO;
import com.vetun.apirest.entity.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public void setUserDao (UserDAO userDao) {
        this.userDAO = userDao;
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> listUsers= userDAO.findAll();
        return listUsers;
    }

    @Override
    public Usuario findById(int id) {
        Usuario user = userDAO.findById(id);
        return user;
    }

    @Override
    public void save(Usuario user) {
        userDAO.save(user);

    }

    @Override
    public void deleteById(int id) {
        userDAO.deleteById(id);
    }

}
