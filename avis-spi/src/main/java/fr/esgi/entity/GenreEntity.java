package fr.esgi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.esgi.avis.business.Genre;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String nom;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "genre")
    private List<JeuEntity> jeux;

    public Genre toDomain() {
        final Genre domain = new Genre();
        domain.setId(id);
        domain.setNom(nom);
        domain.setJeux(jeux != null ? jeux.stream()
                                          .map(JeuEntity::toDomain)
                                          .collect(Collectors.toList()) : null);

        return domain;
    }
}
