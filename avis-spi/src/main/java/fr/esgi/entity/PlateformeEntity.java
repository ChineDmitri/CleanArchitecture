package fr.esgi.entity;

import fr.esgi.avis.business.Plateforme;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class PlateformeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String nom;

    @ToString.Exclude
    @ManyToMany(mappedBy = "plateformes")
    private List<JeuEntity> jeux;

    private LocalDate dateDeSortie;

    public Plateforme toDomain() {
        final Plateforme domain = new Plateforme();
        domain.setId(id);
        domain.setNom(nom);
        domain.setDateDeSortie(dateDeSortie);
        domain.setJeux(jeux != null ? jeux.stream().map(JeuEntity::toDomain).collect(Collectors.toList()) : null);
        return domain;
    }
}
