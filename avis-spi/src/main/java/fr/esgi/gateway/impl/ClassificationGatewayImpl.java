package fr.esgi.gateway.impl;


import fr.esgi.avis.business.Classification;
import fr.esgi.entity.ClassificationEntity;
import fr.esgi.gateway.IClassificationGateway;
import fr.esgi.persistence.ClassificationJpaRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
public class ClassificationGatewayImpl implements IClassificationGateway {

    private ClassificationJpaRepository repository;

    @Override
    public List<Classification> recupererClassifications() {
        return repository.findAll()
                         .stream()
                         .map(ClassificationEntity::toDomain)
                         .collect(Collectors.toList());
    }
}
