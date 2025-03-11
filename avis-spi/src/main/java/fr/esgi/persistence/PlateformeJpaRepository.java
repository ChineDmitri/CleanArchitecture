package fr.esgi.persistence;

import fr.esgi.entity.PlateformeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlateformeJpaRepository extends JpaRepository<PlateformeEntity, Long> {
}
