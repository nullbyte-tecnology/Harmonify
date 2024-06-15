package com.harmonify.backspring.api.contracts.responses;

import com.harmonify.backspring.api.contracts.requests.MusicaAlbumDTO;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record RespAlbumDTO(
        String nome,
        String artista,
        List<RespMusicaAlbumDTO> musicas,
        String descricao,
        Date dataLancamento) {
}
