package com.harmonify.backspring.api.contracts.requests;

import com.harmonify.backspring.domain.models.Musica;
import com.harmonify.backspring.domain.models.enums.GeneroMusical;
import java.sql.Date;
import java.util.UUID;

public record MusicaDTO(String nome, UUID idArtista, GeneroMusical generoMusical, String duracao,
                        Date lancamento, byte[] arquivo) {

  public MusicaDTO(Musica musica) {
    this(musica.getNome(), musica.getArtista().getId(), musica.getGenero(), musica.getDuracaoSegundos(),
        musica.getLancamento(), musica.getFoto());
  }
}
