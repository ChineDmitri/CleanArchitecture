package fr.esgi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import fr.esgi.avis.business.Jeu;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@DynamicUpdate
@DynamicInsert
@Table(indexes = @Index(name = "Jeu_Nom_Index", columnList = "nom"))
public class JeuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "jeu_seq")
    @SequenceGenerator(name = "jeu_seq")
    private Long id;

    @Column(nullable = false)
    @NonNull
    private String nom;

    @NonNull
    @ManyToOne // Many JeuEntity to One EditeurEntity
    @JsonManagedReference
    private EditeurEntity editeur;

    @ManyToOne // Many JeuEntity to One GenreEntity
    private GenreEntity genre;

    @ManyToOne
    private ClassificationEntity classification;

    @Lob
    private String description;

    private LocalDate dateDeSortie;

    // JeuEntity est la classe centrale
    //
    @ManyToMany
    private List<PlateformeEntity> plateformes;

    private String image;

    private float prix;

    //private int version;

    public JeuEntity(String nom) {
        super();
        this.nom = nom;
    }

    public JeuEntity(String nom, LocalDate dateDeSortie, EditeurEntity editeur) {
        this(nom, editeur);
        this.dateDeSortie = dateDeSortie;
    }

    public JeuEntity(String nom, String description, LocalDate dateSortie, EditeurEntity editeur) {
        this(nom, dateSortie, editeur);
        this.description = description;
    }

    public JeuEntity(String nom, LocalDate dateSortie, EditeurEntity editeur, GenreEntity genre) {
        this(nom, null, dateSortie, editeur);
        this.genre = genre;
    }

    public Jeu toDomain() {
        final Jeu domain = new Jeu();
        domain.setId(this.id);
        domain.setDescription(this.description);
        domain.setDateDeSortie(this.dateDeSortie);
        domain.setEditeur(this.editeur != null ? this.editeur.toDomain() : null);
        domain.setGenre(this.genre != null ? this.genre.toDomain() : null);
        domain.setPrix(this.prix);
        domain.setImage(this.image);
        domain.setClassification(this.classification != null ? this.classification.toDomain() : null);
        domain.setPlateformes(plateformes != null
                                      ? plateformes.stream()
                                                   .map(PlateformeEntity::toDomain)
                                                   .toList()
                                      : null);
        return domain;
    }

}
