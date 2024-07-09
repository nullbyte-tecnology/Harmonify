package com.harmonify.backspring.api.contracts.requests;

import com.harmonify.backspring.domain.models.Usuario;

public record UsuarioDTO(String login, String senha) {

  public UsuarioDTO(Usuario usuario) {
    this(usuario.getLogin(), usuario.getSenha());
  }
}
