package com.harmonify.backspring.domain.services;

import com.harmonify.backspring.api.contracts.requests.UsuarioDTO;
import com.harmonify.backspring.api.contracts.responses.TokenDTO;
import com.harmonify.backspring.domain.models.Usuario;
import com.harmonify.backspring.infrastructure.repositories.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutenticacaoServico {
  private final PasswordEncoder passwordEncoder;
  private final UsuarioRepositorio usuarioRepositorio;
  private final TokenServico tokenServico;

  public TokenDTO registrarUsuario(UsuarioDTO usuarioDTO) {
    if (this.usuarioRepositorio.existsByLogin(usuarioDTO.login())) {
      throw new RuntimeException("Usuário já cadastrado");
    }

    Usuario novoUsuario = new Usuario(usuarioDTO);
    novoUsuario.setSenha(this.passwordEncoder.encode(usuarioDTO.senha()));
    Usuario usuarioSalvo = this.usuarioRepositorio.save(novoUsuario);

    String token = this.tokenServico.gerarToken(usuarioSalvo);

    return new TokenDTO(token);
  }
}
