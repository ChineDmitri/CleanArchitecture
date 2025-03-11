package fr.esgi.avis.business;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Avis {

    private Long id;

    @NonNull
    private String description;

    @NonNull
    private Jeu jeu;

    @NonNull
    private Joueur joueur;

    private Float note;

    private LocalDateTime dateDEnvoi;

    private Moderateur moderateur;
}
