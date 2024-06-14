package com.harmonify.backspring.domain.models;

import com.harmonify.backspring.api.contracts.requests.AlbumDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "album")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_album")
    private UUID id;

    @Column(length = 50, nullable = false)
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_artista", nullable = false)
    private Artista artista;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Musica> musicas;

    @Column(length = 100, nullable = false)
    private String descricao;

    @Column(name = "data_de_lancamento", nullable = false)
    private Date dataLancamento;

    public Album(AlbumDTO albumDTO, Artista artista, List<Musica> musicas) {
        this.nome = albumDTO.nome();
        this.artista = artista;
        this.musicas = musicas;
        this.descricao = albumDTO.descricao();
        this.dataLancamento = albumDTO.dataLancamento();
    }
}
