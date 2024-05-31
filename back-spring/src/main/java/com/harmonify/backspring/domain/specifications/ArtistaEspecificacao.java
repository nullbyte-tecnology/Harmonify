package com.harmonify.backspring.domain.specifications;

import com.harmonify.backspring.domain.models.Artista;
import org.springframework.data.jpa.domain.Specification;

public class ArtistaEspecificacao {

  public static Specification<Artista> temGenero(String genero) {
    return (root, query, cb) -> genero == null ? cb.conjunction() :
        cb.equal(root.get("genero"), genero);
  }

}
