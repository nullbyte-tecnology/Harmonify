package com.harmonify.backspring.api.contracts.requests;

import com.harmonify.backspring.domain.models.Musica;
import java.sql.Date;

public record MusicaDTO(String nome, String artista, String generoMusical, String duracao,
                        Date lancamento, byte[] arquivo) {

  public MusicaDTO(Musica musica) {
    this(musica.getNome(), musica.getArtista(), musica.getGenero(), musica.getDuracaoSegundos(),
        musica.getLancamento(), musica.getFoto());
  }
}
