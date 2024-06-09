package com.harmonify.backspring.api.controllers;

import com.harmonify.backspring.api.contracts.requests.UsuarioDTO;
import com.harmonify.backspring.api.contracts.responses.TokenDTO;
import com.harmonify.backspring.domain.services.AutenticacaoServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AutenticacaoControlador {
  private final AutenticacaoServico autenticacaoServico;

  @PostMapping("/cadastro")
  public ResponseEntity<TokenDTO> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
    TokenDTO tokenDTO = this.autenticacaoServico.registrarUsuario(usuarioDTO);

    return ResponseEntity.status(HttpStatus.OK).body(tokenDTO);
  }
}
