package fr.esgi.gateway.impl;

import fr.esgi.avis.business.Jeu;
import fr.esgi.entity.JeuEntity;
import fr.esgi.gateway.IJeuGateway;
import fr.esgi.persistence.JeuJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class JeuGatewayImpl implements IJeuGateway {

    private JeuJpaRepository repository;

    public JeuGatewayImpl() {
    }

    @Override
    public List<Jeu> recupererJeux() {
        return repository.findAll()
                         .stream()
                         .map(JeuEntity::toDomain)
                         .collect(Collectors.toList());
    }

    public Jeu recupererJeuParId(Long id) {
        return repository.findById(id)
                         .map(JeuEntity::toDomain)
                         .orElse(null);
    }
}
