package com.harmonify.backspring.api.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.harmonify.backspring.api.contracts.requests.FiltroMusicaDTO;
import com.harmonify.backspring.api.contracts.requests.MusicaDTO;
import com.harmonify.backspring.api.contracts.responses.RespMusicaDTO;
import com.harmonify.backspring.domain.services.MusicaServico;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class MusicaControladorTest {

  @Mock
  private MusicaServico musicaServico;

  @InjectMocks
  private MusicaControlador musicaControlador;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testListarMusicas() {
    FiltroMusicaDTO filtroDTO = new FiltroMusicaDTO("Queen", "Rock");
    RespMusicaDTO musicaDTO = new RespMusicaDTO("Bohemian Rhapsody", "Queen", "Rock", "5:55", null,
        null);
    List<RespMusicaDTO> musicas = Arrays.asList(musicaDTO);

    when(musicaServico.listarMusicas(any(FiltroMusicaDTO.class))).thenReturn(musicas);

    ResponseEntity<List<RespMusicaDTO>> responseEntity = musicaControlador.listarMusicas(filtroDTO);

    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals(musicas, responseEntity.getBody());
    verify(musicaServico, times(1)).listarMusicas(filtroDTO);
  }

  @Test
  void testDetalharMusica() {
    UUID id = UUID.randomUUID();
    RespMusicaDTO musicaDTO = new RespMusicaDTO("Bohemian Rhapsody", "Queen", "Rock", "5:55", null,
        null);

    when(musicaServico.encontrarMusica(id)).thenReturn(musicaDTO);

    ResponseEntity<RespMusicaDTO> responseEntity = musicaControlador.detalharMusica(id);

    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals(musicaDTO, responseEntity.getBody());
    verify(musicaServico, times(1)).encontrarMusica(id);
  }

  @Test
  void testSalvarMusica() {
    MusicaDTO musicaDTO = new MusicaDTO("Bohemian Rhapsody", UUID.randomUUID(), null, "5:55", null,
        null);

    ResponseEntity<String> responseEntity = musicaControlador.salvarMusica(musicaDTO);

    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals("Música salva.", responseEntity.getBody());
    verify(musicaServico, times(1)).salvarMusica(musicaDTO);
  }

  @Test
  void testEditarMusica() {
    UUID id = UUID.randomUUID();
    MusicaDTO musicaDTO = new MusicaDTO("Bohemian Rhapsody", UUID.randomUUID(), null, "5:55", null,
        null);

    ResponseEntity<String> responseEntity = musicaControlador.editarMusica(id, musicaDTO);

    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals("Música atualizada.", responseEntity.getBody());
    verify(musicaServico, times(1)).editarMusica(id, musicaDTO);
  }

  @Test
  void testDeletarMusica() {
    UUID id = UUID.randomUUID();

    ResponseEntity<String> responseEntity = musicaControlador.deletarMusica(id);

    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals("Música apagada.", responseEntity.getBody());
    verify(musicaServico, times(1)).deletarMusica(id);
  }
}
