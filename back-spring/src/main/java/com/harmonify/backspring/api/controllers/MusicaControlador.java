package com.harmonify.backspring.api.controllers;

import com.harmonify.backspring.api.contracts.requests.MusicaDTO;
import com.harmonify.backspring.api.contracts.responses.RespostaDTO;
import com.harmonify.backspring.domain.services.MusicaServico;
import java.util.List;
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
  public List<RespostaDTO> listarMusicas() {
    return musicaServico.listarMusicas();
  }

  @PostMapping
  public void salvarMusica(@RequestBody MusicaDTO musicaDTO) {
    musicaServico.salvarMusica(musicaDTO);
  }
}
