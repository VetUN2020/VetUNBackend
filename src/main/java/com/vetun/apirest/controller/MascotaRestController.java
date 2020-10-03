package com.vetun.apirest.controller;

import com.vetun.apirest.entity.Mascota;
import com.vetun.apirest.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MascotaRestController {

    @Autowired
    private MascotaService mascotaService;

    @PostMapping("/mascotas")
    public Mascota addMascota(@RequestBody Mascota mascota) {
        mascota.setIdMascota(0);

        //Este metodo guardará al usuario enviado
        mascotaService.save(mascota);

        return mascota;

    }
}
