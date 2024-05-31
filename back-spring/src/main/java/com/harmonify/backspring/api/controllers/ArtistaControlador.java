package com.harmonify.backspring.api.controllers;

import com.harmonify.backspring.api.contracts.requests.ArtistaDTO;
import com.harmonify.backspring.domain.services.ArtistaServico;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/artista")
@RequiredArgsConstructor
public class ArtistaControlador {

  private final ArtistaServico artistaServico;

  @GetMapping
  public List<ArtistaDTO> listarArtistas(@RequestParam(required = false) Optional<String> genero) {
    return genero.map(artistaServico::listarArtistasComFiltros)
        .orElseGet(artistaServico::listarArtistas);
  }

  @PostMapping
  public void salvarArtista(@RequestBody ArtistaDTO artistaDTO) {
    artistaServico.salvarArtista(artistaDTO);
  }

  @PutMapping("/{id}")
  public void atualizarArtista(@PathVariable UUID id, @RequestBody ArtistaDTO artistaDTO) {
    artistaServico.atualizarArtista(id, artistaDTO);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deletarArtista(@PathVariable UUID id) {
    boolean resultadoOperacao = artistaServico.deletarArtista(id);

    if(resultadoOperacao) {
      return ResponseEntity.ok("Artista excluido.");
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Artista não encontrado.");
  }

}
