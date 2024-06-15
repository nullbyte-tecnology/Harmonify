package com.harmonify.backspring.api.controllers;

import com.harmonify.backspring.api.contracts.requests.FiltroMusicaDTO;
import com.harmonify.backspring.api.contracts.requests.MusicaDTO;
import com.harmonify.backspring.api.contracts.responses.RespMusicaDTO;
import com.harmonify.backspring.domain.services.MusicaServico;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/musicas")
public class MusicaControlador {

  private final MusicaServico musicaServico;

  public MusicaControlador(MusicaServico musicaServico) {
    this.musicaServico = musicaServico;
  }

  @GetMapping
  public ResponseEntity<List<RespMusicaDTO>> listarMusicas(FiltroMusicaDTO filtroDTO) {
    List<RespMusicaDTO> musicas = musicaServico.listarMusicas(filtroDTO);

    return ResponseEntity.status(HttpStatus.OK).body(musicas);
  }

  @GetMapping("/{id}")
  public ResponseEntity<RespMusicaDTO> detalharMusica(@PathVariable UUID id) {
    RespMusicaDTO musica = musicaServico.encontrarMusica(id);

    return ResponseEntity.status(HttpStatus.OK).body(musica);
  }

  @PostMapping
  public ResponseEntity<String> salvarMusica(@RequestBody MusicaDTO musicaDTO) {
    musicaServico.salvarMusica(musicaDTO);

    return ResponseEntity.status(HttpStatus.OK).body("Música salva.");
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> editarMusica(@PathVariable UUID id, @RequestBody MusicaDTO musicaDTO) {
    musicaServico.editarMusica(id, musicaDTO);

    return ResponseEntity.status(HttpStatus.OK).body("Música atualizada.");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deletarMusica(@PathVariable UUID id) {
    musicaServico.deletarMusica(id);

    return ResponseEntity.status(HttpStatus.OK).body("Música apagada.");
  }

}
