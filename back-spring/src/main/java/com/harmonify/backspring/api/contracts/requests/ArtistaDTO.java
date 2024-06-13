package com.harmonify.backspring.api.contracts.requests;

import com.harmonify.backspring.domain.models.Artista;
import com.harmonify.backspring.domain.models.enums.GeneroMusical;

public record ArtistaDTO(String nome, byte[] foto, String biografia,
                         String paisOrigem, GeneroMusical genero) {

  public ArtistaDTO(Artista artista) {
    this(artista.getNome(), artista.getFoto(),
        artista.getBiografia(), artista.getPaisOrigem(), artista.getGenero());
  }
}
