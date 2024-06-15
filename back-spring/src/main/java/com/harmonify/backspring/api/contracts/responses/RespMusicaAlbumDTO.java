package com.harmonify.backspring.api.contracts.responses;

import java.sql.Date;

public record RespMusicaAlbumDTO (String nome, String generoMusical, String duracao,
                                  Date dataLancamento, byte[] foto) {
}
