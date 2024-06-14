package com.harmonify.backspring.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.harmonify.backspring.api.contracts.requests.MusicaDTO;
import com.harmonify.backspring.api.contracts.responses.RespMusicaDTO;
import com.harmonify.backspring.domain.models.Musica;
import com.harmonify.backspring.infrastructure.repositories.MusicaRepositorio;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class MusicaServicoTest {

  @Mock
  private MusicaRepositorio musicaRepositorio;

  @InjectMocks
  private MusicaServico musicaServico;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testListarMusicas() {

    MusicaDTO musicaDTO1 = new MusicaDTO("Musica 1", "Artista 1", "Rock", "3:00",
        Date.valueOf("2022-01-01"), new byte[0]);
    MusicaDTO musicaDTO2 = new MusicaDTO("Musica 2", "Artista 2", "Pop", "4:00",
        Date.valueOf("2022-01-01"), new byte[0]);

    Musica musica1 = new Musica(musicaDTO1);
    Musica musica2 = new Musica(musicaDTO2);

    List<Musica> listaMusicas = Arrays.asList(musica1, musica2);

    when(musicaRepositorio.findAll()).thenReturn(listaMusicas);

    List<RespMusicaDTO> resposta = musicaServico.listarMusicas();

    assertNotNull(resposta);
    assertEquals(2, resposta.size());
    assertEquals("Musica 1", resposta.get(0).nome());
    assertEquals("Artista 1", resposta.get(0).artista());
    assertEquals("Musica 2", resposta.get(1).nome());
    assertEquals("Artista 2", resposta.get(1).artista());

    verify(musicaRepositorio, times(1)).findAll();
  }


  @Test
  void testSalvarMusicaValida() {
    MusicaDTO musicaDTO = new MusicaDTO("Musica 1", "Artista 1", "Rock", "3:00",
        Date.valueOf("2022-01-01"), new byte[0]);

    musicaServico.salvarMusica(musicaDTO);

    verify(musicaRepositorio, times(1)).save(any(Musica.class));
  }

  @Test
  void testSalvarMusicaInvalida() {
    MusicaDTO musicaDTO = new MusicaDTO("Musica 1", "Artista 1", "Rap", "3:00",
        Date.valueOf("2022-01-01"), new byte[0]);

    musicaServico.salvarMusica(musicaDTO);

    verify(musicaRepositorio, never()).save(any(Musica.class));
  }

  @Test
  void testValidarGeneroMusicalValido() {
    MusicaDTO musicaDTO = new MusicaDTO("Musica 1", "Artista 1", "Rock", "3:00",
        Date.valueOf("2022-01-01"), new byte[0]);

    boolean resultado = musicaServico.validarMusica(musicaDTO);

    assertTrue(resultado);
  }

  @Test
  void testValidarGeneroMusicalInvalido() {
    MusicaDTO musicaDTO = new MusicaDTO("Musica 1", "Artista 1", "Rap", "3:00",
        Date.valueOf("2022-01-01"), new byte[0]);

    boolean resultado = musicaServico.validarMusica(musicaDTO);

    assertFalse(resultado);
  }
}