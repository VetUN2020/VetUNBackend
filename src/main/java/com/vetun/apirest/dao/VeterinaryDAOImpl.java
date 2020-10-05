package com.vetun.apirest.dao;

import com.vetun.apirest.entity.Veterinaria;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class VeterinaryDAOImpl implements VeterinaryDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Veterinaria> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Veterinaria> theQuery = currentSession.createQuery("FROM Veterinaria", Veterinaria.class);

        List<Veterinaria> veterinarias = theQuery.getResultList();

        return veterinarias;

    }

    @Override
    public void save(Veterinaria veterinaria) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(veterinaria);

    }


    @Override
    public Veterinaria findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Veterinaria veterinaria = currentSession.get(Veterinaria.class, id);

        return veterinaria;
    }


}
