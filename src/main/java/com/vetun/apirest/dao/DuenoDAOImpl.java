package com.vetun.apirest.dao;

import com.vetun.apirest.entity.Dueno;
import com.vetun.apirest.entity.Mascota;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DuenoDAOImpl implements DuenoDAO{
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Dueno> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Dueno> theQuery = currentSession.createQuery("FROM Dueno", Dueno.class);

        List<Dueno> duenos = theQuery.getResultList();

        return duenos;

    }

    @Override
    public List<Mascota> findMascota(String id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Mascota> theQuery = currentSession.createQuery("FROM Mascota M WHERE M.cedulaDueno.cedulaDueno=:idUser", Mascota.class);
        theQuery.setParameter("idUser", id);
        List<Mascota> mascotas = theQuery.getResultList();

        return mascotas;

    }

    @Override
    public Dueno findById(String id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Dueno dueno = currentSession.get(Dueno.class, id);

        return dueno;
    }
}
