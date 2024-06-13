package com.harmonify.backspring.api.controllers;

import com.harmonify.backspring.api.contracts.requests.ArtistaDTO;
import com.harmonify.backspring.domain.models.enums.GeneroMusical;
import com.harmonify.backspring.domain.services.ArtistaServico;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ArtistaControlador.class)
class ArtistaControladorTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ArtistaServico artistaServico;

  @Test
  void testListarArtistas() throws Exception {
    List<ArtistaDTO> artistas = Arrays.asList(
        new ArtistaDTO("Artista1", new byte[]{1, 2, 3}, "Biografia1", "Brasil", GeneroMusical.ROCK),
        new ArtistaDTO("Artista2", new byte[]{4, 5, 6}, "Biografia2", "Argentina", GeneroMusical.JAZZ)
    );

    when(artistaServico.listarArtistas(anyString())).thenReturn(artistas);

    mockMvc.perform(get("/api/artista")
            .param("genero", "ROCK")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].nome").value("Artista1"))
        .andExpect(jsonPath("$[1].nome").value("Artista2"));
  }

  @Test
  void testDetalharArtista() throws Exception {
    UUID id = UUID.randomUUID();
    ArtistaDTO artista = new ArtistaDTO("Artista", new byte[]{1, 2, 3}, "Biografia", "Brasil", GeneroMusical.ROCK);

    when(artistaServico.encontrarArtista(id)).thenReturn(artista);

    mockMvc.perform(get("/api/artista/{id}", id)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.nome").value("Artista"));
  }

  @Test
  void testSalvarArtista() throws Exception {
    ArtistaDTO artista = new ArtistaDTO("Artista", new byte[]{1, 2, 3}, "Biografia", "Brasil", GeneroMusical.ROCK);

    doNothing().when(artistaServico).salvarArtista(any(ArtistaDTO.class));

    mockMvc.perform(post("/api/artista")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"nome\":\"Artista\",\"foto\":\"AQID\",\"biografia\":\"Biografia\",\"paisOrigem\":\"Brasil\",\"genero\":\"ROCK\"}"))
        .andExpect(status().isOk())
        .andExpect(content().string("Artista salvo."));
  }

  @Test
  void testAtualizarArtista() throws Exception {
    UUID id = UUID.randomUUID();
    ArtistaDTO artista = new ArtistaDTO("Artista", new byte[]{1, 2, 3}, "Biografia", "Brasil", GeneroMusical.ROCK);

    doNothing().when(artistaServico).atualizarArtista(any(UUID.class), any(ArtistaDTO.class));

    mockMvc.perform(put("/api/artista/{id}", id)
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"nome\":\"Artista\",\"foto\":\"AQID\",\"biografia\":\"Biografia\",\"paisOrigem\":\"Brasil\",\"genero\":\"ROCK\"}"))
        .andExpect(status().isOk())
        .andExpect(content().string("Artista atualizado."));
  }

  @Test
  void testDeletarArtista() throws Exception {
    UUID id = UUID.randomUUID();

    doNothing().when(artistaServico).deletarArtista(id);

    mockMvc.perform(delete("/api/artista/{id}", id)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().string("Artista excluido."));
  }
}
