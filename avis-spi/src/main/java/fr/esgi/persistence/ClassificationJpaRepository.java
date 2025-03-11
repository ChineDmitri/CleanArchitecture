package fr.esgi.persistence;

import fr.esgi.entity.ClassificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassificationJpaRepository extends JpaRepository<ClassificationEntity, Long> {
}
