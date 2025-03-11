package fr.esgi.avis.business;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Genre {

    private Long id;

    private String nom;

    @ToString.Exclude
    private List<Jeu> jeux;

}
