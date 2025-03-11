package fr.esgi.persistence;

import fr.esgi.entity.JeuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JeuJpaRepository extends JpaRepository<JeuEntity, Long> {
}
