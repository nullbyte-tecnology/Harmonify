package com.harmonify.backspring.infrastructure.repositories;

import com.harmonify.backspring.domain.models.Musica;
import jakarta.annotation.Nullable;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MusicaRepositorio extends JpaRepository<Musica, UUID>,
    JpaSpecificationExecutor<Musica> {

  List<Musica> findAll(@Nullable Specification<Musica> spec);
}
