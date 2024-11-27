package es.guillermoll.docker_demo.controllers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.notNull;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import es.guillermoll.docker_demo.services.UsuarioService;

// Ejecuta la prueba en un puerto random
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// Excluye la conexion a la BD para hacer prueba unitaria
@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class
})
public class UsuarioControllerTest {

    @MockBean
    private UsuarioService usuarioService;

    @Autowired
    private WebTestClient webTestClient;

    @BeforeEach
    public void setup() {
        Mockito.when(usuarioService.getById(anyLong())).thenReturn(notNull());
    }

    @Test
    public void getUserUrl() {
        // webTestClient.get().uri("/user/1")
        // .exchange()
        // .expectStatus().isOk();
    }
}
