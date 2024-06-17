package com.harmonify.backspring.domain.services;

import com.harmonify.backspring.api.contracts.requests.AlbumAtualizacaoDTO;
import com.harmonify.backspring.api.contracts.requests.AlbumDTO;
import com.harmonify.backspring.api.contracts.requests.MusicaAlbumDTO;
import com.harmonify.backspring.api.contracts.responses.RespAlbumDTO;
import com.harmonify.backspring.api.contracts.responses.RespMusicaAlbumDTO;
import com.harmonify.backspring.domain.models.Album;
import com.harmonify.backspring.domain.models.Artista;
import com.harmonify.backspring.domain.models.Musica;
import com.harmonify.backspring.infrastructure.repositories.AlbumRepositorio;
import com.harmonify.backspring.infrastructure.repositories.ArtistaRepositorio;
import com.harmonify.backspring.infrastructure.repositories.MusicaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AlbumServico {

    private final AlbumRepositorio albumRepositorio;
    private final MusicaRepositorio musicaRepositorio;
    private final ArtistaRepositorio artistaRepositorio;

    public void salvarAlbum(AlbumDTO albumDTO){
        Optional<Artista> artista = artistaRepositorio.findById(albumDTO.artistaId());
        // Porque não passar o ID da música?
        // Existe tb duas estratégias: criar a musica junto com o album
        // ou primerio as músicas, depois o album e as adiciona as músicas.

        // Faltou exceção caso o artista não seja encontrado.
        // RecursoNaoEncontradoException + codigo HTTP

        if(artista.isPresent()) {
            Album album = new Album(albumDTO, artista.get(), null);
            List<Musica> musicas = mapearMusicas(albumDTO.musicas(), albumDTO.artistaId(), album);
            album.setMusicas(musicas);

            albumRepositorio.save(album);
        }
    }

    public RespAlbumDTO detalharAlbum(UUID id){
        Optional<Album> album = albumRepositorio.findById(id);

        if(album.isPresent()){
            List<RespMusicaAlbumDTO> musicaAlbumDTOS = album.get().getMusicas().stream()
                    .map(this::mapearParaRespMusicaAlbumDTO)
                    .toList();

            return new RespAlbumDTO(
                    album.get().getNome(),
                    album.get().getArtista().getNome(),
                    musicaAlbumDTOS,
                    album.get().getDescricao(),
                    album.get().getDataLancamento()
            );
        } else {
            // RecursoNaoEncontradoException + codigo HTTP
            throw new RuntimeException("Álbum não encontrado");
        }
    }

    public void adicionarMusicaNoAlbum(UUID albumId, MusicaAlbumDTO musicaAlbumDTO){
        Optional<Album> albumOptional = albumRepositorio.findById(albumId);
        Optional<Musica> musicaOptional = musicaRepositorio.findByNomeAndArtistaId(musicaAlbumDTO.nome(), musicaAlbumDTO.idArtista());

        // RecursoNaoEncontradoException + codigo HTTP
        if(albumOptional.isEmpty()) throw new RuntimeException("Álbum não encontrado.");
        if(musicaOptional.isEmpty()) throw new RuntimeException("Música não encontrado.");

        Album album = albumOptional.get();
        Musica musica = musicaOptional.get();

        if (!album.getArtista().getId().equals(musica.getArtista().getId())) throw new RuntimeException("O artista da música não corresponde ao artista do álbum.");

        if(!album.getMusicas().contains(musica)){
            musica.setAlbum(album);
            album.getMusicas().add(musica);
            albumRepositorio.save(album);
        } else {
            throw new RuntimeException("Essa música já foi adicionada no álbum.");
        }
    }

    public void removerMusicaNoAlbum(UUID albumId, String nomeMusica){
        Optional<Album> albumOptional = albumRepositorio.findById(albumId);

        // RecursoNaoEncontradoException + codigo HTTP
        if(albumOptional.isEmpty()) throw new RuntimeException("Álbum não encontrado.");

        Album album = albumOptional.get();

        Optional<Musica> musicaOptional = album.getMusicas().stream()
                .filter(musica -> musica.getNome().equals(nomeMusica))
                .findFirst();

        if (musicaOptional.isPresent()) {
            Musica musicaRemover = musicaOptional.get();
            musicaRemover.setAlbum(null);
            album.getMusicas().remove(musicaRemover);
            albumRepositorio.save(album);
        } else {
            throw new RuntimeException("Música não encontrada no álbum.");
        }
    }

    public List<RespAlbumDTO> buscarAlbunsPorArtista(UUID artistaId){
        List<Album> albuns = albumRepositorio.findByArtistaId(artistaId);

        // RecursoNaoEncontradoException + codigo HTTP.
        if (albuns.isEmpty()) {
            throw new RuntimeException("Nenhum álbum encontrado para o artista com ID: " + artistaId);
        }

        return albuns.stream()
                .map(this::mapearParaRespAlbumDTO).toList();
    }


    public void atualizarAlbum(UUID albumId, AlbumAtualizacaoDTO albumAtualizacaoDTO){
        Optional<Album> albumOptional = albumRepositorio.findById(albumId);

        // RecursoNaoEncontradoException + codigo HTTP
        if(albumOptional.isEmpty()) throw new RuntimeException("Álbum não encontrado.");

        Album album = albumOptional.get();
        album.setNome(albumAtualizacaoDTO.nome());
        album.setDescricao(albumAtualizacaoDTO.descricao());
        album.setDataLancamento(albumAtualizacaoDTO.dataLancamento());

        albumRepositorio.save(album);
    }

    public void deletarAlbum(UUID id){
        Optional<Album> album = albumRepositorio.findById(id);

        // RecursoNaoEncontradoException + codigo HTTP
        if(album.isEmpty()) throw new RuntimeException("Álbum não encontrado.");

        album.get().getMusicas().clear();
        albumRepositorio.delete(album.get());
    }

    private List<Musica> mapearMusicas(List<MusicaAlbumDTO> musicaAlbumDTOS, UUID artistaId, Album album) {
        List<Musica> musicas = new ArrayList<>();

        for (MusicaAlbumDTO musicaAlbumDTO : musicaAlbumDTOS) {
            Optional<Musica> musicaOptional = musicaRepositorio.findByNomeAndArtistaId(musicaAlbumDTO.nome(), musicaAlbumDTO.idArtista());

            if (musicaOptional.isPresent()) {
                Musica musica = musicaOptional.get();

                if (!musica.getArtista().getId().equals(artistaId)) {
                    throw new RuntimeException("A música '" + musica.getNome() + "' não pertence ao artista do álbum.");
                }
                musica.setAlbum(album);
                musicas.add(musica);
            } else {
                throw new RuntimeException("Música não encontrada para nome: " + musicaAlbumDTO.nome() + " e idArtista: " + musicaAlbumDTO.idArtista());
            }
        }
        return musicas;
    }

    private RespMusicaAlbumDTO mapearParaRespMusicaAlbumDTO(Musica musica) {
        return new RespMusicaAlbumDTO(
                musica.getNome(),
                musica.getGenero().getValor(),
                musica.getDuracao(),
                musica.getLancamento(),
                musica.getFoto() );
    }

    private RespAlbumDTO mapearParaRespAlbumDTO(Album album) {
        List<RespMusicaAlbumDTO> musicaAlbumDTOS = album.getMusicas().stream()
                .map(this::mapearParaRespMusicaAlbumDTO)
                .toList();

        return new RespAlbumDTO(
                album.getNome(),
                album.getArtista().getNome(),
                musicaAlbumDTOS,
                album.getDescricao(),
                album.getDataLancamento()
        );
    }

}
