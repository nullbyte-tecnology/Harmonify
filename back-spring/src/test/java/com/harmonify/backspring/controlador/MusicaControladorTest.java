package com.harmonify.backspring.controlador;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.harmonify.backspring.dominio.dto.MusicaDTO;
import com.harmonify.backspring.servico.MusicaServico;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
class MusicaControladorTest {

  private MockMvc mockMvc;

  @Mock
  private MusicaServico musicaServico;

  @BeforeEach
  public void setUp() {
    MusicaControlador musicaControlador = new MusicaControlador(musicaServico);
    mockMvc = MockMvcBuilders.standaloneSetup(musicaControlador).build();
  }

  @Test
  void testListarMusicas() throws Exception {
    when(musicaServico.listarMusicas()).thenReturn(Collections.emptyList());

    mockMvc.perform(MockMvcRequestBuilders.get("/api/musicas")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.content().json("[]"));
  }

  @Test
  void testSalvarMusica() throws Exception {
    MusicaDTO musicaDTO = new MusicaDTO("Nome da Música", "Artista", "Rock", "03:30", null, null);
    String json = """
        {
          "titulo": "Musica 1",
          "artista": "Artista 1",
          "generoMusical": "Rock",
          "duracao": "3:00",
          "dataLancamento": "2022-01-01",
          "arquivo": ""
        }""";

    mockMvc.perform(MockMvcRequestBuilders.post("/api/musicas")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
        .andExpect(status().isOk());
  }
}
