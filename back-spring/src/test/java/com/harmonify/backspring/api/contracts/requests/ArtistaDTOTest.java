package com.harmonify.backspring.api.contracts.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.harmonify.backspring.domain.models.Artista;
import org.junit.jupiter.api.Test;

class ArtistaDTOTest {

  @Test
  void testConstrutorComArtista() {
    Artista artistaMock = mock(Artista.class);

    when(artistaMock.getNome()).thenReturn("Nome do Artista");
    when(artistaMock.getGenero()).thenReturn("Gênero do Artista");
    when(artistaMock.getNacionalidade()).thenReturn("Nacionalidade do Artista");
    when(artistaMock.getBiografia()).thenReturn("Biografia do Artista");
    when(artistaMock.getPaisOrigem()).thenReturn("País de Origem do Artista");

    ArtistaDTO artistaDTO = new ArtistaDTO(artistaMock);
    assertEquals("Nome do Artista", artistaDTO.nome());
    assertEquals("Gênero do Artista", artistaDTO.genero());
    assertEquals("Nacionalidade do Artista", artistaDTO.nacionalidade());
    assertEquals("Biografia do Artista", artistaDTO.biografia());
    assertEquals("País de Origem do Artista", artistaDTO.paisOrigem());
  }

  @Test
  void testConstrutorPadrao() {
    ArtistaDTO artistaDTO = new ArtistaDTO("Nome do Artista", "Gênero do Artista",
        "Nacionalidade do Artista", "Biografia do Artista", "País de Origem do Artista");

    assertEquals("Nome do Artista", artistaDTO.nome());
    assertEquals("Gênero do Artista", artistaDTO.genero());
    assertEquals("Nacionalidade do Artista", artistaDTO.nacionalidade());
    assertEquals("Biografia do Artista", artistaDTO.biografia());
    assertEquals("País de Origem do Artista", artistaDTO.paisOrigem());
  }
}