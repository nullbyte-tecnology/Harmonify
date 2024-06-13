package com.harmonify.backspring.api.contracts.requests;

import com.harmonify.backspring.domain.models.Artista;
import com.harmonify.backspring.domain.models.enums.GeneroMusical;
import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class ArtistaDTOTest {

  @Test
  void testDefaultConstructor() {
    Artista artista = new Artista();
    assertNotNull(artista);
  }

  @Test
  void testAllArgsConstructor() {
    UUID id = UUID.randomUUID();
    String nome = "Artista Teste";
    byte[] foto = new byte[]{1, 2, 3};
    String biografia = "Biografia Teste";
    String paisOrigem = "Brasil";
    GeneroMusical genero = GeneroMusical.ROCK;

    Artista artista = new Artista(id, nome, foto, biografia, paisOrigem, genero);

    assertEquals(id, artista.getId());
    assertEquals(nome, artista.getNome());
    assertArrayEquals(foto, artista.getFoto());
    assertEquals(biografia, artista.getBiografia());
    assertEquals(paisOrigem, artista.getPaisOrigem());
    assertEquals(genero, artista.getGenero());
  }

  @Test
  void testArtistaDTOConstructor() {
    String nome = "Artista DTO";
    byte[] foto = new byte[]{4, 5, 6};
    String biografia = "Biografia DTO";
    String paisOrigem = "Portugal";
    GeneroMusical genero = GeneroMusical.JAZZ;

    ArtistaDTO artistaDTO = new ArtistaDTO(nome, foto, biografia, paisOrigem, genero);
    Artista artista = new Artista(artistaDTO);

    assertEquals(nome, artista.getNome());
    assertArrayEquals(foto, artista.getFoto());
    assertEquals(biografia, artista.getBiografia());
    assertEquals(paisOrigem, artista.getPaisOrigem());
    assertEquals(genero, artista.getGenero());
  }
}
