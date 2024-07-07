package com.harmonify.backspring.api.contracts.responses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.harmonify.backspring.domain.models.Artista;
import com.harmonify.backspring.domain.models.enums.GeneroMusical;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class RespArtistaDTOTest {

  @Test
  void testRespArtistaDTOCreation() {
    String nome = "Queen";
    String genero = GeneroMusical.ROCK.getValor();
    byte[] foto = new byte[]{1, 2, 3};
    String biografia = "Uma breve biografia.";
    String paisOrigem = "Reino Unido";

    RespArtistaDTO respArtistaDTO = new RespArtistaDTO(nome, genero, foto, biografia, paisOrigem);

    assertNotNull(respArtistaDTO);
    assertEquals(nome, respArtistaDTO.nome());
    assertEquals(genero, respArtistaDTO.genero());
    assertEquals(foto, respArtistaDTO.foto());
    assertEquals(biografia, respArtistaDTO.biografia());
    assertEquals(paisOrigem, respArtistaDTO.paisOrigem());
  }

  @Test
  void testRespArtistaDTOCreationFromArtista() {
    Artista artista = new Artista(
        UUID.randomUUID(),
        "Queen",
        new byte[]{1, 2, 3},
        "Uma breve biografia.",
        "Reino Unido",
        GeneroMusical.ROCK
    );

    RespArtistaDTO respArtistaDTO = new RespArtistaDTO(artista);

    assertNotNull(respArtistaDTO);
    assertEquals(artista.getNome(), respArtistaDTO.nome());
    assertEquals(artista.getGenero().getValor(), respArtistaDTO.genero());
    assertEquals(artista.getFoto(), respArtistaDTO.foto());
    assertEquals(artista.getBiografia(), respArtistaDTO.biografia());
    assertEquals(artista.getPaisOrigem(), respArtistaDTO.paisOrigem());
  }
}
