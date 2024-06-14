package com.harmonify.backspring.api.controllers;

import com.harmonify.backspring.api.contracts.requests.FiltroMusicaDTO;
import com.harmonify.backspring.api.contracts.requests.MusicaDTO;
import com.harmonify.backspring.api.contracts.responses.RespMusicaDTO;
import com.harmonify.backspring.domain.models.Musica;
import com.harmonify.backspring.domain.services.MusicaServico;
import com.harmonify.backspring.domain.specifications.MusicaEspecificacao;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

  @PostMapping
  public ResponseEntity<String> salvarMusica(@RequestBody MusicaDTO musicaDTO) {
    musicaServico.salvarMusica(musicaDTO);

    return ResponseEntity.status(HttpStatus.OK).body("Música salva.");
  }
}
