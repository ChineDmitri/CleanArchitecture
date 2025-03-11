package fr.esgi.gateway.impl;

import fr.esgi.avis.business.Plateforme;
import fr.esgi.entity.PlateformeEntity;
import fr.esgi.gateway.IPlateformeGateway;
import fr.esgi.persistence.PlateformeJpaRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class PlateformeGatewayImpl implements IPlateformeGateway {

    private PlateformeJpaRepository repository;

    @Override
    public List<Plateforme> recupererPlateformes() {
        return repository.findAll()
                         .stream()
                         .map(PlateformeEntity::toDomain)
                         .collect(Collectors.toList());
    }
}
