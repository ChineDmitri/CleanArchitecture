package fr.esgi.adapter;

import fr.esgi.avis.business.Plateforme;
import fr.esgi.dto.PlateformeDto;
import org.mapstruct.*;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface PlateformeMapper {
    Plateforme toEntity(PlateformeDto plateformeDto);

    //@Mapping(target="dateDeSortie", source = "dateDeSortie", expression = "")
    PlateformeDto toDto(Plateforme plateforme);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Plateforme partialUpdate(PlateformeDto plateformeDto, @MappingTarget Plateforme plateforme);
}
