package com.harmonify.backspring.api.controllers;

import com.harmonify.backspring.api.contracts.requests.ArtistaDTO;
import com.harmonify.backspring.domain.services.ArtistaServico;
import java.util.List;
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
  public ResponseEntity<List<ArtistaDTO>> listarArtistas(@RequestParam(required = false) String genero) {
    List<ArtistaDTO> artistas = artistaServico.listarArtistas(genero);

    return ResponseEntity.status(HttpStatus.OK).body(artistas);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ArtistaDTO> detalharArtista(@PathVariable UUID id) {
    ArtistaDTO artista = artistaServico.encontrarArtista(id);

    return ResponseEntity.status(HttpStatus.OK).body(artista);
  }

  @PostMapping
  public ResponseEntity<String> salvarArtista(@RequestBody ArtistaDTO artistaDTO) {
    artistaServico.salvarArtista(artistaDTO);

    return ResponseEntity.status(HttpStatus.OK).body("Artista salvo.");
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> atualizarArtista(@PathVariable UUID id, @RequestBody ArtistaDTO artistaDTO) {
    artistaServico.atualizarArtista(id, artistaDTO);

    return ResponseEntity.status(HttpStatus.OK).body("Artista atualizado.");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deletarArtista(@PathVariable UUID id) {
    artistaServico.deletarArtista(id);

    return ResponseEntity.status(HttpStatus.OK).body("Artista excluido.");
  }
}
