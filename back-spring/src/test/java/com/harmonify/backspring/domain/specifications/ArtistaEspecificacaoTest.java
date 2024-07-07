package com.harmonify.backspring.domain.specifications;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.harmonify.backspring.domain.models.Artista;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.domain.Specification;

class ArtistaEspecificacaoTest {

  @Mock
  private Root<Artista> root;

  @Mock
  private CriteriaQuery<?> query;

  @Mock
  private CriteriaBuilder cb;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testTemGeneroWithNullGenero() {
    Specification<Artista> spec = ArtistaEspecificacao.temGenero(null);

    Predicate predicate = spec.toPredicate(root, query, cb);

    assertNull(predicate);
    verify(cb, times(1)).conjunction();
  }

  @Test
  void testTemGeneroWithNonNullGenero() {
    String genero = "ROCK";
    Specification<Artista> spec = ArtistaEspecificacao.temGenero(genero);

    when(cb.equal(root.get("genero"), genero)).thenReturn(mock(Predicate.class));

    Predicate predicate = spec.toPredicate(root, query, cb);

    assertNotNull(predicate);
    verify(cb, times(1)).equal(root.get("genero"), genero);
  }

  @Test
  void testTemPaisOrigemWithNullPaisOrigem() {
    Specification<Artista> spec = ArtistaEspecificacao.temPaisOrigem(null);

    Predicate predicate = spec.toPredicate(root, query, cb);

    assertNull(predicate);
    verify(cb, times(1)).conjunction();
  }

  @Test
  void testTemPaisOrigemWithNonNullPaisOrigem() {
    String paisOrigem = "Brazil";
    Specification<Artista> spec = ArtistaEspecificacao.temPaisOrigem(paisOrigem);

    when(cb.equal(root.get("paisOrigem"), paisOrigem)).thenReturn(mock(Predicate.class));

    Predicate predicate = spec.toPredicate(root, query, cb);

    assertNotNull(predicate);
    verify(cb, times(1)).equal(root.get("paisOrigem"), paisOrigem);
  }

  @Test
  void testConstructor() throws NoSuchMethodException {
    Constructor<ArtistaEspecificacao> constructor = ArtistaEspecificacao.class.getDeclaredConstructor();
    constructor.setAccessible(true);

    assertNotNull(constructor);
    assertTrue(Modifier.isPrivate(constructor.getModifiers()));
    
    assertThrows(InvocationTargetException.class, constructor::newInstance);
  }
}
