package com.harmonify.backspring.domain.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.harmonify.backspring.api.contracts.requests.FiltroMusicaDTO;
import com.harmonify.backspring.api.contracts.requests.MusicaDTO;
import com.harmonify.backspring.api.contracts.responses.RespMusicaDTO;
import com.harmonify.backspring.domain.exception.RecursoNaoEncontradoExcecao;
import com.harmonify.backspring.domain.models.Artista;
import com.harmonify.backspring.domain.models.Musica;
import com.harmonify.backspring.domain.models.enums.GeneroMusical;
import com.harmonify.backspring.infrastructure.repositories.ArtistaRepositorio;
import com.harmonify.backspring.infrastructure.repositories.MusicaRepositorio;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.domain.Specification;

class MusicaServicoTest {

  @Mock
  private MusicaRepositorio musicaRepositorio;

  @Mock
  private ArtistaRepositorio artistaRepositorio;

  @InjectMocks
  private MusicaServico musicaServico;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testListarMusicas() {
    FiltroMusicaDTO filtroDTO = new FiltroMusicaDTO("ArtistaTeste", "Rock");
    Musica musica1 = new Musica(UUID.randomUUID(), "Música 1", new Artista(), GeneroMusical.ROCK,
        "4:30", new Date(System.currentTimeMillis()), new byte[]{});
    Musica musica2 = new Musica(UUID.randomUUID(), "Música 2", new Artista(), GeneroMusical.POP,
        "3:45", new Date(System.currentTimeMillis()), new byte[]{});
    List<Musica> musicas = List.of(musica1, musica2);

    when(musicaRepositorio.findAll(any(Specification.class))).thenReturn(musicas);

    List<RespMusicaDTO> result = musicaServico.listarMusicas(filtroDTO);

    assertNotNull(result);
    assertEquals(2, result.size());
    assertEquals(musica1.getNome(), result.get(0).nome());
    assertEquals(musica2.getNome(), result.get(1).nome());
  }

  @Test
  void testEncontrarMusicaExistente() {
    UUID idExistente = UUID.randomUUID();
    Musica musica = new Musica(idExistente, "Música Teste", new Artista(), GeneroMusical.ROCK,
        "5:00", new Date(System.currentTimeMillis()), new byte[]{});

    when(musicaRepositorio.findById(idExistente)).thenReturn(Optional.of(musica));

    RespMusicaDTO result = musicaServico.encontrarMusica(idExistente);

    assertNotNull(result);
    assertEquals(musica.getNome(), result.nome());
  }

  @Test
  void testEncontrarMusicaNaoExistente() {
    UUID idNaoExistente = UUID.randomUUID();

    when(musicaRepositorio.findById(idNaoExistente)).thenReturn(Optional.empty());
    assertThrows(RecursoNaoEncontradoExcecao.class,
        () -> musicaServico.encontrarMusica(idNaoExistente));
  }

  @Test
  void testSalvarMusicaComArtistaExistenteEGeneroValido() {
    UUID idArtistaExistente = UUID.randomUUID();
    MusicaDTO musicaDTO = new MusicaDTO("Música Teste", idArtistaExistente, GeneroMusical.ROCK,
        "4:15", new Date(System.currentTimeMillis()), new byte[]{});
    Artista artista = new Artista(
        idArtistaExistente,
        "Artista Teste",
        new byte[]{},
        "Biografia Teste",
        "Pais Teste",
        GeneroMusical.ROCK
    );

    when(artistaRepositorio.findById(idArtistaExistente)).thenReturn(Optional.of(artista));

    assertDoesNotThrow(() -> musicaServico.salvarMusica(musicaDTO));
  }

  @Test
  void testSalvarMusicaComArtistaInexistente() {
    UUID idArtistaInexistente = UUID.randomUUID();
    MusicaDTO musicaDTO = new MusicaDTO("Música Teste", idArtistaInexistente, GeneroMusical.ROCK,
        "4:15", new Date(System.currentTimeMillis()), new byte[]{});

    when(artistaRepositorio.findById(idArtistaInexistente)).thenReturn(Optional.empty());

    assertThrows(RecursoNaoEncontradoExcecao.class, () -> musicaServico.salvarMusica(musicaDTO));
  }

  @Test
  void testEditarMusicaExistente() {
    UUID idExistente = UUID.randomUUID();
    MusicaDTO musicaDTO = new MusicaDTO("Música Editada", null, GeneroMusical.POP, "3:30",
        new Date(System.currentTimeMillis()), new byte[]{});
    Musica musica = new Musica(idExistente, "Música Original", new Artista(), GeneroMusical.ROCK,
        "4:00", new Date(System.currentTimeMillis()), new byte[]{});

    when(musicaRepositorio.findById(idExistente)).thenReturn(Optional.of(musica));
    when(musicaRepositorio.save(any(Musica.class))).thenReturn(musica);

    assertDoesNotThrow(() -> musicaServico.editarMusica(idExistente, musicaDTO));
  }

  @Test
  void testEditarMusicaNaoExistente() {
    UUID idNaoExistente = UUID.randomUUID();
    MusicaDTO musicaDTO = new MusicaDTO("Música Editada", null, GeneroMusical.POP, "3:30",
        new Date(System.currentTimeMillis()), new byte[]{});

    when(musicaRepositorio.findById(idNaoExistente)).thenReturn(Optional.empty());

    assertThrows(RecursoNaoEncontradoExcecao.class,
        () -> musicaServico.editarMusica(idNaoExistente, musicaDTO));
  }

  @Test
  void testEditarMusicaComArtistaInexistente() {
    UUID idExistente = UUID.randomUUID();
    UUID idArtistaNaoExistente = UUID.randomUUID();
    MusicaDTO musicaDTO = new MusicaDTO("Nova Música", idArtistaNaoExistente, null, "5:00", null, new byte[]{});
    Musica musicaExistente = new Musica(musicaDTO, new Artista());
    when(musicaRepositorio.findById(idExistente)).thenReturn(Optional.of(musicaExistente));
    when(artistaRepositorio.findById(idArtistaNaoExistente)).thenReturn(Optional.empty());

    assertThrows(RecursoNaoEncontradoExcecao.class, () -> musicaServico.editarMusica(idExistente, musicaDTO));
  }

  @Test
  void testDeletarMusicaExistente() {
    UUID idExistente = UUID.randomUUID();
    Musica musica = new Musica(idExistente, "Música Teste", new Artista(), GeneroMusical.ROCK,
        "4:00", new Date(System.currentTimeMillis()), new byte[]{});

    when(musicaRepositorio.findById(idExistente)).thenReturn(Optional.of(musica));

    assertDoesNotThrow(() -> musicaServico.deletarMusica(idExistente));
  }

  @Test
  void testDeletarMusicaNaoExistente() {
    UUID idNaoExistente = UUID.randomUUID();

    when(musicaRepositorio.findById(idNaoExistente)).thenReturn(Optional.empty());

    assertThrows(RecursoNaoEncontradoExcecao.class,
        () -> musicaServico.deletarMusica(idNaoExistente));
  }

  @Test
  void testValidarMusicaComGeneroValido() {
    MusicaDTO musicaDTO = new MusicaDTO("Música Teste", UUID.randomUUID(), GeneroMusical.POP,
        "4:30", new Date(System.currentTimeMillis()), new byte[]{});

    boolean result = musicaServico.validarMusica(musicaDTO);

    assertTrue(result);
  }
}
