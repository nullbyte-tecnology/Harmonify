package com.harmonify.backspring.domain.models;

import com.harmonify.backspring.api.contracts.requests.ArtistaDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "artista")
public class Artista {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_musica")
  private UUID id;
  @Column(length = 50, nullable = false)
  private String nome;
  @Column(length = 50, nullable = false)
  private String nacionalidade;
  @Column(columnDefinition = "TEXT", nullable = false)
  private String biografia;
  @Column(length = 50, nullable = false)
  private String paisOrigem;
  @Column(length = 50, nullable = false)
  private String genero;

  public Artista(ArtistaDTO artistaDTO) {
    this.nome = artistaDTO.nome();
    this.nacionalidade = artistaDTO.nacionalidade();
    this.biografia = artistaDTO.biografia();
    this.paisOrigem = artistaDTO.paisOrigem();
    this.genero = artistaDTO.genero();
  }

}
