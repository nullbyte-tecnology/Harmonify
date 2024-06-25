package com.harmonify.backspring.domain.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.harmonify.backspring.api.contracts.requests.MusicaDTO;
import com.harmonify.backspring.domain.models.enums.GeneroMusical;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Musica")
public class Musica {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_musica")
  private UUID id;

  @Column(length = 50, nullable = false)
  private String nome;

  @ManyToOne
  @JoinColumn(name = "id_artista", nullable = false)
  private Artista artista;

  @Enumerated(EnumType.STRING)
  @Column(length = 25, nullable = false)
  private GeneroMusical genero;

  @Column(name = "duracao", length = 5, nullable = false)
  private String duracao;

  @Column(name = "data_de_lancamento", nullable = false)
  private Date lancamento;

  private byte[] foto;

  @ManyToOne
  @JoinColumn(name = "id_album")
  @JsonBackReference
  private Album album;

  public Musica(MusicaDTO musicaDTO, Artista artista) {
    this.nome = musicaDTO.nome();
    this.artista = artista;
    this.genero = musicaDTO.genero();
    this.duracao = musicaDTO.duracao();
    this.lancamento = musicaDTO.lancamento();
    this.foto = musicaDTO.foto();
  }
}
