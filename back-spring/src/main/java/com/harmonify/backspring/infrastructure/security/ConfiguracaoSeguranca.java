package com.harmonify.backspring.infrastructure.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class ConfiguracaoSeguranca {
  private final FiltroSeguranca filtroSeguranca;
  private final SenhaEncoderBean senhaEncoderBean;
  private final UserDetailsService userDetailsService;
}
