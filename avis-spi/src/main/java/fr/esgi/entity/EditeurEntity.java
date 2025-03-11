package fr.esgi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.esgi.avis.business.Editeur;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class EditeurEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NonNull
    @NotBlank(message="Merci de préciser le nom de l'éditeur")
    @Size(min=2, message="Le nom de l'éditeur doit comporter au moins {min} caractères")
    private String nom;

    @OneToMany(mappedBy="editeur", cascade = CascadeType.REMOVE)
    @JsonBackReference
    @ToString.Exclude
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private List<JeuEntity> jeux;

    public Editeur toDomain() {
        final Editeur domain = new Editeur();
        domain.setId(id);
        domain.setNom(nom);
        domain.setJeux(jeux != null ? jeux.stream().map(JeuEntity::toDomain).collect(Collectors.toList()) : null);
        return domain;
    }
}
