package fr.esgi.adapter;

import fr.esgi.avis.business.Jeu;
import fr.esgi.dto.JeuDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface JeuMapper {
    Jeu toEntity(JeuDto jeuDto);

    JeuDto toDto(Jeu jeu);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Jeu partialUpdate(JeuDto jeuDto, @MappingTarget Jeu jeu);
}
