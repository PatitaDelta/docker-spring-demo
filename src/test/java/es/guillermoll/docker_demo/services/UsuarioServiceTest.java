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
    public void testPostUser() {
        UsuarioModel userPosted = new UsuarioModel("test", "test@test.com", 1);
        UsuarioModel userRecibed = new UsuarioModel(5L, "test", "test@test.com", 1);

        // Cuando se llame a setUser en el servicio recibir el usuario simulado
        Mockito.when(usuarioRepository.save(userPosted)).thenReturn(userRecibed);

        // Probamos la funcion programada
        final UsuarioModel userOutput = usuarioService.setUser(userPosted);

        // Comprobacion del usuario que se a creado en BD
        Assertions.assertEquals(userRecibed.getId(), userOutput.getId());
        Assertions.assertEquals(userRecibed.getNombre(), userOutput.getNombre());
        Assertions.assertEquals(userRecibed.getEmail(), userOutput.getEmail());
        Assertions.assertEquals(userRecibed.getPrioridad(), userOutput.getPrioridad());

        // Numero de veces que se llama a la funcion de inserccion en el
        // servicio(UsuarioService)
        Mockito.verify(usuarioRepository).save(userPosted);
    }

    @Test
    public void testPutUser() {
        UsuarioModel userPuted = new UsuarioModel(5L, "test2", "test2@test.es", 3);
        UsuarioModel userRecibed = new UsuarioModel(5L, "test2", "test2@test.es", 3);

        // Cuando se llame a setUser en el servicio recibir el usuario simulado
        Mockito.when(usuarioRepository.save(userPuted)).thenReturn(userRecibed);

        // Probamos la funcion programada
        final UsuarioModel userOutput = usuarioService.setUser(userPuted);

        // Comprobacion del usuario que se a modificado en BD
        Assertions.assertEquals(userRecibed.getId(), userOutput.getId());
        Assertions.assertEquals(userRecibed.getNombre(), userOutput.getNombre());
        Assertions.assertEquals(userRecibed.getPrioridad(), userOutput.getPrioridad());
        Assertions.assertEquals(userRecibed.getPrioridad(), userOutput.getPrioridad());

        // Numero de veces que se llama a la funcion de inserccion en el
        // servicio(UsuarioService)
        Mockito.verify(usuarioRepository).save(userPuted);
    }

}
