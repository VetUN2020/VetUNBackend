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
    public Medicos findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Medicos medico = currentSession.get(Medicos.class, id);

        return medico;
    }

    @Override
    public void save(Medicos medico){
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(medico);
    }

    @Override
    public Medicos findByEmail(String email, String password){
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Medicos> theQuery = currentSession.createQuery("FROM Medicos M WHERE M.correoMedico=:email AND M.contraseniaMedico=:password", Medicos.class);
        theQuery.setParameter("email", email);
        theQuery.setParameter("password", password);

        List<Medicos> results = theQuery.getResultList();
        Medicos medico = null;
        if(!results.isEmpty()){
            medico = results.get(0);
        }
        return medico;
    }

    @Override
    public boolean findEmail(String email){
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Medicos> theQuery = currentSession.createQuery("FROM Medicos M WHERE M.correoMedico=:email", Medicos.class);
        theQuery.setParameter("email", email);

        List<Medicos> results = theQuery.getResultList();
        Medicos medico = null;
        boolean existe = false;
        if(!results.isEmpty()){
            medico = results.get(0);
            existe = true;
        }
        return existe;
    }
}
