package com.vetun.apirest.controller;

import com.vetun.apirest.entity.Dueno;
import com.vetun.apirest.entity.Medicos;
import com.vetun.apirest.service.DuenoService;
import com.vetun.apirest.service.MedicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MedicosRestController {

    @Autowired
    private MedicosService medicosService;

    @GetMapping("/medicos")
    public List<Medicos> findAll(){
        return medicosService.findAll();
    }

    @GetMapping("/medicos/{medicoId}")
    public Medicos getMedico(@PathVariable int medicoId){
        Medicos medico = medicosService.findById(medicoId);
        if(medico == null) {
            throw new RuntimeException("User id not found -"+medicoId);
        }
        return medico;
    }
}
