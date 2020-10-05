package com.vetun.apirest.controller;

import com.vetun.apirest.entity.Veterinaria;
import com.vetun.apirest.service.VeterinaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class VeterinaryRestController {

    @Autowired
    private VeterinaryService veterinaryService;

    @GetMapping("/veterinarias")
    public List<Veterinaria> findAll(){
        return veterinaryService.findAll();
    }

    @PostMapping("/veterinarias")
    public Veterinaria addVeterinaria(@RequestBody Veterinaria veterinaria) {
        veterinaria.setIdVeterinaria(0);
        //Este metodo guardará al usuario enviado
        veterinaryService.save(veterinaria);
        return veterinaria;
    }

    @GetMapping("/veterinarias/{veterinariaId}")
    public Veterinaria getVeterinaria(@PathVariable int veterinariaID){
        Veterinaria veterinaria = veterinaryService.findById(veterinariaID);

        if(veterinaria == null) {
            throw new RuntimeException("Veterinary id not found -"+veterinariaID);
        }
        //retornará al usuario con id pasado en la url
        return veterinaria;
    }

}
