package com.harmonify.backspring.servico;

import com.harmonify.backspring.dominio.Artista;
import com.harmonify.backspring.dominio.dto.ArtistaDTO;
import com.harmonify.backspring.repositorio.ArtistaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArtistaServico {

    private final ArtistaRepositorio artistaRepositorio;

    public List<ArtistaDTO> listarArtistas(){
        List<Artista> artistas = artistaRepositorio.findAll();
        return artistas.stream().map(ArtistaDTO::new).toList();
    }

    public void salvarArtista(ArtistaDTO artistaDTO){
        Artista artista = new Artista(artistaDTO);
        artistaRepositorio.save(artista);
    }

    public void atualizarArtista(Long id, ArtistaDTO artistaDTO) {
        Artista artista = artistaRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Artista não encontrado"));

        artista.setNome(artistaDTO.nome());
        artista.setNacionalidade(artistaDTO.nacionalidade());
        artista.setBiografia(artistaDTO.biografia());
        artista.setPaisOrigem(artistaDTO.paisOrigem());

        artistaRepositorio.save(artista);
    }
}
