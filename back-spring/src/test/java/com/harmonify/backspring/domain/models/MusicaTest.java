package com.harmonify.backspring.domain.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import com.harmonify.backspring.api.contracts.requests.MusicaDTO;
import java.sql.Date;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MusicaTest {

  @Test
  void testConstrutorComMusicaDTO() {
    MusicaDTO musicaDTO = Mockito.mock(MusicaDTO.class);
    when(musicaDTO.nome()).thenReturn("Nome da Música");
    when(musicaDTO.artista()).thenReturn("Artista");
    when(musicaDTO.generoMusical()).thenReturn("Rock");
    when(musicaDTO.duracao()).thenReturn("03:45");
    when(musicaDTO.lancamento()).thenReturn(Date.valueOf("2022-01-01"));
    byte[] foto = {0x12, 0x34, 0x56, 0x78};
    when(musicaDTO.arquivo()).thenReturn(foto);

    Musica musica = new Musica(musicaDTO);

    assertThat(musica.getNome()).isEqualTo("Nome da Música");
    assertThat(musica.getArtista()).isEqualTo("Artista");
    assertThat(musica.getGenero()).isEqualTo("Rock");
    assertThat(musica.getDuracaoSegundos()).isEqualTo("03:45");
    assertThat(musica.getLancamento()).isEqualTo(Date.valueOf("2022-01-01"));
    assertThat(musica.getFoto()).isEqualTo(foto);
  }

  @Test
  void testConstrutorSemArgumentos() {
    Musica musica = new Musica();

    assertNull(musica.getId());
    assertNull(musica.getNome());
    assertNull(musica.getArtista());
    assertNull(musica.getGenero());
    assertNull(musica.getDuracaoSegundos());
    assertNull(musica.getLancamento());
    assertNull(musica.getFoto());
  }

  @Test
  void testConstrutorComTodosArgumentos() {
    byte[] foto = {0x12, 0x34, 0x56, 0x78};
    Musica musica = new Musica(1L, "Nome da Música", "Artista", "Rock", "03:45",
        Date.valueOf("2022-01-01"), foto);

    assertEquals(1L, musica.getId());
    assertEquals("Nome da Música", musica.getNome());
    assertEquals("Artista", musica.getArtista());
    assertEquals("Rock", musica.getGenero());
    assertEquals("03:45", musica.getDuracaoSegundos());
    assertEquals(Date.valueOf("2022-01-01"), musica.getLancamento());
    assertEquals(foto, musica.getFoto());
  }
}
