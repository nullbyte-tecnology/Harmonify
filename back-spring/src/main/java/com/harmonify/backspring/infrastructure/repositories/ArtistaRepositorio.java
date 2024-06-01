package com.harmonify.backspring.infrastructure.repositories;

import com.harmonify.backspring.domain.models.Artista;
import jakarta.annotation.Nullable;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArtistaRepositorio extends JpaRepository<Artista, UUID>,
    JpaSpecificationExecutor<Artista> {

  List<Artista> findAll(@Nullable Specification<Artista> spec);

}
