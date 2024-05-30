package com.harmonify.backspring.domain.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.harmonify.backspring.api.contracts.requests.ArtistaDTO;
import com.harmonify.backspring.domain.models.Artista;
import com.harmonify.backspring.infrastructure.repositories.ArtistaRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ArtistaServicoTest {

  @Mock
  private ArtistaRepositorio artistaRepositorioMock;

  @InjectMocks
  private ArtistaServico artistaServico;

  private List<Artista> artistasMock;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);

    artistasMock = new ArrayList<>();
    artistasMock.add(new Artista(
        new ArtistaDTO("Artista 1", "Genero 1", "Nacionalidade 1", "Biografia", "Pais 1")));
    artistasMock.add(new Artista(
        new ArtistaDTO("Artista 2", "Genero 2", "Nacionalidade 2", "Biografia", "Pais 2")));
  }

  @Test
  void testListarArtistas() {
    when(artistaRepositorioMock.findAll()).thenReturn(artistasMock);

    List<ArtistaDTO> artistasEncontrados = artistaServico.listarArtistas();

    assertThat(artistasEncontrados).isNotEmpty()
        .hasSize(2);

  }

  @Test
  void testSalvarArtista() {
    ArtistaDTO artistaDTO = new ArtistaDTO("Artista 1", "Genero 1", "Nacionalidade 1", "Biografia",
        "Pais 1");

    artistaServico.salvarArtista(artistaDTO);

    verify(artistaRepositorioMock, times(1)).save(
        any(Artista.class));  // Verifica se o método save foi chamado com um Artista
  }

  @Test
  void testAtualizarArtista() {
    Long id = 1L;
    ArtistaDTO artistaDTO = new ArtistaDTO("Artista Atualizado", "Genero Atualizado",
        "Nacionalidade Atualizada", "Biografia Atualizada", "Pais Atualizado");

    when(artistaRepositorioMock.findById(id)).thenReturn(
        Optional.of(artistasMock.get(0)));  // Simula busca por ID

    artistaServico.atualizarArtista(id, artistaDTO);

    verify(artistaRepositorioMock, times(1)).save(
        any(Artista.class));  // Verifica se o método save foi chamado
  }

  @Test
  void testAtualizarArtista_ArtistaNaoEncontrado() {
    Long id = 1L;
    ArtistaDTO artistaDTO = new ArtistaDTO("Artista Atualizado", "Genero Atualizado",
        "Nacionalidade Atualizada", "Biografia Atualizada", "Pais Atualizado");

    when(artistaRepositorioMock.findById(id)).thenReturn(
        Optional.empty());  // Simula artista não encontrado

    try {
      artistaServico.atualizarArtista(id, artistaDTO);
    } catch (RuntimeException e) {
      assertThat(e.getMessage()).isEqualTo("Artista não encontrado");
    }

    verify(artistaRepositorioMock, times(0)).save(
        any(Artista.class));  // Verifica se o método save não foi chamado
  }

  @Test
  void testListarArtistasPorGenero() {
    String genero = "Genero 1";
    when(artistaRepositorioMock.findAllByGenero(genero)).thenReturn(
        artistasMock.subList(0, 1));  // Retorna apenas o primeiro artista

    List<ArtistaDTO> artistasEncontrados = artistaServico.listarArtistasPorGenero(genero);

    assertThat(artistasEncontrados).isNotEmpty()
        .hasSize(1);
    assertThat(artistasEncontrados.get(0).genero()).isEqualTo(genero);
  }
}
