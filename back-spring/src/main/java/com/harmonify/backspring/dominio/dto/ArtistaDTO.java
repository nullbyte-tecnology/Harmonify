package com.harmonify.backspring.dominio.dto;

import com.harmonify.backspring.dominio.Artista;

public record ArtistaDTO (String nome, String genero, String nacionalidade, String biografia, String paisOrigem) {

    public ArtistaDTO(Artista artista){
        this(artista.getNome(), artista.getGenero(), artista.getNacionalidade(), artista.getNacionalidade(), artista.getPaisOrigem());
    }
}
