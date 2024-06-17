package com.harmonify.backspring.api.contracts.responses;

import java.util.Date;
import java.util.List;

public record RespAlbumDTO(
        String nome,
        String artista,
        List<RespMusicaAlbumDTO> musicas,
        String descricao,
        Date dataLancamento) {
}
