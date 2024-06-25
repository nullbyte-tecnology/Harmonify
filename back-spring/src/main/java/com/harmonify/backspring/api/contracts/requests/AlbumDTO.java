package com.harmonify.backspring.api.contracts.requests;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record AlbumDTO(
        String nome,
        UUID idArtista,
        List<UUID> idMusicas,
        String descricao,
        Date dataLancamento) {
}