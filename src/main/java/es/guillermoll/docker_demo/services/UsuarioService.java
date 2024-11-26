package es.guillermoll.docker_demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.guillermoll.docker_demo.models.UsuarioModel;
import es.guillermoll.docker_demo.respositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> getAllUsers() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel setUser(UsuarioModel usr) {
        return usuarioRepository.save(usr);
    }
}
