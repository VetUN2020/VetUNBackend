package com.vetun.apirest.dao;

import com.vetun.apirest.entity.Dueno;
import com.vetun.apirest.entity.Mascota;
import com.vetun.apirest.entity.Medicos;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MedicoDAOImpl implements MedicosDAO{
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Medicos> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Medicos> theQuery = currentSession.createQuery("FROM Medicos", Medicos.class);

        List<Medicos> medicos = theQuery.getResultList();

        return medicos;

    }

    @Override
    public Medicos findById(String id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Medicos medico = currentSession.get(Medicos.class, id);

        return medico;
    }

}
