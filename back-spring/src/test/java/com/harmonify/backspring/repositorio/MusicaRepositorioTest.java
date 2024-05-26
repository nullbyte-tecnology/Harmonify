package com.harmonify.backspring.repositorio;

import static org.assertj.core.api.Assertions.assertThat;

import com.harmonify.backspring.dominio.Musica;
import com.harmonify.backspring.dominio.dto.MusicaDTO;
import java.sql.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {"spring.datasource.url=jdbc:h2:mem:testdb"})
class MusicaRepositorioTest {

  @Autowired
  private MusicaRepositorio musicaRepositorio;

  @Test
  void testHerancaJpaRepository() {
    assertThat(musicaRepositorio).isInstanceOf(JpaRepository.class);
  }

  @Test
  void testSalvarEBuscarMusica() {
    Musica musica = new Musica(
        new MusicaDTO(
            "Nome da Música",
            "Artista",
            "Rock",
            "03:45",
            Date.valueOf("2022-01-01"),
            new byte[0])
    );

    musicaRepositorio.save(musica);

    Musica musicaSalva = musicaRepositorio.findById(musica.getId()).orElse(null);

    assertThat(musicaSalva).isNotNull();
    assertThat(musicaSalva.getNome()).isEqualTo("Nome da Música");
    assertThat(musicaSalva.getArtista()).isEqualTo("Artista");
    assertThat(musicaSalva.getGenero()).isEqualTo("Rock");
    assertThat(musicaSalva.getDuracaoSegundos()).isEqualTo("03:45");
    assertThat(musicaSalva.getLancamento()).isEqualTo(java.sql.Date.valueOf("2022-01-01"));
    assertThat(musicaSalva.getFoto()).isEqualTo(new byte[0]);
  }
}
