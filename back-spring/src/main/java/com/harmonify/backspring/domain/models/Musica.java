package com.harmonify.backspring.domain.models;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "Musica")
public class Musica {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_musica")
  private Long id;

  @Column(length = 50, nullable = false)
  private String nome;

  @ManyToOne
  @JoinColumn(name = "id_artista", nullable = false)
  private Artista artista;

  @Enumerated(EnumType.STRING)
  @Column(length = 25, nullable = false)
  private GeneroMusical genero;

  @Column(name = "duracao_segundos", length = 5, nullable = false)
  private String duracaoSegundos;

  @Column(name = "data_de_lancamento", nullable = false)
  private Date lancamento;

  private byte[] foto;

  public Musica(MusicaDTO musicaDTO, Artista artista) {
    this.nome = musicaDTO.nome();
    this.artista = artista;
    this.genero = musicaDTO.generoMusical();
    this.duracaoSegundos = musicaDTO.duracao();
    this.lancamento = musicaDTO.lancamento();
    this.foto = musicaDTO.arquivo();
  }
}
