package es.guillermoll.docker_demo.services;

import java.util.ArrayList;
import java.util.Optional;

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

    public Optional<UsuarioModel> getById(Long id) {
        return usuarioRepository.findById(id);
    }

    public UsuarioModel setUser(UsuarioModel usr) {
        return usuarioRepository.save(usr);
    }

    public ArrayList<UsuarioModel> getByPrioridad(Integer prioridad) {
        return usuarioRepository.findByPrioridad(prioridad);
    }

    public boolean deleteUser(Long id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}
