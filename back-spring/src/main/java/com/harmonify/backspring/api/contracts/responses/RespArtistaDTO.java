package com.harmonify.backspring.api.contracts.responses;

import com.harmonify.backspring.domain.models.Artista;

public record RespArtistaDTO(String nome, String genero, byte[] foto, String biografia,
                             String paisOrigem) {

  public RespArtistaDTO(Artista artista) {
    this(artista.getNome(), artista.getGenero().getValor(), artista.getFoto(),
        artista.getBiografia(), artista.getPaisOrigem());
  }

}
