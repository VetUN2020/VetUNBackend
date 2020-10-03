package com.vetun.apirest.service;

import com.vetun.apirest.dao.MascotaDAO;
import com.vetun.apirest.entity.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaServiceImpl implements MascotaService{

    private MascotaDAO mascotaDAO;

    @Autowired
    public void setMascotaDAO (MascotaDAO mascotaDAO) {
        this.mascotaDAO = mascotaDAO;
    }

    @Override
    public void save(Mascota mascota) {
        mascotaDAO.save(mascota);

    }
}
