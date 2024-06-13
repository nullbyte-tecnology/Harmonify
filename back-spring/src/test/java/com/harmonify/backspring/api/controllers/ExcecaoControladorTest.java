package com.harmonify.backspring.api.controllers;

import com.harmonify.backspring.api.contracts.responses.ErroDTO;
import com.harmonify.backspring.domain.exception.RecursoNaoEncontradoExcecao;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExcecaoControladorTest {

  private final ExcecaoControlador controlador = new ExcecaoControlador();

  @Test
  void testRecursoNaoEncontradoExcecao() {
    String mensagem = "Recurso não encontrado.";
    RecursoNaoEncontradoExcecao ex = new RecursoNaoEncontradoExcecao(mensagem);

    ResponseEntity<ErroDTO> resposta = controlador.recursoNaoEncontradoExcecao(ex);

    assertEquals(HttpStatus.NOT_FOUND, resposta.getStatusCode());
    assertEquals(mensagem, resposta.getBody().erro());
  }
}
