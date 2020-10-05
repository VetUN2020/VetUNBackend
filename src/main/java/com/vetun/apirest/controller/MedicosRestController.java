package com.vetun.apirest.controller;

import com.vetun.apirest.entity.Dueno;
import com.vetun.apirest.entity.Medicos;
import com.vetun.apirest.service.DuenoService;
import com.vetun.apirest.service.MedicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/medicos")
    public Medicos addDueno(@RequestBody Medicos medico) {
        medico.setIdMedico(0);
        //Este metodo guardará al usuario enviado
        medicosService.save(medico);
        return medico;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/medicos/login")
    public Medicos getDuenoEmail(@RequestBody Medicos medicoP){
        String email = medicoP.getCorreoMedico();
        String password = medicoP.getContraseniaMedico();
        System.out.println(email + " "+password);
        Medicos medico = medicosService.findByEmail(email,password);

        if(medico == null) {
            throw new RuntimeException("User or password incorrect");
            //System.out.println("User email not found -"+email);
        }
        return medico;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/medicos/registro")
    public boolean verificarDuenoEmail(@RequestBody Medicos medicoP){
        String email = medicoP.getCorreoMedico();
        return medicosService.findEmail(email);
    }


}
