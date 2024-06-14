package com.harmonify.backspring.infrastructure.repositories;

import com.harmonify.backspring.domain.models.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MusicaRepositorio extends JpaRepository<Musica, Long> {

    Optional<Musica> findByNomeAndArtistaId(String nome, UUID idArtista);
}
