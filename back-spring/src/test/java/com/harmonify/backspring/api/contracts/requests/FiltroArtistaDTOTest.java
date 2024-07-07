package com.harmonify.backspring.api.contracts.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class FiltroArtistaDTOTest {

  @Test
  void testFiltroArtistaDTOCreation() {
    String genero = "Rock";
    String paisOrigem = "Brasil";

    FiltroArtistaDTO filtroArtistaDTO = new FiltroArtistaDTO(genero, paisOrigem);

    assertNotNull(filtroArtistaDTO);
    assertEquals(genero, filtroArtistaDTO.genero());
    assertEquals(paisOrigem, filtroArtistaDTO.paisOrigem());
  }

  @Test
  void testFiltroArtistaDTONullValues() {

    FiltroArtistaDTO filtroArtistaDTO = new FiltroArtistaDTO(null, null);

    assertNotNull(filtroArtistaDTO);
    assertNull(filtroArtistaDTO.genero());
    assertNull(filtroArtistaDTO.paisOrigem());
  }
}
