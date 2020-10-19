package com.vetun.apirest.dao;

import com.vetun.apirest.entity.Veterinaria;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
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
    public List<String> findAllName() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Veterinaria> theQuery = currentSession.createQuery("FROM Veterinaria", Veterinaria.class);

        List<Veterinaria> veterinarias = theQuery.getResultList();

        List<String> names = new LinkedList<String>();

        for (int i = 0; i < veterinarias.size(); i++){
            names.add(veterinarias.get(i).getIdVeterinaria() + " " + veterinarias.get(i).getNombreVeterinaria());
        }

        return names;
    }


    @Override
    public Veterinaria findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Veterinaria veterinaria = currentSession.get(Veterinaria.class, id);

        return veterinaria;
    }


}
