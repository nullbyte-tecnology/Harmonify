package com.harmonify.backspring.repositorio;

import com.harmonify.backspring.dominio.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepositorio extends JpaRepository<Artista, Long> {
}
