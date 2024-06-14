package com.harmonify.backspring.domain.specifications;

import com.harmonify.backspring.domain.models.Artista;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

@UtilityClass
public class ArtistaEspecificacao {

  public static Specification<Artista> temGenero(String genero) {
    return (root, query, cb) -> genero == null ? cb.conjunction() :
        cb.equal(root.get("genero"), genero);
  }

  public static Specification<Artista> temPaisOrigem(String paisOrigem) {
    return (root, query, cb) -> paisOrigem == null ? cb.conjunction() :
        cb.equal(root.get("paisOrigem"), paisOrigem);
  }

}
