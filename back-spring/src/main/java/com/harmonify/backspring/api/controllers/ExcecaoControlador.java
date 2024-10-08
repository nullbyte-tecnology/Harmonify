package com.harmonify.backspring.api.controllers;

import com.harmonify.backspring.api.contracts.responses.ErroDTO;
import com.harmonify.backspring.domain.exception.RecursoNaoEncontradoExcecao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExcecaoControlador {

  @ExceptionHandler(RecursoNaoEncontradoExcecao.class)
  public ResponseEntity<ErroDTO> recursoNaoEncontradoExcecao(RecursoNaoEncontradoExcecao ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErroDTO(ex.getMessage()));
  }

}
