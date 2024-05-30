package com.harmonify.backspring.domain.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.harmonify.backspring.api.contracts.requests.ArtistaDTO;
import org.junit.jupiter.api.Test;

class ArtistaTest {

  @Test
  void testConstrutorPadraoESetters() {
    Artista artista = new Artista();

    artista.setId(1L);
    artista.setNome("Artista Teste");
    artista.setNacionalidade("Brasileiro");
    artista.setBiografia("Biografia de teste");
    artista.setPaisOrigem("Brasil");
    artista.setGenero("Rock");

    assertEquals(1L, artista.getId());
    assertEquals("Artista Teste", artista.getNome());
    assertEquals("Brasileiro", artista.getNacionalidade());
    assertEquals("Biografia de teste", artista.getBiografia());
    assertEquals("Brasil", artista.getPaisOrigem());
    assertEquals("Rock", artista.getGenero());
  }

  @Test
  void testConstrutorComDTO() {
    ArtistaDTO artistaDTO = new ArtistaDTO("Artista Teste", "Rock", "Brasileiro",
        "Biografia de teste", "Brasil");
    Artista artista = new Artista(artistaDTO);

    assertNull(artista.getId());
    assertEquals("Artista Teste", artista.getNome());
    assertEquals("Brasileiro", artista.getNacionalidade());
    assertEquals("Biografia de teste", artista.getBiografia());
    assertEquals("Brasil", artista.getPaisOrigem());
    assertEquals("Rock", artista.getGenero());
  }

  @Test
  void testConstrutorComTodosArgumentos() {
    Artista artista = new Artista(1L, "Artista Teste", "Brasileiro", "Biografia de teste", "Brasil",
        "Rock");

    assertEquals(1L, artista.getId());
    assertEquals("Artista Teste", artista.getNome());
    assertEquals("Brasileiro", artista.getNacionalidade());
    assertEquals("Biografia de teste", artista.getBiografia());
    assertEquals("Brasil", artista.getPaisOrigem());
    assertEquals("Rock", artista.getGenero());
  }
}
