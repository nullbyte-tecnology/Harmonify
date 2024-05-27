package com.harmonify.backspring.domain.models.enums;

import lombok.Getter;

@Getter
public enum GeneroMusical {
  COUNTRY("Country"),
  DANCE("Dance"),
  ELETRONICA("Eletrônica"),
  FORRO("Forró"),
  HIP_HOP("Hip Hop"),
  INSTRUMENTAL("Instrumental"),
  JAZZ("Jazz"),
  POP("Pop"),
  ROCK("Rock"),
  R_B("R&B");

  private final String valor;

  GeneroMusical(String valor) {
    this.valor = valor;
  }

}
