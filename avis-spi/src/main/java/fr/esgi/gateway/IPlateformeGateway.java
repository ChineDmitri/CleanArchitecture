package fr.esgi.gateway;

import fr.esgi.avis.business.Plateforme;

import java.util.List;

public interface IPlateformeGateway {
    List<Plateforme> recupererPlateformes();
}
