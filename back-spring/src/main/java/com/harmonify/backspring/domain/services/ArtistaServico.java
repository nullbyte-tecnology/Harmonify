package com.harmonify.backspring.domain.services;

import com.harmonify.backspring.api.contracts.requests.ArtistaDTO;
import com.harmonify.backspring.domain.models.Artista;
import com.harmonify.backspring.infrastructure.repositories.ArtistaRepositorio;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ArtistaServico {

  private final ArtistaRepositorio artistaRepositorio;

  public List<ArtistaDTO> listarArtistas() {
    List<Artista> artistas = artistaRepositorio.findAll();
    return artistas.stream().map(ArtistaDTO::new).toList();
  }

  public void salvarArtista(ArtistaDTO artistaDTO) {
    Artista artista = new Artista(artistaDTO);
    artistaRepositorio.save(artista);
  }

  public void atualizarArtista(Long id, ArtistaDTO artistaDTO) {
    Artista artista = artistaRepositorio.findById(id)
        .orElseThrow(() -> new RuntimeException("Artista não encontrado"));

    artista.setNome(artistaDTO.nome());
    artista.setNacionalidade(artistaDTO.nacionalidade());
    artista.setBiografia(artistaDTO.biografia());
    artista.setPaisOrigem(artistaDTO.paisOrigem());

    artistaRepositorio.save(artista);
  }

  public List<ArtistaDTO> listarArtistasPorGenero(String genero) {
    List<Artista> artistas = artistaRepositorio.findAllByGenero(genero);
    return artistas.stream().map(ArtistaDTO::new).toList();
  }
}
