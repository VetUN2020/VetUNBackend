package com.vetun.apirest.dao;

import com.vetun.apirest.entity.Citas;
import com.vetun.apirest.entity.Mascota;
import com.vetun.apirest.entity.Veterinaria;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@Repository
public class CitasDAOImpl implements CitasDAO{

    @Autowired
    private EntityManager entityManager;


    @Override
    public void save(Citas cita) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(cita);
    }

    @Override
    public List<Citas> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Citas> theQuery = currentSession.createQuery("FROM Citas", Citas.class);

        List<Citas> citas = theQuery.getResultList();

        return citas;
    }

    @Override
    public Citas findById(int id) {

        Session currentSession = entityManager.unwrap(Session.class);

        Citas cita = currentSession.get(Citas.class, id);

        return cita;
    }

    @Override
    public List<Citas> findByFecha(Date date) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Citas> theQuery = currentSession.createQuery("FROM Citas C WHERE c.FECHA_CITA =: fecha ", Citas.class);
        theQuery.setParameter("fecha", date);

        List<Citas> citas = theQuery.getResultList();

        return citas;
    }

    @Override
    public List<Citas> findByIdMascota(int IdMascota) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Citas> theQuery = currentSession.createQuery("FROM Citas C WHERE C.idMascota.idMascota =: idM ", Citas.class);
        theQuery.setParameter("idM", IdMascota);

        List<Citas> citas = theQuery.getResultList();

        return citas;
    }

    @Override
    public List<Citas> findByVeterinaryAndDate(int IdVeterinary, Date fecha) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Citas> theQuery = currentSession.createQuery("FROM Citas C WHERE C.idVeterinaria.idVeterinaria =: idV AND C.fechaCita =: fecha", Citas.class);
        theQuery.setParameter("idV", IdVeterinary);
        theQuery.setParameter("fecha", fecha);

        List<Citas> citas = theQuery.getResultList();

        return citas;
    }

    @Override
    public boolean checkAvailabilityByDateAndIdVeterinary(Date fecha, int IdVeterinaria) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Citas> theQuery = currentSession.createQuery("FROM Citas C WHERE C.idVeterinaria.idVeterinaria =: idV AND C.fechaCita =: fecha", Citas.class);
        theQuery.setParameter("idV", IdVeterinaria);
        theQuery.setParameter("fecha", fecha);

        List<Citas> citas = theQuery.getResultList();

        return citas.size() == 0 ? true : false;
    }

}
