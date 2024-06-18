package com.harmonify.backspring.domain.specifications;

import com.harmonify.backspring.domain.models.Album;
import jakarta.persistence.criteria.JoinType;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

@UtilityClass
public class AlbumEspecificacao {
    public static Specification<Album> temArtista(String nome) {
        return (root, query, cb) -> nome == null || nome.isBlank() ? cb.conjunction() :
                cb.equal(root.join("artista", JoinType.INNER).get("nome"), nome);
    }
}
