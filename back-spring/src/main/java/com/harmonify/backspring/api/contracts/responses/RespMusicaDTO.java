package com.harmonify.backspring.api.contracts.responses;

import com.harmonify.backspring.domain.models.Musica;
import java.sql.Date;
import org.apache.tomcat.util.codec.binary.Base64;

public record RespMusicaDTO(String nome, String artista, String genero, String duracao,
                            Date dataLancamento, String foto) {
  public RespMusicaDTO(Musica musica) {
    this(musica.getNome(), musica.getArtista().getNome(), musica.getGenero().getValor(), musica.getDuracao(),
        musica.getLancamento(), Base64.encodeBase64String(musica.getFoto()));
  }
}
