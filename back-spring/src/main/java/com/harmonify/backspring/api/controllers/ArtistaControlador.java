package com.harmonify.backspring.api.controllers;

import com.harmonify.backspring.api.contracts.requests.ArtistaDTO;
import com.harmonify.backspring.domain.services.ArtistaServico;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/artistas")
public class ArtistaControlador {

  private final ArtistaServico artistaServico;

  public ArtistaControlador(ArtistaServico artistaServico) {
    this.artistaServico = artistaServico;
  }

  @GetMapping
  public List<ArtistaDTO> listarArtistas() {
    return artistaServico.listarArtistas();
  }

  @PostMapping
  public void salvarArtista(@RequestBody ArtistaDTO artistaDTO) {
    artistaServico.salvarArtista(artistaDTO);
  }

  @PutMapping("/{id}")
  public void atualizarArtista(@PathVariable Long id, @RequestBody ArtistaDTO artistaDTO) {
    artistaServico.atualizarArtista(id, artistaDTO);
  }

  @GetMapping("/genero/{genero}")
  public List<ArtistaDTO> listarArtistasPorGenero(@PathVariable String genero) {
    return artistaServico.listarArtistasPorGenero(genero);
  }

}
