package com.harmonify.backspring.domain.services;

import com.harmonify.backspring.api.contracts.requests.AlbumAtualizacaoDTO;
import com.harmonify.backspring.api.contracts.requests.AlbumDTO;
import com.harmonify.backspring.api.contracts.requests.FiltroAlbumDTO;
import com.harmonify.backspring.api.contracts.responses.RespAlbumDTO;
import com.harmonify.backspring.api.contracts.responses.RespMusicaDTO;
import com.harmonify.backspring.domain.exception.MusicaInvalidaExcecao;
import com.harmonify.backspring.domain.exception.RecursoNaoEncontradoExcecao;
import com.harmonify.backspring.domain.models.Album;
import com.harmonify.backspring.domain.models.Artista;
import com.harmonify.backspring.domain.models.Musica;
import com.harmonify.backspring.domain.specifications.AlbumEspecificacao;
import com.harmonify.backspring.infrastructure.repositories.AlbumRepositorio;
import com.harmonify.backspring.infrastructure.repositories.ArtistaRepositorio;
import com.harmonify.backspring.infrastructure.repositories.MusicaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AlbumServico {

    private static final String ALBUM_NAO_ENCONTRADO = "Álbum não encontrado";
    private static final String MUSICA_NAO_ENCONTRADA = "Música não encontrada.";
    private static final String ARTISTA_NAO_ENCONTRADO = "Artista não encontrado.";

    private final AlbumRepositorio albumRepositorio;
    private final MusicaRepositorio musicaRepositorio;
    private final ArtistaRepositorio artistaRepositorio;

    public List<RespAlbumDTO> listarAlbuns(FiltroAlbumDTO filtroAlbumDTO){

        Specification<Album> spec = Specification
                .where(AlbumEspecificacao.temArtista(filtroAlbumDTO.artista()));

        List<Album> albuns = albumRepositorio.findAll(spec);

        return albuns.stream()
                .map(this::mapearParaRespAlbumDTO).toList();
    }

    public void salvarAlbum(AlbumDTO albumDTO){
        Optional<Artista> artista = artistaRepositorio.findById(albumDTO.idArtista());

        if(artista.isEmpty()) {
            throw new RecursoNaoEncontradoExcecao(ARTISTA_NAO_ENCONTRADO);
        }

        Album album = new Album(albumDTO, artista.get(), null);
        List<Musica> musicas = mapearMusicas(albumDTO.idMusicas(), albumDTO.idArtista(), album);
        album.setMusicas(musicas);

        albumRepositorio.save(album);
    }

    public RespAlbumDTO detalharAlbum(UUID id){
        Optional<Album> album = albumRepositorio.findById(id);

        if(album.isEmpty()) {
            throw new RecursoNaoEncontradoExcecao(ALBUM_NAO_ENCONTRADO);
        }

        List<RespMusicaDTO> musicaAlbumDTOS = album.get().getMusicas().stream()
            .map(RespMusicaDTO::new)
            .toList();

        return new RespAlbumDTO(album.get(), musicaAlbumDTOS);
    }

    public void adicionarMusicaNoAlbum(UUID idAlbum, UUID idMusica){
        Optional<Album> albumOptional = albumRepositorio.findById(idAlbum);
        Optional<Musica> musicaOptional = musicaRepositorio.findById(idMusica);

        if(albumOptional.isEmpty()) throw new RecursoNaoEncontradoExcecao(ALBUM_NAO_ENCONTRADO);
        if(musicaOptional.isEmpty()) throw new RecursoNaoEncontradoExcecao(MUSICA_NAO_ENCONTRADA);

        Album album = albumOptional.get();
        Musica musica = musicaOptional.get();

        if (!album.getArtista().getId().equals(musica.getArtista().getId())) {
            throw new MusicaInvalidaExcecao("O artista da música não corresponde ao artista do álbum.");
        }

        if(album.getMusicas().contains(musica)){
            throw new MusicaInvalidaExcecao("Essa música já foi adicionada no álbum.");
        }

        musica.setAlbum(album);
        album.getMusicas().add(musica);
        albumRepositorio.save(album);
    }

    public void removerMusicaNoAlbum(UUID idAlbum, UUID idMusica){
        Optional<Album> albumOptional = albumRepositorio.findById(idAlbum);

        if(albumOptional.isEmpty()) throw new RecursoNaoEncontradoExcecao(ALBUM_NAO_ENCONTRADO);

        Album album = albumOptional.get();

        Optional<Musica> musicaOptional = album.getMusicas().stream()
                .filter(musica -> musica.getId().equals(idMusica)).findFirst();

        if (musicaOptional.isEmpty()) {
            throw new RecursoNaoEncontradoExcecao("Música não encontrada no álbum.");
        }

        Musica musicaRemover = musicaOptional.get();
        musicaRemover.setAlbum(null);
        album.getMusicas().remove(musicaRemover);
        albumRepositorio.save(album);
    }

    public void atualizarAlbum(UUID albumId, AlbumAtualizacaoDTO albumAtualizacaoDTO){
        Optional<Album> albumOptional = albumRepositorio.findById(albumId);

        if(albumOptional.isEmpty()) throw new RecursoNaoEncontradoExcecao(ALBUM_NAO_ENCONTRADO);

        Album album = albumOptional.get();
        BeanUtils.copyProperties(albumAtualizacaoDTO, album);

        albumRepositorio.save(album);
    }

    public void deletarAlbum(UUID id){
        Optional<Album> album = albumRepositorio.findById(id);

        if(album.isEmpty()) throw new RecursoNaoEncontradoExcecao(ALBUM_NAO_ENCONTRADO);

        album.get().getMusicas().clear();
        albumRepositorio.save(album.get());
        albumRepositorio.delete(album.get());
    }

    private List<Musica> mapearMusicas(List<UUID> idMusicas, UUID artistaId, Album album) {
        List<Musica> musicas = new ArrayList<>();

        idMusicas.forEach(idMusica -> {
            Optional<Musica> musicaOptional = musicaRepositorio.findById(idMusica);

            if (musicaOptional.isEmpty()) {
                throw new MusicaInvalidaExcecao(MUSICA_NAO_ENCONTRADA);
            }

            Musica musica = musicaOptional.get();

            if (!musica.getArtista().getId().equals(artistaId)) {
                throw new MusicaInvalidaExcecao("A música " + musica.getNome() +
                    " não pertence ao artista do álbum.");
            }

            musica.setAlbum(album);
            musicas.add(musica);
        });

        return musicas;
    }

    private RespAlbumDTO mapearParaRespAlbumDTO(Album album) {
        List<RespMusicaDTO> musicas = album.getMusicas().stream()
                .map(RespMusicaDTO::new)
                .toList();

        return new RespAlbumDTO(album, musicas);
    }

}
