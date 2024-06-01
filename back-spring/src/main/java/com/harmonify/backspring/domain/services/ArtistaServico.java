package com.harmonify.backspring.domain.services;

import com.harmonify.backspring.api.contracts.requests.ArtistaDTO;
import com.harmonify.backspring.domain.exception.RecursoNaoEncontradoExcecao;
import com.harmonify.backspring.domain.models.Artista;
import com.harmonify.backspring.domain.specifications.ArtistaEspecificacao;
import com.harmonify.backspring.infrastructure.repositories.ArtistaRepositorio;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ArtistaServico {

  private static final String ARTISTA_NAO_ENCONTRADO = "Artista não encontrado.";

  private final ArtistaRepositorio artistaRepositorio;

  public List<ArtistaDTO> listarArtistas(String genero) {
    if (genero != null) {
      return listarArtistasComFiltros(genero);
    }

    List<Artista> artistas = artistaRepositorio.findAll();

    return artistas.stream().map(ArtistaDTO::new).toList();
  }

  public ArtistaDTO encontrarArtista(UUID id) {
    Optional<Artista> artistaOpt = artistaRepositorio.findById(id);

    return artistaOpt.map(ArtistaDTO::new)
        .orElseThrow(() -> new RecursoNaoEncontradoExcecao(ARTISTA_NAO_ENCONTRADO));
  }

  public void salvarArtista(ArtistaDTO artistaDTO) {
    Artista artista = new Artista(artistaDTO);
    artistaRepositorio.save(artista);
  }

  public void atualizarArtista(UUID id, ArtistaDTO artistaDTO) {
    Artista artista = artistaRepositorio.findById(id)
        .orElseThrow(() -> new RecursoNaoEncontradoExcecao(ARTISTA_NAO_ENCONTRADO));

    BeanUtils.copyProperties(artistaDTO, artista);

    artistaRepositorio.save(artista);
  }

  public List<ArtistaDTO> listarArtistasComFiltros(String genero) {
    List<Artista> artistas = artistaRepositorio.findAll(Specification.where(
        ArtistaEspecificacao.temGenero(genero)));

    return artistas.stream().map(ArtistaDTO::new).toList();
  }

  public void  deletarArtista(UUID id) {
    Artista artista = artistaRepositorio.findById(id)
        .orElseThrow(() -> new RecursoNaoEncontradoExcecao(ARTISTA_NAO_ENCONTRADO));

    artistaRepositorio.delete(artista);
  }

}
