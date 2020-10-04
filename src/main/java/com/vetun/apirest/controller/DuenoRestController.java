package com.vetun.apirest.controller;

import com.vetun.apirest.entity.Dueno;
import com.vetun.apirest.entity.Mascota;
import com.vetun.apirest.service.DuenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/api")
public class DuenoRestController {

    @Autowired
    private DuenoService duenoService;

    @GetMapping("/duenos")
    public List<Dueno> findAll(){
        return duenoService.findAll();
    }

    @GetMapping("/duenos/{duenoId}/mascotas")
    public List<Mascota> getMascotas(@PathVariable String duenoId){
        List<Mascota> mascotas = duenoService.findMascota(duenoId);
        return mascotas;
    }

    @PostMapping("/duenos")
    public Dueno addDueno(@RequestBody Dueno dueno) {
        dueno.setIdDueno(0);
        //Este metodo guardará al usuario enviado
        duenoService.save(dueno);
        return dueno;

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

    @GetMapping("/duenos/login")
    public Dueno getDuenoEmail(@RequestBody Dueno duenoP){
        String email = duenoP.getCorreoElectronico();
        Dueno dueno = duenoService.findByEmail(email);

        if(dueno == null) {
            //throw new RuntimeException("User email not found -"+email);
            System.out.println("User email not found -"+email);
        }
        return dueno;
    }

}
