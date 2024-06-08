package com.harmonify.backspring.domain.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

  private static final int DURACAO_TOKEN_HORAS = 2;
  private final String secretKey;
  private final String tokenIssuer;

  public TokenService(
      @Value("${api.security.token.secret}") String secretKey,
      @Value("${api.security.token.issuer}") String tokenIssuer) {

    this.secretKey = secretKey;
    this.tokenIssuer = tokenIssuer;
  }

  public String gerarToken(UserDetails usuario) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(this.secretKey);

      return JWT.create()
          .withIssuer(this.tokenIssuer)
          .withSubject(usuario.getUsername())
          .withExpiresAt(gerarExpiracao())
          .sign(algorithm);
    } catch (JWTCreationException ex) {
      throw new RuntimeException("Erro ao gerar token de autenticação");
    }
  }

  private Instant gerarExpiracao() {
    return LocalDateTime.now().plusHours(DURACAO_TOKEN_HORAS).toInstant(ZoneOffset.of("-03:00"));
  }
}
