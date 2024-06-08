package com.harmonify.backspring.domain.services;

import com.harmonify.backspring.infrastructure.repositories.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
  private final UsuarioRepositorio usuarioRepositorio;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return this.usuarioRepositorio
        .findByLogin(username)
        .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
  }
}
