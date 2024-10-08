package com.harmonify.backspring.api.contracts.responses;

import com.harmonify.backspring.domain.models.Musica;
import java.sql.Date;
import org.apache.tomcat.util.codec.binary.Base64;

public record RespostaDTO(String nome, String artista, String generoMusical, String duracao,
                          Date dataLancamento, String foto) {

  public RespostaDTO(Musica musica) {
    this(musica.getNome(), musica.getArtista(), musica.getGenero(), musica.getDuracaoSegundos(),
        musica.getLancamento(), Base64.encodeBase64String(musica.getFoto()));
  }
}
