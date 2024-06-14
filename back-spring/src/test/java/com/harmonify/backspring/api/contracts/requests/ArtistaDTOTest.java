package com.harmonify.backspring.api.contracts.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.harmonify.backspring.domain.models.Artista;
import com.harmonify.backspring.domain.models.enums.GeneroMusical;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class ArtistaDTOTest {

  @Test
  void testConstrutorCopia() {
    Artista artista = new Artista(UUID.randomUUID(), "Artista Teste", new byte[0],
        "Biografia Teste",
        "Brasil", GeneroMusical.ROCK);

    ArtistaDTO artistaDTO = new ArtistaDTO(artista);

    assertEquals(artista.getNome(), artistaDTO.nome());
    assertEquals(artista.getFoto(), artistaDTO.foto());
    assertEquals(artista.getBiografia(), artistaDTO.biografia());
    assertEquals(artista.getPaisOrigem(), artistaDTO.paisOrigem());
    assertEquals(artista.getGenero(), artistaDTO.genero());
  }

  @Test
  void testConstrutorCopiaComNull() {
    Artista artista = new Artista(null, null, null, null, null, null);

    ArtistaDTO artistaDTO = new ArtistaDTO(artista);

    assertEquals(artista.getNome(), artistaDTO.nome());
    assertEquals(artista.getFoto(), artistaDTO.foto());
    assertEquals(artista.getBiografia(), artistaDTO.biografia());
    assertEquals(artista.getPaisOrigem(), artistaDTO.paisOrigem());
    assertEquals(artista.getGenero(), artistaDTO.genero());
  }
}
