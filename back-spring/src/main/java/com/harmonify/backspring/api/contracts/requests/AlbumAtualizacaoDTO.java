package com.harmonify.backspring.api.contracts.requests;

import java.util.Date;

public record AlbumAtualizacaoDTO(
        String nome,
        String descricao,
        Date dataLancamento) {
}
