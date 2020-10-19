package com.vetun.apirest.controller;

import com.vetun.apirest.entity.Mascota;
import com.vetun.apirest.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MascotaRestController {

    @Autowired
    private MascotaService mascotaService;

    @PostMapping("/mascotas")
    public Mascota addMascota(@RequestBody Mascota mascota) {
        System.out.println(mascota);
        mascota.setIdMascota(0);

        //Este metodo guardará al usuario enviado
        mascotaService.save(mascota);

        return mascota;

    }

    @GetMapping("/mascotas")
    public List<Mascota> findAll(){
        return mascotaService.findAll();
    }


    @GetMapping("/mascotas/{idMascota}")
    public Mascota getMascotaById(@PathVariable int idMascota){

        Mascota mascota = mascotaService.findById(idMascota);

        if (mascota == null){
            throw new RuntimeException("Pet id not found ");
        }

        return mascota;
    }

    @GetMapping("/mascotas/{mascotaName}/{duenoId}")
    public Mascota getMascotaByIdDuenoAndByMascotaName(@PathVariable String mascotaName, @PathVariable int duenoId){

        Mascota mascota = mascotaService.findByName(mascotaName, duenoId);

        if (mascota == null){
            throw new RuntimeException("We can't find " + mascotaName);
        }

        return mascota;
    }

    @GetMapping("/mascotas/byIdDueno/{duenoId}")
    public List<String> getByIdDueno(@PathVariable(value="duenoId") int duenoId){
        return mascotaService.findByIdDueno(duenoId);
    }

}
