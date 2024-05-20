package com.harmonify.backspring.dominio.dto;

import com.harmonify.backspring.dominio.Musica;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;

class MusicaDTOTest {

  @Test
  void testConstrutorComMusica() {
    MusicaDTO musicaDTOTeste = new MusicaDTO("Nome da Música", "Artista", "Rock", "03:45", Date.valueOf("2022-01-01"), new byte[0]);

    Musica musica = new Musica(musicaDTOTeste);

    MusicaDTO musicaDTO = new MusicaDTO(musica);

    assertThat(musicaDTO.nome()).isEqualTo("Nome da Música");
    assertThat(musicaDTO.artista()).isEqualTo("Artista");
    assertThat(musicaDTO.generoMusical()).isEqualTo("Rock");
    assertThat(musicaDTO.duracao()).isEqualTo("03:45");
    assertThat(musicaDTO.lancamento()).isEqualTo(Date.valueOf("2022-01-01"));
    assertThat(musicaDTO.arquivo()).isEqualTo(new byte[0]);
  }

  @Test
  void testConstrutorComValores() {
    MusicaDTO musicaDTO = new MusicaDTO("Nome da Música", "Artista", "Rock", "03:45", Date.valueOf("2022-01-01"), new byte[0]);

    assertThat(musicaDTO.nome()).isEqualTo("Nome da Música");
    assertThat(musicaDTO.artista()).isEqualTo("Artista");
    assertThat(musicaDTO.generoMusical()).isEqualTo("Rock");
    assertThat(musicaDTO.duracao()).isEqualTo("03:45");
    assertThat(musicaDTO.lancamento()).isEqualTo(Date.valueOf("2022-01-01"));
    assertThat(musicaDTO.arquivo()).isEqualTo(new byte[0]);
  }
}
