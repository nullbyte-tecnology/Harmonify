package com.harmonify.backspring.infrastructure.repositories;

import com.harmonify.backspring.domain.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepositorio extends JpaRepository<Usuario, UUID> {
  Optional<Usuario> findByLogin(String login);
}
