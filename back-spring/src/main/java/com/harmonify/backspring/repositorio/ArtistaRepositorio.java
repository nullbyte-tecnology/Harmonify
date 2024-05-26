package com.harmonify.backspring.repositorio;

import com.harmonify.backspring.dominio.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistaRepositorio extends JpaRepository<Artista, Long> {
    List<Artista> findByGenero(String genero);
}
