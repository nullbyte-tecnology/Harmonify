package com.harmonify.backspring.domain.models.enums;

import lombok.Getter;

@Getter
public enum GeneroMusical {
  COUNTRY("Country"),
  DANCE("Dance"),
  ELECTROPOP("Electropop"),
  ELETRONICA("Eletrônica"),
  FORRO("Forró"),
  HIP_HOP("Hip Hop"),
  INSTRUMENTAL("Instrumental"),
  JAZZ("Jazz"),
  POP("Pop"),
  ROCK("Rock"),
  ROCK_ALT("Rock Alternativo"),
  R_B("R&B"),
  SOUL("Soul");

  private final String valor;

  GeneroMusical(String valor) {
    this.valor = valor;
  }

}
