package com.harmonify.backspring.api.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.harmonify.backspring.api.contracts.responses.ErroDTO;
import com.harmonify.backspring.domain.exception.DadosInvalidosExcecao;
import com.harmonify.backspring.domain.exception.RecursoNaoEncontradoExcecao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class ExcecaoControladorTest {

  private ExcecaoControlador excecaoControlador;

  @BeforeEach
  public void setup() {
    excecaoControlador = new ExcecaoControlador();
  }

  @Test
  void testRecursoNaoEncontradoExcecao() {
    RecursoNaoEncontradoExcecao ex = new RecursoNaoEncontradoExcecao("Recurso não encontrado.");

    ResponseEntity<ErroDTO> responseEntity = excecaoControlador.recursoNaoEncontradoExcecao(ex);

    assertNotNull(responseEntity);
    assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    assertNotNull(responseEntity.getBody());
    assertEquals("Recurso não encontrado.", responseEntity.getBody().erro());
  }

  @Test
  void testDadosInvalidosExcecao() {
    DadosInvalidosExcecao ex = new DadosInvalidosExcecao("Dados inválidos.");

    ResponseEntity<ErroDTO> responseEntity = excecaoControlador.dadosInvalidosExcecao(ex);

    assertNotNull(responseEntity);
    assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    assertNotNull(responseEntity.getBody());
    assertEquals("Dados inválidos.", responseEntity.getBody().erro());
  }
}
