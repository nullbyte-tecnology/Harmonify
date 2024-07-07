package com.harmonify.backspring.api.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.harmonify.backspring.api.contracts.requests.ArtistaDTO;
import com.harmonify.backspring.api.contracts.responses.RespArtistaDTO;
import com.harmonify.backspring.domain.models.enums.GeneroMusical;
import com.harmonify.backspring.domain.services.ArtistaServico;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class ArtistaControladorTest {

  @Mock
  private ArtistaServico artistaServico;

  @InjectMocks
  private ArtistaControlador controlador;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testListarArtistasSemFiltro() {
    List<RespArtistaDTO> artistasMock = List.of(
        new RespArtistaDTO("Artista 1", "Rock", new byte[0], "Biografia do Artista 1", "Brasil"),
        new RespArtistaDTO("Artista 2", "Pop", new byte[0], "Biografia do Artista 2", "EUA")
    );

    when(artistaServico.listarArtistas(null)).thenReturn(artistasMock);

    ResponseEntity<List<RespArtistaDTO>> resposta = controlador.listarArtistas(null);

    assertEquals(HttpStatus.OK, resposta.getStatusCode());
    assertEquals(artistasMock.size(), Objects.requireNonNull(resposta.getBody()).size());
    assertEquals(artistasMock.get(0).nome(), resposta.getBody().get(0).nome());
    assertEquals(artistasMock.get(0).paisOrigem(), resposta.getBody().get(0).paisOrigem());
    assertEquals(artistasMock.get(0).genero(), resposta.getBody().get(0).genero());

    assertEquals(artistasMock.get(1).nome(), resposta.getBody().get(1).nome());
    assertEquals(artistasMock.get(1).paisOrigem(), resposta.getBody().get(1).paisOrigem());
    assertEquals(artistasMock.get(1).genero(), resposta.getBody().get(1).genero());

    verify(artistaServico, times(1)).listarArtistas(null);
  }

  @Test
  void testDetalharArtista() {
    UUID idArtista = UUID.randomUUID();
    RespArtistaDTO artistaMock = new RespArtistaDTO("Artista Detalhado", "Rock", new byte[0],
        "Biografia do Artista Detalhado", "Brasil");

    when(artistaServico.encontrarArtista(idArtista)).thenReturn(artistaMock);

    ResponseEntity<RespArtistaDTO> resposta = controlador.detalharArtista(idArtista);

    assertEquals(HttpStatus.OK, resposta.getStatusCode());
    assertEquals(artistaMock.nome(), Objects.requireNonNull(resposta.getBody()).nome());
    assertEquals(artistaMock.paisOrigem(), resposta.getBody().paisOrigem());
    assertEquals(artistaMock.genero(), resposta.getBody().genero());

    verify(artistaServico, times(1)).encontrarArtista(idArtista);
  }

  @Test
  void testSalvarArtista() throws Exception {
    ArtistaDTO artistaDTO = new ArtistaDTO("Novo Artista", new byte[0], "Biografia do Novo Artista",
        "Brasil", GeneroMusical.ROCK);

    ResponseEntity<String> resposta = controlador.salvarArtista(artistaDTO);

    assertEquals(HttpStatus.OK, resposta.getStatusCode());
    assertEquals("Artista salvo.", resposta.getBody());

    ArgumentCaptor<ArtistaDTO> artistaCaptor = ArgumentCaptor.forClass(ArtistaDTO.class);
    verify(artistaServico, times(1)).salvarArtista(artistaCaptor.capture());

    ArtistaDTO artistaCapturado = artistaCaptor.getValue();
    assertEquals(artistaDTO.nome(), artistaCapturado.nome());
    assertEquals(artistaDTO.biografia(), artistaCapturado.biografia());
    assertEquals(artistaDTO.paisOrigem(), artistaCapturado.paisOrigem());
    assertEquals(artistaDTO.genero(), artistaCapturado.genero());
    assertEquals(artistaDTO.foto(), artistaCapturado.foto());
  }

  @Test
  void testAtualizarArtista() throws Exception {
    UUID idArtista = UUID.randomUUID();
    ArtistaDTO artistaDTO = new ArtistaDTO("Artista Atualizado", new byte[0], "Nova Biografia",
        "EUA", GeneroMusical.POP);

    ResponseEntity<String> resposta = controlador.atualizarArtista(idArtista, artistaDTO);

    assertEquals(HttpStatus.OK, resposta.getStatusCode());
    assertEquals("Artista atualizado.", resposta.getBody());

    ArgumentCaptor<ArtistaDTO> artistaCaptor = ArgumentCaptor.forClass(ArtistaDTO.class);
    ArgumentCaptor<UUID> idCaptor = ArgumentCaptor.forClass(UUID.class);
    verify(artistaServico, times(1)).atualizarArtista(idCaptor.capture(), artistaCaptor.capture());

    assertEquals(idArtista, idCaptor.getValue());
    assertEquals(artistaDTO.nome(), artistaCaptor.getValue().nome());
    assertEquals(artistaDTO.biografia(), artistaCaptor.getValue().biografia());
    assertEquals(artistaDTO.paisOrigem(), artistaCaptor.getValue().paisOrigem());
    assertEquals(artistaDTO.genero(), artistaCaptor.getValue().genero());
    assertEquals(artistaDTO.foto(), artistaCaptor.getValue().foto());
  }

  @Test
  void testDeletarArtista() {
    UUID idArtista = UUID.randomUUID();

    ResponseEntity<String> resposta = controlador.deletarArtista(idArtista);

    assertEquals(HttpStatus.OK, resposta.getStatusCode());
    assertEquals("Artista excluido.", resposta.getBody());

    verify(artistaServico, times(1)).deletarArtista(idArtista);
  }
}
