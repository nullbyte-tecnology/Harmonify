package com.harmonify.backspring.api.contracts.responses;

import com.harmonify.backspring.domain.models.Album;

import java.util.Date;
import java.util.List;

public record RespAlbumDTO(String nome, String artista, List<RespMusicaDTO> musicas,
        String descricao, Date dataLancamento) {

    public RespAlbumDTO(Album album, List<RespMusicaDTO> musicasDTO){
        this(album.getNome(), album.getArtista().getNome(), musicasDTO, album.getDescricao(), album.getDataLancamento());
    }
}
