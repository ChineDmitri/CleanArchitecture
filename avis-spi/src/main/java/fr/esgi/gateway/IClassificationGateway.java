package fr.esgi.gateway;

import fr.esgi.avis.business.Classification;

import java.util.List;

public interface IClassificationGateway {
    List<Classification> recupererClassifications();
}
