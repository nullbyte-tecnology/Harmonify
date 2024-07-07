package com.harmonify.backspring.domain.specifications;

import com.harmonify.backspring.domain.models.Musica;
import jakarta.persistence.criteria.JoinType;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

@UtilityClass
public class MusicaEspecificacao {

  public static Specification<Musica> temArtista(String nome) {
    return (root, query, cb) -> nome == null || nome.isBlank() ? cb.conjunction() :
        cb.equal(root.join("artista", JoinType.INNER).get("nome"), nome);
  }

  public static Specification<Musica> temGenero(String genero) {
    return (root, query, cb) -> genero == null || genero.isBlank() ? cb.conjunction() :
        cb.equal(root.get("genero"), genero);
  }

}
