package com.harmonify.backspring.domain.services;

import com.harmonify.backspring.api.contracts.requests.MusicaDTO;
import com.harmonify.backspring.domain.exception.DadosInvalidosExcecao;
import com.harmonify.backspring.domain.exception.RecursoNaoEncontradoExcecao;
import com.harmonify.backspring.domain.models.Artista;
import com.harmonify.backspring.api.contracts.responses.RespMusicaDTO;
import com.harmonify.backspring.domain.models.Musica;
import com.harmonify.backspring.domain.models.enums.GeneroMusical;
import com.harmonify.backspring.infrastructure.repositories.ArtistaRepositorio;
import com.harmonify.backspring.infrastructure.repositories.MusicaRepositorio;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MusicaServico {

  private static final EnumSet<GeneroMusical> GENEROS_MUSICAIS_VALIDOS = EnumSet.allOf(
      GeneroMusical.class);
  private final MusicaRepositorio musicaRepositorio;
  private final ArtistaRepositorio artistaRepositorio;

  public List<RespMusicaDTO> listarMusicas() {
    List<Musica> musicas = musicaRepositorio.findAll();

    return musicas.stream()
        .map(RespMusicaDTO::new)
        .toList();
  }

  public void salvarMusica(MusicaDTO musicaDTO) {
    Optional<Artista> artista = artistaRepositorio.findById(musicaDTO.idArtista());

    if(artista.isEmpty()) {
      throw new RecursoNaoEncontradoExcecao("Artista não encontrado.");
    }
    if (Boolean.FALSE.equals(validarMusica(musicaDTO))) {
      throw new DadosInvalidosExcecao("Gênero musical inválido.");
    }

    musicaRepositorio.save(new Musica(musicaDTO, artista.get()));
  }

  public Boolean validarMusica(MusicaDTO musicaDTO) {
    return GENEROS_MUSICAIS_VALIDOS.stream()
        .anyMatch(generoMusical -> generoMusical.getValor().equals(musicaDTO.generoMusical()));
  }

}
