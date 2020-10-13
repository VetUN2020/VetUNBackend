package com.vetun.apirest.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.vetun.apirest.entity.Dueno;
import com.vetun.apirest.entity.Mascota;
import com.vetun.apirest.service.DuenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
//@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping("/api")
public class DuenoRestController {

    @Autowired
    private DuenoService duenoService;

    //private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);

    Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder("secretVet", 10000, 24);

    /*@Autowired
    private PasswordEncoder passwordEncoder;*/

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

        String encodedPassword = encoder.encode(dueno.getContraseniaDueno());
        dueno.setContraseniaDueno(encodedPassword);

        //Este metodo guardará al usuario enviado
        duenoService.save(dueno);
        return dueno;
    }

    @GetMapping("/duenos/{duenoId}")
    public Dueno getDueno(@PathVariable int duenoId){
        Dueno dueno = duenoService.findById(duenoId);

        if(dueno == null) {
            throw new RuntimeException("User id not found -"+duenoId);
        }
        //retornará al usuario con id pasado en la url
        return dueno;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("duenos/login/")
    public Dueno getDuenoEmail(@RequestBody Dueno duenoP){
        String email = duenoP.getCorreoElectronico();
        //String password = duenoP.getContraseniaDueno();

        Dueno dueno = duenoService.findByEmail(email);
        CharSequence pass = duenoP.getContraseniaDueno();
        String encoded = dueno.getContraseniaDueno();

        if(dueno == null || !encoder.matches(pass, encoded)) {
            throw new RuntimeException("User or password incorrect");
            //System.out.println("User email not found -"+email);
        }
        return dueno;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/duenos/registro")
    public boolean verificarDuenoEmail(@RequestBody Dueno duenoP){
        String email = duenoP.getCorreoElectronico();
        return duenoService.findEmail(email);
    }

}
