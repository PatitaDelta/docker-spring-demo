package es.guillermoll.docker_demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/{id}")
    public Optional<UsuarioModel> getUserById(@PathVariable("id") Long id) {
        return usuarioService.getById(id);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModel> getUsersByQuery(@RequestParam("prioridad") Integer prioridad) {
        return usuarioService.getByPrioridad(prioridad);
    }

    @PostMapping()
    public UsuarioModel postUser(@RequestBody UsuarioModel usr) {
        return usuarioService.setUser(usr);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        boolean deleted = usuarioService.deleteUser(id);

        if (deleted) {
            return "Se elimino el usuario " + id + " correctamente";
        }

        return "No se pudo eliminar el usuario";
    }

}
