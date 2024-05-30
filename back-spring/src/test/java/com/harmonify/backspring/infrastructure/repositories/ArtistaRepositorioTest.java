package com.harmonify.backspring.infrastructure.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import com.harmonify.backspring.api.contracts.requests.ArtistaDTO;
import com.harmonify.backspring.domain.models.Artista;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {"spring.datasource.url=jdbc:h2:mem:testdb"})
class ArtistaRepositorioTest {

  @Autowired
  private ArtistaRepositorio artistaRepositorio;

  @Test
  void testHerancaJpaRepository() {
    assertThat(artistaRepositorio).isInstanceOf(JpaRepository.class);
  }

  @AfterEach
  void afterEach() {
    artistaRepositorio.deleteAll();
  }

  @Test
  void testSalvarEBuscarArtista() {
    Artista artista = new Artista(
        new ArtistaDTO("Artista 1", "Genero 1", "Nacionalidade 1", "Biografia", "Pais 1"));

    artistaRepositorio.save(artista);

    Artista artistaSalvo = artistaRepositorio.findById(artista.getId()).orElse(null);

    assertThat(artistaSalvo).isNotNull();
    assertThat(artistaSalvo.getNome()).isEqualTo("Artista 1");
    assertThat(artistaSalvo.getGenero()).isEqualTo("Genero 1");
    assertThat(artistaSalvo.getNacionalidade()).isEqualTo("Nacionalidade 1");
    assertThat(artistaSalvo.getBiografia()).isEqualTo("Biografia");
    assertThat(artistaSalvo.getPaisOrigem()).isEqualTo("Pais 1");
  }

  @Test
  void testEncontrarArtistasPorGenero() {
    List<Artista> artistasMock = new ArrayList<>();
    artistasMock.add(new Artista(
        new ArtistaDTO("Artista 1", "Genero 1", "Nacionalidade 1", "Biografia", "Pais 1")));
    artistasMock.add(new Artista(
        new ArtistaDTO("Artista 2", "Genero 2", "Nacionalidade 2", "Biografia", "Pais 2")));

    artistaRepositorio.saveAll(artistasMock);

    List<Artista> artistasEncontrados = artistaRepositorio.findAllByGenero("Genero 1");

    assertThat(artistasEncontrados).isNotEmpty();
    assertThat(artistasEncontrados.stream().map(Artista::getNome))
        .containsExactlyInAnyOrder(artistasMock.get(0).getNome());
  }
}