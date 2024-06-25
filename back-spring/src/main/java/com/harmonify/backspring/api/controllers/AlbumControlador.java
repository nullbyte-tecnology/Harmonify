package com.harmonify.backspring.api.controllers;

import com.harmonify.backspring.api.contracts.requests.AlbumAtualizacaoDTO;
import com.harmonify.backspring.api.contracts.requests.AlbumDTO;
import com.harmonify.backspring.api.contracts.requests.FiltroAlbumDTO;
import com.harmonify.backspring.api.contracts.responses.RespAlbumDTO;
import com.harmonify.backspring.domain.services.AlbumServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/albuns")
@RequiredArgsConstructor
public class AlbumControlador {

    private final AlbumServico albumServico;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RespAlbumDTO> listarAlbuns(FiltroAlbumDTO filtroAlbumDTO){
        return albumServico.listarAlbuns(filtroAlbumDTO);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvarAlbum(@RequestBody AlbumDTO albumDTO){
        albumServico.salvarAlbum(albumDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RespAlbumDTO detalharAlbum(@PathVariable UUID id){
        return albumServico.detalharAlbum(id);
    }

    @PostMapping("/{id}/adicionar-musica")
    @ResponseStatus(HttpStatus.OK)
    public void adicionarMusicaNoAlbum(@PathVariable UUID id, @RequestBody UUID idMusica){
        albumServico.adicionarMusicaNoAlbum(id, idMusica);
    }

    @PostMapping("/{id}/remover-musica")
    @ResponseStatus(HttpStatus.OK)
    public void removerMusicaDoAlbum(@PathVariable UUID id, @RequestParam UUID idMusica){
        albumServico.removerMusicaNoAlbum(id, idMusica);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarAlbum(@PathVariable UUID id, @RequestBody AlbumAtualizacaoDTO albumAtualizacaoDTO){
        albumServico.atualizarAlbum(id, albumAtualizacaoDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAlbum(@PathVariable UUID id){
        albumServico.deletarAlbum(id);
    }

}
