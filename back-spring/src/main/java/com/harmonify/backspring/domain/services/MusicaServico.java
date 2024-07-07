package com.harmonify.backspring.domain.services;

import com.harmonify.backspring.api.contracts.requests.FiltroMusicaDTO;
import com.harmonify.backspring.api.contracts.requests.MusicaDTO;
import com.harmonify.backspring.domain.exception.DadosInvalidosExcecao;
import com.harmonify.backspring.domain.exception.RecursoNaoEncontradoExcecao;
import com.harmonify.backspring.domain.models.Artista;
import com.harmonify.backspring.api.contracts.responses.RespMusicaDTO;
import com.harmonify.backspring.domain.models.Musica;
import com.harmonify.backspring.domain.models.enums.GeneroMusical;
import com.harmonify.backspring.domain.specifications.MusicaEspecificacao;
import com.harmonify.backspring.infrastructure.repositories.ArtistaRepositorio;
import com.harmonify.backspring.infrastructure.repositories.MusicaRepositorio;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MusicaServico {

  private static final EnumSet<GeneroMusical> GENEROS_MUSICAIS_VALIDOS = EnumSet.allOf(
      GeneroMusical.class);
  private static final String MUSICA_NAO_ENCONTRADA = "Música não encontrada.";
  private static final String ARTISTA_NAO_ENCONTRADA = "Artista não encontrado.";
  private final MusicaRepositorio musicaRepositorio;
  private final ArtistaRepositorio artistaRepositorio;

  public List<RespMusicaDTO> listarMusicas(FiltroMusicaDTO filtroDTO) {
    Specification<Musica> spec = Specification
        .where(MusicaEspecificacao.temGenero(filtroDTO.genero()))
        .and(MusicaEspecificacao.temArtista(filtroDTO.nomeArtista()));

    List<Musica> musicas = musicaRepositorio.findAll(spec);

    return musicas.stream().map(RespMusicaDTO::new).toList();
  }

  public RespMusicaDTO encontrarMusica(UUID id) {
    Optional<Musica> musica = musicaRepositorio.findById(id);

    if(musica.isEmpty()) {
      throw new RecursoNaoEncontradoExcecao(MUSICA_NAO_ENCONTRADA);
    }

    return new RespMusicaDTO(musica.get());
  }

  public void salvarMusica(MusicaDTO musicaDTO) {
    Optional<Artista> artista = artistaRepositorio.findById(musicaDTO.idArtista());

    if(artista.isEmpty()) {
      throw new RecursoNaoEncontradoExcecao(ARTISTA_NAO_ENCONTRADA);
    }

    musicaRepositorio.save(new Musica(musicaDTO, artista.get()));
  }

  public void editarMusica(UUID id, MusicaDTO musicaDTO) {
    Musica musica = musicaRepositorio.findById(id)
        .orElseThrow(() -> new RecursoNaoEncontradoExcecao(MUSICA_NAO_ENCONTRADA));

    if(musicaDTO.idArtista() != null) {
      artistaRepositorio.findById(musicaDTO.idArtista())
          .orElseThrow((() -> new RecursoNaoEncontradoExcecao(ARTISTA_NAO_ENCONTRADA)));
    }

    BeanUtils.copyProperties(musicaDTO, musica);

    musicaRepositorio.save(musica);
  }

  public void deletarMusica(UUID id) {
    Musica musica = musicaRepositorio.findById(id)
        .orElseThrow(() -> new RecursoNaoEncontradoExcecao(MUSICA_NAO_ENCONTRADA));

    musicaRepositorio.delete(musica);
  }

  public Boolean validarMusica(MusicaDTO musicaDTO) {
    return GENEROS_MUSICAIS_VALIDOS.stream().anyMatch(g -> g.equals(musicaDTO.genero()));
  }

}
