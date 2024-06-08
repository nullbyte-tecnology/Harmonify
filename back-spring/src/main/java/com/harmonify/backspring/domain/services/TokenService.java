package com.harmonify.backspring.domain.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
}
