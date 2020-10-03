package com.vetun.apirest.dao;

import com.vetun.apirest.entity.Mascota;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class MascotaDAOImpl implements MascotaDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public void save(Mascota mascota) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(mascota);

    }
}
