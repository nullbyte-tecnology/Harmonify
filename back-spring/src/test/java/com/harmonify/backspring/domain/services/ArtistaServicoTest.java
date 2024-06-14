package com.harmonify.backspring.domain.services;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.harmonify.backspring.api.contracts.requests.ArtistaDTO;
import com.harmonify.backspring.api.contracts.requests.FiltroDTO;
import com.harmonify.backspring.api.contracts.responses.RespArtistaDTO;
import com.harmonify.backspring.domain.exception.RecursoNaoEncontradoExcecao;
import com.harmonify.backspring.domain.models.Artista;
import com.harmonify.backspring.domain.models.enums.GeneroMusical;
import com.harmonify.backspring.infrastructure.repositories.ArtistaRepositorio;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.domain.Specification;

class ArtistaServicoTest {

  @Mock
  private ArtistaRepositorio artistaRepositorio;

  @InjectMocks
  private ArtistaServico artistaServico;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testListarArtistasSemFiltro() {
    Artista artista1 = new Artista(UUID.randomUUID(), "Artista1", new byte[]{1, 2, 3}, "Biografia1",
        "Brasil", GeneroMusical.ROCK);
    Artista artista2 = new Artista(UUID.randomUUID(), "Artista2", new byte[]{4, 5, 6}, "Biografia2",
        "Argentina", GeneroMusical.JAZZ);

    when(artistaRepositorio.findAll()).thenReturn(Arrays.asList(artista1, artista2));

    List<RespArtistaDTO> artistas = artistaServico.listarArtistas(null);

    assertEquals(2, artistas.size());
    assertEquals("Artista1", artistas.get(0).nome());
    assertEquals("Artista2", artistas.get(1).nome());
  }

  @Test
  void testListarArtistasComFiltro() {
    Artista artista1 = new Artista(UUID.randomUUID(), "Artista1", new byte[]{1, 2, 3}, "Biografia1",
        "Brasil", GeneroMusical.ROCK);

    when(artistaRepositorio.findAll(any(Specification.class))).thenReturn(Arrays.asList(artista1));

    List<RespArtistaDTO> artistas = artistaServico.listarArtistas(new FiltroDTO("ROCK", "Brasil"));

    assertEquals(1, artistas.size());
    assertEquals("Artista1", artistas.get(0).nome());
  }

  @Test
  void testEncontrarArtista() {
    UUID id = UUID.randomUUID();
    Artista artista = new Artista(id, "Artista", new byte[]{1, 2, 3}, "Biografia", "Brasil",
        GeneroMusical.ROCK);

    when(artistaRepositorio.findById(id)).thenReturn(Optional.of(artista));

    RespArtistaDTO artistaDTO = artistaServico.encontrarArtista(id);

    assertNotNull(artistaDTO);
    assertEquals("Artista", artistaDTO.nome());
  }

  @Test
  void testEncontrarArtistaNaoExistente() {
    UUID id = UUID.randomUUID();

    when(artistaRepositorio.findById(id)).thenReturn(Optional.empty());

    assertThrows(RecursoNaoEncontradoExcecao.class, () -> artistaServico.encontrarArtista(id));
  }

  @Test
  void testSalvarArtista() {
    ArtistaDTO artistaDTO = new ArtistaDTO("Artista", new byte[]{1, 2, 3}, "Biografia", "Brasil",
        GeneroMusical.ROCK);
    Artista artista = new Artista(artistaDTO);

    when(artistaRepositorio.save(any(Artista.class))).thenReturn(artista);

    artistaServico.salvarArtista(artistaDTO);

    verify(artistaRepositorio, times(1)).save(any(Artista.class));
  }

  @Test
  void testAtualizarArtista() {
    UUID id = UUID.randomUUID();
    ArtistaDTO artistaDTO = new ArtistaDTO("Artista Atualizado", new byte[]{4, 5, 6},
        "Biografia Atualizada", "Argentina", GeneroMusical.JAZZ);
    Artista artista = new Artista(id, "Artista", new byte[]{1, 2, 3}, "Biografia", "Brasil",
        GeneroMusical.ROCK);

    when(artistaRepositorio.findById(id)).thenReturn(Optional.of(artista));
    when(artistaRepositorio.save(any(Artista.class))).thenReturn(artista);

    artistaServico.atualizarArtista(id, artistaDTO);

    verify(artistaRepositorio, times(1)).findById(id);
    verify(artistaRepositorio, times(1)).save(any(Artista.class));

    assertEquals("Artista Atualizado", artista.getNome());
    assertArrayEquals(new byte[]{4, 5, 6}, artista.getFoto());
    assertEquals("Biografia Atualizada", artista.getBiografia());
    assertEquals("Argentina", artista.getPaisOrigem());
    assertEquals(GeneroMusical.JAZZ, artista.getGenero());
  }

  @Test
  void testAtualizarArtistaNaoExistente() {
    UUID id = UUID.randomUUID();
    ArtistaDTO artistaDTO = new ArtistaDTO("Artista Atualizado", new byte[]{4, 5, 6},
        "Biografia Atualizada", "Argentina", GeneroMusical.JAZZ);

    when(artistaRepositorio.findById(id)).thenReturn(Optional.empty());

    assertThrows(RecursoNaoEncontradoExcecao.class,
        () -> artistaServico.atualizarArtista(id, artistaDTO));
  }

  @Test
  void testDeletarArtista() {
    UUID id = UUID.randomUUID();
    Artista artista = new Artista(id, "Artista", new byte[]{1, 2, 3}, "Biografia", "Brasil",
        GeneroMusical.ROCK);

    when(artistaRepositorio.findById(id)).thenReturn(Optional.of(artista));
    doNothing().when(artistaRepositorio).delete(any(Artista.class));

    artistaServico.deletarArtista(id);

    verify(artistaRepositorio, times(1)).findById(id);
    verify(artistaRepositorio, times(1)).delete(any(Artista.class));
  }

  @Test
  void testDeletarArtistaNaoExistente() {
    UUID id = UUID.randomUUID();

    when(artistaRepositorio.findById(id)).thenReturn(Optional.empty());

    assertThrows(RecursoNaoEncontradoExcecao.class, () -> artistaServico.deletarArtista(id));
  }
}
