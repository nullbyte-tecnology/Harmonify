package com.harmonify.backspring.controlador;

import com.harmonify.backspring.dominio.dto.ArtistaDTO;
import com.harmonify.backspring.servico.ArtistaServico;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/artistas")
public class ArtistaControlador {

    private final ArtistaServico artistaServico;

    public ArtistaControlador(ArtistaServico artistaServico) {
        this.artistaServico = artistaServico;
    }

    @GetMapping
    public List<ArtistaDTO> listarArtistas(){
        return artistaServico.listarArtistas();
    }

    @PostMapping
    public void salvarArtista(ArtistaDTO artistaDTO){
        artistaServico.salvarArtista(artistaDTO);
    }

    @PutMapping("/{id}")
    public void atualizarArtista(@PathVariable Long id, @RequestBody ArtistaDTO artistaDTO) {
        artistaServico.atualizarArtista(id, artistaDTO);
    }

    @GetMapping("/genero/{genero}")
    public List<ArtistaDTO> listarArtistasPorGenero(@PathVariable String genero) {
        return artistaServico.listarArtistasPorGenero(genero);
    }


}
