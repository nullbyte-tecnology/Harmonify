package com.harmonify.backspring.api.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.harmonify.backspring.api.contracts.requests.MusicaDTO;
import com.harmonify.backspring.api.contracts.responses.RespMusicaDTO;
import com.harmonify.backspring.domain.services.MusicaServico;
import java.sql.Date;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class MusicaControladorTest {

  @Mock
  private MusicaServico musicaServico;

  @InjectMocks
  private MusicaControlador controlador;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testListarMusicas() {
    List<RespMusicaDTO> musicasMock = List.of(
        new RespMusicaDTO("Música 1", "Artista 1", "Rock", "3:30",
            new Date(System.currentTimeMillis()), "base64encoded"),
        new RespMusicaDTO("Música 2", "Artista 2", "Pop", "4:00",
            new Date(System.currentTimeMillis()), "base64encoded")
    );

    when(musicaServico.listarMusicas()).thenReturn(musicasMock);

    List<RespMusicaDTO> resultado = controlador.listarMusicas();

    assertEquals(musicasMock.size(), resultado.size());
    assertEquals(musicasMock.get(0).nome(), resultado.get(0).nome());
    assertEquals(musicasMock.get(0).artista(), resultado.get(0).artista());
    assertEquals(musicasMock.get(0).generoMusical(), resultado.get(0).generoMusical());
    assertEquals(musicasMock.get(0).duracao(), resultado.get(0).duracao());
    assertEquals(musicasMock.get(0).dataLancamento(), resultado.get(0).dataLancamento());
    assertEquals(musicasMock.get(0).foto(), resultado.get(0).foto());

    assertEquals(musicasMock.get(1).nome(), resultado.get(1).nome());
    assertEquals(musicasMock.get(1).artista(), resultado.get(1).artista());
    assertEquals(musicasMock.get(1).generoMusical(), resultado.get(1).generoMusical());
    assertEquals(musicasMock.get(1).duracao(), resultado.get(1).duracao());
    assertEquals(musicasMock.get(1).dataLancamento(), resultado.get(1).dataLancamento());
    assertEquals(musicasMock.get(1).foto(), resultado.get(1).foto());

    verify(musicaServico, times(1)).listarMusicas();
  }

  @Test
  void testSalvarMusica() {
    MusicaDTO musicaDTO = new MusicaDTO("Música de Teste", UUID.randomUUID(), "Rock",
        "3:30", new Date(System.currentTimeMillis()), new byte[0]);

    controlador.salvarMusica(musicaDTO);

    ArgumentCaptor<MusicaDTO> musicaCaptor = ArgumentCaptor.forClass(MusicaDTO.class);
    verify(musicaServico, times(1)).salvarMusica(musicaCaptor.capture());

    MusicaDTO musicaCapturada = musicaCaptor.getValue();
    assertEquals(musicaDTO.nome(), musicaCapturada.nome());
    assertEquals(musicaDTO.generoMusical(), musicaCapturada.generoMusical());
    assertEquals(musicaDTO.duracao(), musicaCapturada.duracao());
    assertEquals(musicaDTO.lancamento(), musicaCapturada.lancamento());
    assertEquals(musicaDTO.arquivo(), musicaCapturada.arquivo());
  }
}
