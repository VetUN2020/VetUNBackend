package com.vetun.apirest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vetun.apirest.entity.Usuario;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Usuario> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Usuario> theQuery = currentSession.createQuery("FROM Usuario", Usuario.class);

        List<Usuario> users = theQuery.getResultList();

        return users;

    }

    @Override
    public Usuario findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Usuario user = currentSession.get(Usuario.class, id);

        return user;
    }

    @Override
    public void save(Usuario user) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(user);

    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Transaction txn = currentSession.beginTransaction();
        Query<Usuario> theQuery = currentSession.createQuery("DELETE FROM Usuario where id=:idUser");
        theQuery.setParameter("idUser", id);
        theQuery.executeUpdate();
        txn.commit();
    }
}
