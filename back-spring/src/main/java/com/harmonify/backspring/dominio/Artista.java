package com.harmonify.backspring.dominio;

import com.harmonify.backspring.dominio.dto.ArtistaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "Artista")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_musica")
    private Long id;
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 50, nullable = false)
    private String nacionalidade;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String biografia;
    @Column(length = 50, nullable = false)
    private String paisOrigem;

    public Artista(ArtistaDTO artistaDTO){
        this.nome = artistaDTO.nome();
        this.nacionalidade = artistaDTO.nacionalidade();
        this.biografia = artistaDTO.biografia();
        this.paisOrigem = artistaDTO.paisOrigem();
    }

}
