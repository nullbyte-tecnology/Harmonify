package com.harmonify.backspring.infrastructure.repositories;

import com.harmonify.backspring.domain.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AlbumRepositorio extends JpaRepository<Album, UUID> {
    List<Album> findByArtistaId(UUID artistaId);
}
