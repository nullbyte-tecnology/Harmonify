package com.harmonify.backspring.infrastructure.repositories;

import com.harmonify.backspring.domain.models.Artista;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepositorio extends JpaRepository<Artista, Long> {

  List<Artista> findByGenero(String genero);
}
