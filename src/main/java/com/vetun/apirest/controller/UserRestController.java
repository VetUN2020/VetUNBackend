package com.vetun.apirest.controller;

import com.vetun.apirest.entity.Usuario;
import com.vetun.apirest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private UserService userService;

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/users*/
    @GetMapping("/users")
    public List<Usuario> findAll(){
        //retornará todos los usuarios
        return userService.findAll();
    }

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un usuario
    http://127.0.0.1:8080/api/users/1*/
    @GetMapping("/users/{userId}")
    public Usuario getUser(@PathVariable int userId){
        Usuario user = userService.findById(userId);

        if(user == null) {
            throw new RuntimeException("User id not found -"+userId);
        }
        //retornará al usuario con id pasado en la url
        return user;
    }

    /*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/users/  */
    @PostMapping("/users")
    public Usuario addUser(@RequestBody Usuario user) {
        user.setId(0);

        //Este metodo guardará al usuario enviado
        userService.save(user);

        return user;

    }
    /*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/users/  */
    @PutMapping("/users")
    public Usuario updateUser(@RequestBody Usuario user) {

        userService.save(user);

        //este metodo actualizará al usuario enviado

        return user;
    }

    /*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del usuario
    http://127.0.0.1:8080/api/users/1  */
    @DeleteMapping("users/{userId}")
    public String deleteUser(@PathVariable int userId) {

        Usuario user = userService.findById(userId);

        if(user == null) {
            throw new RuntimeException("User id not found -"+userId);
        }

        userService.deleteById(userId);

        //Esto método, recibira el id de un usuario por URL y se borrará de la bd.
        return "Deleted user id - "+userId;
    }

}
