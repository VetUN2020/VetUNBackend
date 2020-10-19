package com.vetun.apirest.dao;

import com.vetun.apirest.entity.Mascota;
import com.vetun.apirest.entity.Veterinaria;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.LinkedList;
import java.util.List;

@Repository
public class MascotaDAOImpl implements MascotaDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public void save(Mascota mascota) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(mascota);

    }

    @Override
    public List<Mascota> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Mascota> theQuery = currentSession.createQuery("FROM Mascota", Mascota.class);

        return theQuery.getResultList();
    }

    @Override
    public Mascota findById(int id) {

        Session currentSession = entityManager.unwrap(Session.class);

        Mascota mascota = currentSession.get(Mascota.class, id);

        return mascota;
    }

    //id Del dueño
    @Override
    public Mascota findByName(String name, int id) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Mascota> theQuery = currentSession.createQuery("FROM Mascota M WHERE M.idDueno.idDueno =: idUser AND M.nombreMascota =: nameM", Mascota.class);
        theQuery.setParameter("idUser", id);
        theQuery.setParameter("nameM", name);

        return theQuery.getSingleResult();
    }

    @Override
    public List<String> findByIdDueno(int idDueno) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Mascota> theQuery = currentSession.createQuery("FROM Mascota M WHERE M.idDueno.idDueno =: idUser", Mascota.class);
        theQuery.setParameter("idUser", idDueno);

        List<Mascota> mascotas = theQuery.getResultList();

        List<String> misMascotas = new LinkedList<>();

        for (int i = 0; i < mascotas.size(); i++) {
            misMascotas.add(mascotas.get(i).getIdMascota() + " " + mascotas.get(i).getNombreMascota());
        }

        if (misMascotas.size() == 0){
            misMascotas.add("No encontramos tus mascotas");
            return misMascotas;
        }else{
            return misMascotas;
        }

    }

}
