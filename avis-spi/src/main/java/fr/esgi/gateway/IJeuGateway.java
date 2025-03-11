package fr.esgi.gateway;

import fr.esgi.avis.business.Jeu;

import java.util.List;

public interface IJeuGateway {
    List<Jeu> recupererJeux();
    Jeu recupererJeuParId(Long id);
}
