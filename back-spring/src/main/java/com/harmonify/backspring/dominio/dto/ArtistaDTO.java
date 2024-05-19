package com.harmonify.backspring.dominio.dto;

import com.harmonify.backspring.dominio.Artista;

public record ArtistaDTO (String nome, String nacionalidade, String biografia, String paisOrigem) {

    public ArtistaDTO(Artista artista){
        this(artista.getNome(), artista.getNacionalidade(), artista.getNacionalidade(), artista.getPaisOrigem());
    }
}
