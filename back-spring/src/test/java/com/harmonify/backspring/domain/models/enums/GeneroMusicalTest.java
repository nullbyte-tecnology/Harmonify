package com.harmonify.backspring.domain.models.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GeneroMusicalTest {

  @Test
  void testValoresEnum() {
    assertEquals("Country", GeneroMusical.COUNTRY.getValor());
    assertEquals("Dance", GeneroMusical.DANCE.getValor());
    assertEquals("Eletrônica", GeneroMusical.ELETRONICA.getValor());
    assertEquals("Forró", GeneroMusical.FORRO.getValor());
    assertEquals("Hip Hop", GeneroMusical.HIP_HOP.getValor());
    assertEquals("Instrumental", GeneroMusical.INSTRUMENTAL.getValor());
    assertEquals("Jazz", GeneroMusical.JAZZ.getValor());
    assertEquals("Pop", GeneroMusical.POP.getValor());
    assertEquals("Rock", GeneroMusical.ROCK.getValor());
    assertEquals("R&B", GeneroMusical.R_B.getValor());
  }
}
