package com.harmonify.backspring.controlador;

import com.harmonify.backspring.dominio.dto.ArtistaDTO;
import com.harmonify.backspring.servico.ArtistaServico;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/artistas")
@AllArgsConstructor
public class ArtistaControlador {

    private final ArtistaServico artistaServico;

    @GetMapping
    public List<ArtistaDTO> listarArtistas(){
        return artistaServico.listarArtistas();
    }

    @PostMapping
    public void salvarArtista(ArtistaDTO artistaDTO){
        artistaServico.salvarArtista(artistaDTO);
    }

}
