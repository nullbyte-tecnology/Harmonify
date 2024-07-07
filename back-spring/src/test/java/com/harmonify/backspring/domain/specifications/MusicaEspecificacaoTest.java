package com.harmonify.backspring.domain.specifications;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import com.harmonify.backspring.domain.models.Musica;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.domain.Specification;

class MusicaEspecificacaoTest {

  @Test
  void testTemArtistaComNomeNuloOuVazio() {
    String nomeArtista = null;
    Root<Musica> root = mock(Root.class);
    CriteriaQuery<?> query = mock(CriteriaQuery.class);
    CriteriaBuilder cb = mock(CriteriaBuilder.class);

    Specification<Musica> spec = MusicaEspecificacao.temArtista(nomeArtista);
    Predicate predicate = spec.toPredicate(root, query, cb);

    verify(cb, never()).equal(any(), any());
    verify(cb).conjunction();
  }

  @Test
  void testTemGeneroComGeneroNuloOuVazio() {
    String genero = null;
    Root<Musica> root = mock(Root.class);
    CriteriaQuery<?> query = mock(CriteriaQuery.class);
    CriteriaBuilder cb = mock(CriteriaBuilder.class);

    Specification<Musica> spec = MusicaEspecificacao.temGenero(genero);
    Predicate predicate = spec.toPredicate(root, query, cb);

    verify(cb, never()).equal(any(), any());
    verify(cb).conjunction();
  }

  @Test
  void testTemGeneroComGeneroPreenchido() {
    String genero = "Rock";
    Root<Musica> root = mock(Root.class);
    CriteriaQuery<?> query = mock(CriteriaQuery.class);
    CriteriaBuilder cb = mock(CriteriaBuilder.class);

    Specification<Musica> spec = MusicaEspecificacao.temGenero(genero);
    Predicate predicate = spec.toPredicate(root, query, cb);

    verify(cb).equal(root.get("genero"), genero);
  }

  @Test
  void testUtilityClassConstructor() {
    Constructor<?>[] constructors = MusicaEspecificacao.class.getDeclaredConstructors();
    assertEquals(1, constructors.length,
        "A classe de utilitário não deve ter construtores públicos");
  }

  @Test
  void testUtilityClassInstantiation() throws NoSuchMethodException {
    Constructor<?>[] constructors = MusicaEspecificacao.class.getDeclaredConstructors();
    assertEquals(1, constructors.length,
        "A classe de utilitário não deve ter construtores públicos");

    Constructor<?> constructor = MusicaEspecificacao.class.getDeclaredConstructor();
    constructor.setAccessible(true);

    assertThrows(InvocationTargetException.class, constructor::newInstance,
        "A instância direta de uma classe de utilitário deve falhar com InvocationTargetException");
  }
}
