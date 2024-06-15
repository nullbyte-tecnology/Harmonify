package com.harmonify.backspring.api.controllers;

import com.harmonify.backspring.api.contracts.requests.AlbumDTO;
import com.harmonify.backspring.api.contracts.responses.RespAlbumDTO;
import com.harmonify.backspring.domain.services.AlbumServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/albuns")
@RequiredArgsConstructor
public class AlbumControlador {

    private final AlbumServico albumServico;

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
}
