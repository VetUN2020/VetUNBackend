package com.vetun.apirest.controller;

import com.vetun.apirest.entity.Citas;
import com.vetun.apirest.service.CitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CitasRestController {

    @Autowired
    private CitasService citasService;

    @PostMapping("/citas")
    public Citas addCita(@RequestBody Citas cita) {

        cita.setIdCita(0);

        //Este metodo guardará la cita enviada
        citasService.save(cita);

        return cita;

    }

    @GetMapping("/citas")
    public List<Citas> findAll(){
        return citasService.findAll();
    }

    @GetMapping("/citas/byCitaId/{idCita}")
    public Citas getCitaById(@PathVariable int idCita){

        Citas cita = citasService.findById(idCita);

        if (cita == null){
            throw new RuntimeException("Cita no encontrada");
        }

        return cita;
    }

    @GetMapping("/citas/byDate/{fecha}")
    public List<Citas> getCitaByDate(@PathVariable Date fecha){

        List<Citas> cita = citasService.findByFecha(fecha);

        if (cita == null){
            throw new RuntimeException("Cita no encontrada");
        }

        return cita;
    }

    @GetMapping("/citas/byIdMascota/{idMascota}")
    public List<Citas> getCitaByIdMascota(@PathVariable int idMascota){

        List<Citas> cita = citasService.findByIdMascota(idMascota);

        if (cita == null){
            throw new RuntimeException("Cita no encontrada");
        }

        return cita;
    }

    @GetMapping("/citas/ByVeterinaryAndDate/{idVeterinaria}/{fecha}")
    public List<Citas> findByVeterinaryAndDate(@PathVariable int idVeterinaria, @PathVariable Date fecha) {

        List<Citas> cita = citasService.findByVeterinaryAndDate(idVeterinaria, fecha);

        if (cita == null){
            throw new RuntimeException("Cita no encontrada");
        }

        return cita;
    }

    @GetMapping("/citas/ByVeterinary/{idVeterinaria}")
    public List<Citas> findByVeterinary(@PathVariable int idVeterinaria) {

        List<Citas> cita = citasService.findByVeterinary(idVeterinaria);

        if (cita == null){
            throw new RuntimeException("Cita no encontrada");
        }

        return cita;
    }

    @GetMapping("/citas/Availability/{fecha}/{idVeterinaria}")
    public boolean checkAvailabilityByDateAndIdVeterinary(@PathVariable Date fecha, @PathVariable int idVeterinaria){
        return citasService.checkAvailabilityByDateAndIdVeterinary(fecha, idVeterinaria);
    }

}