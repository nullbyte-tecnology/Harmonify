package com.harmonify.backspring.domain.services;

import com.harmonify.backspring.api.contracts.requests.ArtistaDTO;
import com.harmonify.backspring.domain.models.Artista;
import com.harmonify.backspring.domain.specifications.ArtistaEspecificacao;
import com.harmonify.backspring.infrastructure.repositories.ArtistaRepositorio;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ArtistaServico {

  private final ArtistaRepositorio artistaRepositorio;

  public List<ArtistaDTO> listarArtistas() {
    List<Artista> artistas = artistaRepositorio.findAll();
    return artistas.stream().map(ArtistaDTO::new).toList();
  }

  public ArtistaDTO encontrarArtista(UUID id) {
    Optional<Artista> artistaOpt = artistaRepositorio.findById(id);

    return artistaOpt.map(ArtistaDTO::new).orElse(null);
  }

  public void salvarArtista(ArtistaDTO artistaDTO) {
    Artista artista = new Artista(artistaDTO);
    artistaRepositorio.save(artista);
  }

  public void atualizarArtista(UUID id, ArtistaDTO artistaDTO) {
    Artista artista = artistaRepositorio.findById(id)
        .orElseThrow(() -> new RuntimeException("Artista não encontrado"));

    artista.setNome(artistaDTO.nome());
    artista.setFoto(artistaDTO.foto());
    artista.setBiografia(artistaDTO.biografia());
    artista.setPaisOrigem(artistaDTO.paisOrigem());

    artistaRepositorio.save(artista);
  }

  public List<ArtistaDTO> listarArtistasComFiltros(String genero) {
    List<Artista> artistas = artistaRepositorio.findAll(Specification.where(
        ArtistaEspecificacao.temGenero(genero)));

    return artistas.stream().map(ArtistaDTO::new).toList();
  }

  public boolean deletarArtista(UUID id) {
    Optional<Artista> artista = artistaRepositorio.findById(id);

    if(artista.isPresent()) {
      artistaRepositorio.deleteById(id);
      return true;
    }
    return false;
  }

}
