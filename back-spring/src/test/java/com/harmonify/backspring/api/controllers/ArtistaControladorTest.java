package com.harmonify.backspring.api.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.harmonify.backspring.api.contracts.requests.ArtistaDTO;
import com.harmonify.backspring.domain.services.ArtistaServico;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ArtistaControlador.class)
class ArtistaControladorTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ArtistaServico artistaServicoMock;

  private ObjectMapper objectMapper;

  @BeforeEach
  public void setUp() {
    objectMapper = new ObjectMapper();
  }

  @Test
  void testListarArtistas() throws Exception {
    List<ArtistaDTO> artistasMock = new ArrayList<>();
    artistasMock.add(
        new ArtistaDTO("Artista 1", "Genero 1", "Nacionalidade 1", "Biografia", "Pais 1"));
    when(artistaServicoMock.listarArtistas()).thenReturn(artistasMock);

    mockMvc.perform(get("/api/artistas"))
        .andExpect(status().isOk())
        .andExpect(content().json(objectMapper.writeValueAsString(artistasMock)));
  }

  @Test
  void testSalvarArtista() throws Exception {
    ArtistaDTO artistaDTO = new ArtistaDTO("Artista 1", "Genero 1", "Nacionalidade 1",
        "Biografia 1", "Pais 1");
    doNothing().when(artistaServicoMock).salvarArtista(any(ArtistaDTO.class));

    mockMvc.perform(post("/api/artistas")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(artistaDTO)))
        .andExpect(status().isOk());

    verify(artistaServicoMock, times(1)).salvarArtista(artistaDTO);
  }

  @Test
  void testAtualizarArtista() throws Exception {
    Long id = 1L;
    ArtistaDTO artistaDTO = new ArtistaDTO("Artista 1", "Genero 1", "Nacionalidade 1", "Biografia",
        "Pais 1");
    doNothing().when(artistaServicoMock)
        .atualizarArtista(anyLong(), any(ArtistaDTO.class));  // usa any() para mockar argumentos

    mockMvc.perform(put("/api/artistas/{id}", id)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(artistaDTO)))
        .andExpect(status().isOk());

    verify(artistaServicoMock, times(1)).atualizarArtista(id, artistaDTO);
  }

  @Test
  void testListarArtistasPorGenero() throws Exception {
    String genero = "Genero 1";
    List<ArtistaDTO> artistasMock = new ArrayList<>();
    artistasMock.add(new ArtistaDTO("Artista 1", genero, "Nacionalidade 1", "Biografia", "Pais 1"));
    when(artistaServicoMock.listarArtistasPorGenero(genero)).thenReturn(artistasMock);

    mockMvc.perform(get("/api/artistas/genero/{genero}", genero))
        .andExpect(status().isOk())
        .andExpect(content().json(objectMapper.writeValueAsString(artistasMock)));

    verify(artistaServicoMock, times(1)).listarArtistasPorGenero(genero);
  }
}
