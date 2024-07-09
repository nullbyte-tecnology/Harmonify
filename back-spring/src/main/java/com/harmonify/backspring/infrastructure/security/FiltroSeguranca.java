package com.harmonify.backspring.infrastructure.security;

import com.harmonify.backspring.domain.services.TokenServico;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class FiltroSeguranca extends OncePerRequestFilter {
  private final TokenServico tokenServico;
  private final UserDetailsService userDetailsService;

  @Override
  protected void doFilterInternal(
      @NonNull HttpServletRequest request,
      @NonNull HttpServletResponse response,
      @NonNull FilterChain filterChain)
      throws ServletException, IOException {

    String cabecalhoAutenticacao = request.getHeader("Authorization");

    if (cabecalhoAutenticacao == null) {
      filterChain.doFilter(request, response);
      return;
    }

    String token = cabecalhoAutenticacao.substring(7);

    String tokenLogin = this.tokenServico.validarToken(token);

    if (tokenLogin != null) {
      UserDetails usuario = this.userDetailsService.loadUserByUsername(tokenLogin);

      UsernamePasswordAuthenticationToken tokenAutenticacao =
          new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

      SecurityContextHolder.getContext().setAuthentication(tokenAutenticacao);
    }

    filterChain.doFilter(request, response);
  }
}
