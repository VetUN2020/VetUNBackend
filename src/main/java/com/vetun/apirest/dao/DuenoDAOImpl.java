package com.vetun.apirest.dao;

import com.vetun.apirest.entity.Dueno;
import com.vetun.apirest.entity.Mascota;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
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
    public void save(Dueno dueno) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(dueno);

    }

    @Override
    public List<Mascota> findMascota(String id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Mascota> theQuery = currentSession.createQuery("FROM Mascota M WHERE M.idDueno.cedulaDueno=:idUser", Mascota.class);
        theQuery.setParameter("idUser", id);
        List<Mascota> mascotas = theQuery.getResultList();

        return mascotas;

    }

    @Override
    public Dueno findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Dueno dueno = currentSession.get(Dueno.class, id);

        return dueno;
    }

    @Override
    public Dueno findByEmail(String email){
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Dueno> theQuery = currentSession.createQuery("FROM Dueno D WHERE D.correoElectronico=:email", Dueno.class);
        theQuery.setParameter("email", email);

        List<Dueno> results = theQuery.getResultList();
        Dueno dueno = null;
        if(!results.isEmpty()){
             dueno = results.get(0);
        }
        return dueno;
    }

    @Override
    public boolean findEmail(String email){
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Dueno> theQuery = currentSession.createQuery("FROM Dueno D WHERE D.correoElectronico=:email", Dueno.class);
        theQuery.setParameter("email", email);

        List<Dueno> results = theQuery.getResultList();
        Dueno dueno = null;
        boolean existe = false;
        if(!results.isEmpty()){
            dueno = results.get(0);
            existe = true;
        }
        return existe;
    }
}
