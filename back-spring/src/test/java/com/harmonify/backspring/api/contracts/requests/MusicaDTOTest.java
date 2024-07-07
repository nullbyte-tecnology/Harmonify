package com.harmonify.backspring.api.contracts.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.harmonify.backspring.domain.models.Artista;
import com.harmonify.backspring.domain.models.Musica;
import com.harmonify.backspring.domain.models.enums.GeneroMusical;
import java.sql.Date;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class MusicaDTOTest {

  @Test
  void testMusicaDTOCreation() {
    String nome = "Bohemian Rhapsody";
    UUID idArtista = UUID.randomUUID();
    GeneroMusical genero = GeneroMusical.ROCK;
    String duracao = "5:55";
    Date lancamento = Date.valueOf("1975-10-31");
    byte[] foto = new byte[]{1, 2, 3};

    MusicaDTO musicaDTO = new MusicaDTO(nome, idArtista, genero, duracao, lancamento, foto);

    assertNotNull(musicaDTO);
    assertEquals(nome, musicaDTO.nome());
    assertEquals(idArtista, musicaDTO.idArtista());
    assertEquals(genero, musicaDTO.genero());
    assertEquals(duracao, musicaDTO.duracao());
    assertEquals(lancamento, musicaDTO.lancamento());
    assertEquals(foto, musicaDTO.foto());
  }

  @Test
  void testMusicaDTOCreationFromMusica() {
    UUID idArtista = UUID.randomUUID();
    Artista artista = new Artista(idArtista, "Queen", new byte[0], "Biografia", "Brasil",
        GeneroMusical.ROCK);
    Musica musica = new Musica(
        new MusicaDTO(
            "Bohemian Rhapsody",
            idArtista,
            GeneroMusical.ROCK,
            "5:55",
            Date.valueOf("1975-10-31"),
            new byte[]{1, 2, 3}
        ),
        artista
    );

    MusicaDTO musicaDTO = new MusicaDTO(musica);

    assertNotNull(musicaDTO);
    assertEquals(musica.getNome(), musicaDTO.nome());
    assertEquals(musica.getArtista().getId(), musicaDTO.idArtista());
    assertEquals(musica.getGenero(), musicaDTO.genero());
    assertEquals(musica.getDuracao(), musicaDTO.duracao());
    assertEquals(musica.getLancamento(), musicaDTO.lancamento());
    assertEquals(musica.getFoto(), musicaDTO.foto());
  }
}
