package fr.esgi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.esgi.avis.business.Classification;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class ClassificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String nom;

    @NonNull
    private String couleurRGB;

    @OneToMany(mappedBy = "classification")
    @JsonIgnore
    private List<JeuEntity> jeux;

    public Classification toDomain() {
        final Classification domain = new Classification();
        domain.setId(id);
        domain.setNom(nom);
        domain.setJeux(jeux != null ? jeux.stream().map(JeuEntity::toDomain).collect(Collectors.toList()) : null);
        return domain;
    }

}
