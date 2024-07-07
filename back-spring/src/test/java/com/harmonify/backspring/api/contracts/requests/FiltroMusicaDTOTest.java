package com.harmonify.backspring.api.contracts.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class FiltroMusicaDTOTest {

  @Test
  void testFiltroMusicaDTOCreation() {
    String nomeArtista = "Queen";
    String genero = "Rock";

    FiltroMusicaDTO filtroMusicaDTO = new FiltroMusicaDTO(nomeArtista, genero);

    assertNotNull(filtroMusicaDTO);
    assertEquals(nomeArtista, filtroMusicaDTO.nomeArtista());
    assertEquals(genero, filtroMusicaDTO.genero());
  }

  @Test
  void testFiltroMusicaDTONullValues() {

    FiltroMusicaDTO filtroMusicaDTO = new FiltroMusicaDTO(null, null);

    assertNotNull(filtroMusicaDTO);
    assertNull(filtroMusicaDTO.nomeArtista());
    assertNull(filtroMusicaDTO.genero());
  }
}
