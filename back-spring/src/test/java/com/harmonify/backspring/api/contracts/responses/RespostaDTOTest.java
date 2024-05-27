package com.harmonify.backspring.api.contracts.responses;

import static org.assertj.core.api.Assertions.assertThat;

import com.harmonify.backspring.api.contracts.requests.MusicaDTO;
import com.harmonify.backspring.domain.models.Musica;
import java.sql.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.jupiter.api.Test;

class RespostaDTOTest {

  @Test
  void testConstrutorComMusica() {
    byte[] foto = {0x12, 0x34, 0x56, 0x78};
    MusicaDTO musicaDTO = new MusicaDTO("Nome da Música", "Artista", "Rock", "03:45",
        Date.valueOf("2022-01-01"), foto);
    Musica musica = new Musica(musicaDTO);

    RespostaDTO respostaDTO = new RespostaDTO(musica);

    assertThat(respostaDTO.nome()).isEqualTo("Nome da Música");
    assertThat(respostaDTO.artista()).isEqualTo("Artista");
    assertThat(respostaDTO.generoMusical()).isEqualTo("Rock");
    assertThat(respostaDTO.duracao()).isEqualTo("03:45");
    assertThat(respostaDTO.dataLancamento()).isEqualTo(Date.valueOf("2022-01-01"));
    assertThat(respostaDTO.foto()).isEqualTo(Base64.encodeBase64String(foto));
  }

  @Test
  void testConstrutorComValores() {
    byte[] foto = {0x12, 0x34, 0x56, 0x78};
    RespostaDTO respostaDTO = new RespostaDTO("Nome da Música", "Artista", "Rock", "03:45",
        Date.valueOf("2022-01-01"), Base64.encodeBase64String(foto));

    assertThat(respostaDTO.nome()).isEqualTo("Nome da Música");
    assertThat(respostaDTO.artista()).isEqualTo("Artista");
    assertThat(respostaDTO.generoMusical()).isEqualTo("Rock");
    assertThat(respostaDTO.duracao()).isEqualTo("03:45");
    assertThat(respostaDTO.dataLancamento()).isEqualTo(Date.valueOf("2022-01-01"));
    assertThat(respostaDTO.foto()).isEqualTo(Base64.encodeBase64String(foto));
  }
}
