package com.vetun.apirest.controller;

import com.vetun.apirest.entity.Dueno;
import com.vetun.apirest.entity.Mascota;
import com.vetun.apirest.entity.Usuario;
import com.vetun.apirest.service.DuenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DuenoRestController {

    @Autowired
    private DuenoService duenoService;

    @GetMapping("/duenos/{duenoId}/mascotas")
    public List<Mascota> getMascotas(@PathVariable String duenoId){
        List<Mascota> mascotas = duenoService.findMascota(duenoId);
        return mascotas;
    }

    @GetMapping("/duenos/{duenoId}")
    public Dueno getDueno(@PathVariable String duenoId){
        Dueno dueno = duenoService.findById(duenoId);

        if(dueno == null) {
            throw new RuntimeException("User id not found -"+duenoId);
        }
        //retornará al usuario con id pasado en la url
        return dueno;
    }
}
