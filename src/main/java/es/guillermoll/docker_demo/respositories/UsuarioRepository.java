package es.guillermoll.docker_demo.respositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.guillermoll.docker_demo.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
}
