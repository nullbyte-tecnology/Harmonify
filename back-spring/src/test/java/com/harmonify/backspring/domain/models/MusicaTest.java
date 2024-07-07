package com.harmonify.backspring.domain.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

import com.harmonify.backspring.api.contracts.requests.MusicaDTO;
import com.harmonify.backspring.domain.models.enums.GeneroMusical;
import java.sql.Date;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class MusicaTest {

  @Test
  void testMusicaConstructorFromMusicaDTO() {
    MusicaDTO musicaDTO = new MusicaDTO(
        "Bohemian Rhapsody",
        UUID.randomUUID(),
        GeneroMusical.ROCK,
        "5:55",
        Date.valueOf("1975-10-31"),
        new byte[]{1, 2, 3}
    );

    Artista artistaMock = mock(Artista.class);

    Musica musica = new Musica(musicaDTO, artistaMock);

    assertNotNull(musica);
    assertEquals(musicaDTO.nome(), musica.getNome());
    assertEquals(artistaMock, musica.getArtista());
    assertEquals(musicaDTO.genero(), musica.getGenero());
    assertEquals(musicaDTO.duracao(), musica.getDuracao());
    assertEquals(musicaDTO.lancamento(), musica.getLancamento());
    assertEquals(musicaDTO.foto(), musica.getFoto());
  }

  @Test
  void testMusicaEmptyConstructor() {
    Musica musica = new Musica();

    assertNotNull(musica);
    assertNull(musica.getId());
    assertNull(musica.getNome());
    assertNull(musica.getArtista());
    assertNull(musica.getGenero());
    assertNull(musica.getDuracao());
    assertNull(musica.getLancamento());
    assertNull(musica.getFoto());
  }

  @Test
  void testMusicaConstructorFromMusicaDTOWithNullArtista() {
    MusicaDTO musicaDTO = new MusicaDTO(
        "Bohemian Rhapsody",
        null,
        GeneroMusical.ROCK,
        "5:55",
        Date.valueOf("1975-10-31"),
        new byte[]{1, 2, 3}
    );

    Musica musica = new Musica(musicaDTO, null);

    assertNotNull(musica);
    assertEquals(musicaDTO.nome(), musica.getNome());
    assertNull(musica.getArtista());
    assertEquals(musicaDTO.genero(), musica.getGenero());
    assertEquals(musicaDTO.duracao(), musica.getDuracao());
    assertEquals(musicaDTO.lancamento(), musica.getLancamento());
    assertEquals(musicaDTO.foto(), musica.getFoto());
  }

  @Test
  void testMusicaAllArgsConstructor() {
    UUID id = UUID.randomUUID();
    String nome = "Bohemian Rhapsody";
    Artista artista = mock(Artista.class);
    GeneroMusical genero = GeneroMusical.ROCK;
    String duracao = "5:55";
    Date lancamento = Date.valueOf("1975-10-31");
    byte[] foto = new byte[]{1, 2, 3};

    Musica musica = new Musica(id, nome, artista, genero, duracao, lancamento, foto);

    assertNotNull(musica);
    assertEquals(id, musica.getId());
    assertEquals(nome, musica.getNome());
    assertEquals(artista, musica.getArtista());
    assertEquals(genero, musica.getGenero());
    assertEquals(duracao, musica.getDuracao());
    assertEquals(lancamento, musica.getLancamento());
    assertEquals(foto, musica.getFoto());
  }
}
