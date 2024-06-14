package com.harmonify.backspring.domain.services;

import com.harmonify.backspring.api.contracts.requests.AlbumDTO;
import com.harmonify.backspring.api.contracts.requests.MusicaAlbumDTO;
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

@Service
@RequiredArgsConstructor
public class AlbumServico {

    private final AlbumRepositorio albumRepositorio;
    private final MusicaRepositorio musicaRepositorio;
    private final ArtistaRepositorio artistaRepositorio;

    public void salvarAlbum(AlbumDTO albumDTO){
        Optional<Artista> artista = artistaRepositorio.findById(albumDTO.artistaId());
        List<Musica> musicas = mapearMusicas(albumDTO.musicas());

        if(artista.isPresent()){
            Album album = new Album(albumDTO, artista.get(), musicas);
            albumRepositorio.save(album);
        }
    }

    public List<Musica> mapearMusicas(List<MusicaAlbumDTO> musicaAlbumDTOS){
        List<Musica> musicas = new ArrayList<>();

        for (MusicaAlbumDTO musicaAlbumDTO : musicaAlbumDTOS) {
            Optional<Musica> musicaOptional = musicaRepositorio.findByNomeAndArtistaId(musicaAlbumDTO.nome(), musicaAlbumDTO.artista());
            musicaOptional.ifPresent(musicas::add);
        }

        return musicas;
    }
}
