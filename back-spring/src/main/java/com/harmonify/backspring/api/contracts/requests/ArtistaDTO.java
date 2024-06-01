package com.harmonify.backspring.api.contracts.requests;

import com.harmonify.backspring.domain.models.Artista;
import com.harmonify.backspring.domain.models.enums.GeneroMusical;

public record ArtistaDTO(String nome, GeneroMusical genero, byte[] foto, String biografia,
                         String paisOrigem) {

  public ArtistaDTO(Artista artista) {
    this(artista.getNome(), artista.getGenero(), artista.getFoto(),
        artista.getBiografia(), artista.getPaisOrigem());
  }
}
