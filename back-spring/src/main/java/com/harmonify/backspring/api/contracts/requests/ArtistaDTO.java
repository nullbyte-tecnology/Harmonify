package com.harmonify.backspring.api.contracts.requests;

import com.harmonify.backspring.domain.models.Artista;

public record ArtistaDTO(String nome, String genero, String nacionalidade, String biografia,
                         String paisOrigem) {

  public ArtistaDTO(Artista artista) {
    this(artista.getNome(), artista.getGenero(), artista.getBiografia(),
        artista.getNacionalidade(), artista.getPaisOrigem());
  }
}
