package com.vetun.apirest.controller;

import com.vetun.apirest.entity.Mascota;
import com.vetun.apirest.entity.Veterinaria;
import com.vetun.apirest.service.VeterinaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VeterinaryRestController {

    @Autowired
    private VeterinaryService veterinaryService;

    @GetMapping("/veterinarias")
    public List<Veterinaria> findAll(){
        return veterinaryService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/veterinarias")
    public Veterinaria addVeterinaria(@RequestBody Veterinaria veterinaria) {
        veterinaria.setIdVeterinaria(0);
        //Este metodo guardará al usuario enviado
        veterinaryService.save(veterinaria);
        return veterinaria;
    }

    @GetMapping("/veterinarias/{veterinariaId}")
    public Veterinaria getVeterinaria(@PathVariable int veterinariaId){

        Veterinaria veterinaria = veterinaryService.findById(veterinariaId);

        if (veterinaria == null){
            throw new RuntimeException("Veterinary id not found -"+veterinariaId);
        }

        return veterinaria;
    }

    @GetMapping("/veterinarias/name")
    public List<String> getVeterinaryNames(){
        return veterinaryService.findAllName();
    }

}
