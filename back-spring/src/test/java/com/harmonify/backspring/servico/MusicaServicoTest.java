package com.harmonify.backspring.servico;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.harmonify.backspring.dominio.Musica;
import com.harmonify.backspring.dominio.dto.MusicaDTO;
import com.harmonify.backspring.dominio.dto.RespostaDTO;
import com.harmonify.backspring.repositorio.MusicaRepositorio;
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

    MusicaDTO musicaDTO1 = new MusicaDTO("Musica 1", "Artista 1", "Rock", "3:00", Date.valueOf("2022-01-01"), new byte[0]);
    MusicaDTO musicaDTO2 = new MusicaDTO("Musica 2", "Artista 2", "Pop", "4:00", Date.valueOf("2022-01-01"), new byte[0]);

    Musica musica1 = new Musica(musicaDTO1);
    Musica musica2 = new Musica(musicaDTO2);

    List<Musica> listaMusicas = Arrays.asList(musica1, musica2);

    when(musicaRepositorio.findAll()).thenReturn(listaMusicas);

    List<RespostaDTO> resposta = musicaServico.listarMusicas();

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
    MusicaDTO musicaDTO = new MusicaDTO("Musica 1", "Artista 1", "Rock", "3:00", Date.valueOf("2022-01-01"), new byte[0]);

    musicaServico.salvarMusica(musicaDTO);

    verify(musicaRepositorio, times(1)).save(any(Musica.class));
  }

  @Test
  void testSalvarMusicaInvalida() {
    MusicaDTO musicaDTO = new MusicaDTO("Musica 1", "Artista 1", "Rap", "3:00", Date.valueOf("2022-01-01"), new byte[0]);

    musicaServico.salvarMusica(musicaDTO);

    verify(musicaRepositorio, never()).save(any(Musica.class));
  }

  @Test
  void testValidarGeneroMusicalValido() {
    MusicaDTO musicaDTO = new MusicaDTO("Musica 1", "Artista 1", "Rock", "3:00", Date.valueOf("2022-01-01"), new byte[0]);

    boolean resultado = musicaServico.validarMusica(musicaDTO);

    assertTrue(resultado);
  }

  @Test
  void testValidarGeneroMusicalInvalido() {
    MusicaDTO musicaDTO = new MusicaDTO("Musica 1", "Artista 1", "Rap", "3:00", Date.valueOf("2022-01-01"), new byte[0]);

    boolean resultado = musicaServico.validarMusica(musicaDTO);

    assertFalse(resultado);
  }
}