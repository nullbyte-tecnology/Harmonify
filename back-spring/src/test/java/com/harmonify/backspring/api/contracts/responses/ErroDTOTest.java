package com.harmonify.backspring.api.contracts.responses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErroDTOTest {

  @Test
  void testConstrutorEGetters() {
    String mensagem = "Erro ocorrido.";
    ErroDTO erroDTO = new ErroDTO(mensagem);

    assertEquals(mensagem, erroDTO.erro());
  }

  @Test
  void testEquals() {
    ErroDTO erroDTO1 = new ErroDTO("Erro1");
    ErroDTO erroDTO2 = new ErroDTO("Erro1");
    ErroDTO erroDTO3 = new ErroDTO("Erro2");

    assertEquals(erroDTO1, erroDTO2);
    assertNotEquals(erroDTO1, erroDTO3);
  }

  @Test
  void testHashCode() {
    ErroDTO erroDTO1 = new ErroDTO("Erro1");
    ErroDTO erroDTO2 = new ErroDTO("Erro1");
    ErroDTO erroDTO3 = new ErroDTO("Erro2");

    assertEquals(erroDTO1.hashCode(), erroDTO2.hashCode());
    assertNotEquals(erroDTO1.hashCode(), erroDTO3.hashCode());
  }

  @Test
  void testToString() {
    String mensagem = "Erro ocorrido.";
    ErroDTO erroDTO = new ErroDTO(mensagem);

    assertEquals("ErroDTO[erro=Erro ocorrido.]", erroDTO.toString());
  }
}
