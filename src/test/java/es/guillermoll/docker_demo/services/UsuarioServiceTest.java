package es.guillermoll.docker_demo.services;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import es.guillermoll.docker_demo.models.UsuarioModel;
import es.guillermoll.docker_demo.respositories.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    // Simula las funciones del repositorio
    // No llega a ejecutarlas y no modifica los datos
    @Mock
    UsuarioRepository usuarioRepository;

    // Recibe las dependencias que hemos simulado
    // Inyecta usuarioRepository que hemos Mockeado aqui al servicio
    @InjectMocks
    UsuarioService usuarioService;

    @Test
    public void testGetUser() {
        Long idUser = 1L;
        UsuarioModel userWanted = new UsuarioModel(1L, "test", "test@test.com", 1);

        // Llama a los metodos simulados
        Mockito.when(usuarioService.getById(idUser)).thenReturn(Optional.of(userWanted));

        final UsuarioModel userOutput = usuarioService.getById(idUser).get();

        // Comprovaciones del resultado
        Assertions.assertEquals(userWanted, userOutput);
        Mockito.verify(usuarioRepository).findById(idUser);
    }

    @Test
    public void testSetUser() {
        UsuarioModel userWanted = new UsuarioModel(1L, "test", "test@test.com", 1);

        // Cuando se llame a setUser en el servico pasar el usuario simulado
        Mockito.when(usuarioService.setUser(Mockito.any())).thenReturn(userWanted);

        final UsuarioModel userOutput = usuarioRepository.save(userWanted);

        // Comprobacion el usuario que se a creado en BD
        Assertions.assertEquals(userWanted.getId(), userOutput.getId());
        Assertions.assertEquals(userWanted.getNombre(), userOutput.getNombre());
        Assertions.assertEquals(userWanted.getPrioridad(), userOutput.getPrioridad());
        Assertions.assertEquals(userWanted.getPrioridad(), userOutput.getPrioridad());

        // Numero de veces que se llama a la funcion de inserccion en el
        // servicio(UsuarioService)
        Mockito.verify(usuarioRepository).save(Mockito.any());
    }

}
