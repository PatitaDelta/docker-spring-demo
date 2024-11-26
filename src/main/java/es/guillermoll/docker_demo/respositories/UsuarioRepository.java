package es.guillermoll.docker_demo.respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.guillermoll.docker_demo.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {

}