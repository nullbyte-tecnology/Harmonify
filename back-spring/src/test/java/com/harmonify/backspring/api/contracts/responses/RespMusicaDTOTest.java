package com.harmonify.backspring.api.contracts.responses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.harmonify.backspring.api.contracts.requests.MusicaDTO;
import com.harmonify.backspring.domain.models.Artista;
import com.harmonify.backspring.domain.models.Musica;
import com.harmonify.backspring.domain.models.enums.GeneroMusical;
import java.sql.Date;
import java.util.UUID;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.jupiter.api.Test;

class RespMusicaDTOTest {

  @Test
  void testRespMusicaDTOCreation() {
    String nome = "Bohemian Rhapsody";
    String nomeArtista = "Queen";
    String genero = GeneroMusical.ROCK.getValor();
    String duracao = "5:55";
    Date dataLancamento = Date.valueOf("1975-10-31");
    byte[] foto = new byte[]{1, 2, 3};
    String fotoBase64 = Base64.encodeBase64String(foto);

    RespMusicaDTO respMusicaDTO = new RespMusicaDTO(nome, nomeArtista, genero, duracao,
        dataLancamento, fotoBase64);

    assertNotNull(respMusicaDTO);
    assertEquals(nome, respMusicaDTO.nome());
    assertEquals(nomeArtista, respMusicaDTO.artista());
    assertEquals(genero, respMusicaDTO.genero());
    assertEquals(duracao, respMusicaDTO.duracao());
    assertEquals(dataLancamento, respMusicaDTO.dataLancamento());
    assertEquals(fotoBase64, respMusicaDTO.foto());
  }

  @Test
  void testRespMusicaDTOCreationFromMusica() {
    Artista artista = new Artista(
        UUID.randomUUID(),
        "Queen",
        new byte[0],
        "Biografia",
        "Reino Unido",
        GeneroMusical.ROCK
    );

    Musica musica = new Musica(
        new MusicaDTO(
            "Bohemian Rhapsody",
            artista.getId(),
            GeneroMusical.ROCK,
            "5:55",
            Date.valueOf("1975-10-31"),
            new byte[]{1, 2, 3}
        ), artista);

    RespMusicaDTO respMusicaDTO = new RespMusicaDTO(musica);

    assertNotNull(respMusicaDTO);
    assertEquals(musica.getNome(), respMusicaDTO.nome());
    assertEquals(musica.getArtista().getNome(), respMusicaDTO.artista());
    assertEquals(musica.getGenero().getValor(), respMusicaDTO.genero());
    assertEquals(musica.getDuracao(), respMusicaDTO.duracao());
    assertEquals(musica.getLancamento(), respMusicaDTO.dataLancamento());
    assertEquals(Base64.encodeBase64String(musica.getFoto()), respMusicaDTO.foto());
  }
}
