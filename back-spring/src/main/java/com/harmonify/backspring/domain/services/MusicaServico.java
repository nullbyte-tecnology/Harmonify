package com.harmonify.backspring.domain.services;

import com.harmonify.backspring.api.contracts.requests.MusicaDTO;
import com.harmonify.backspring.api.contracts.responses.RespostaDTO;
import com.harmonify.backspring.domain.models.Musica;
import com.harmonify.backspring.domain.models.enums.GeneroMusical;
import com.harmonify.backspring.infrastructure.repositories.MusicaRepositorio;
import java.util.EnumSet;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MusicaServico {

  private static final EnumSet<GeneroMusical> GENEROS_MUSICAIS_VALIDOS = EnumSet.allOf(
      GeneroMusical.class);
  private final MusicaRepositorio musicaRepositorio;

  public MusicaServico(MusicaRepositorio musicaRepositorio) {
    this.musicaRepositorio = musicaRepositorio;
  }

  public List<RespostaDTO> listarMusicas() {
    List<Musica> musicas = musicaRepositorio.findAll();

    return musicas.stream()
        .map(RespostaDTO::new)
        .toList();
  }

  public void salvarMusica(MusicaDTO musicaDTO) {
    if (Boolean.TRUE.equals(validarMusica(musicaDTO))) {
      Musica musica = new Musica(musicaDTO);
      musicaRepositorio.save(musica);
    }
  }

  public Boolean validarMusica(MusicaDTO musicaDTO) {

    return GENEROS_MUSICAIS_VALIDOS.stream()
        .anyMatch(generoMusical -> generoMusical.getValor().equals(musicaDTO.generoMusical()));
  }
}
