package es.guillermoll.docker_demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.guillermoll.docker_demo.models.UsuarioModel;
import es.guillermoll.docker_demo.services.UsuarioService;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> getUsers() {
        return usuarioService.getAllUsers();
    }

    @PostMapping()
    public UsuarioModel postUser(@RequestBody UsuarioModel usr) {
        return usuarioService.setUser(usr);
    }
}
