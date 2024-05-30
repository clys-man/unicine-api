package edu.unifor.unicine.core.model.mapper;

import edu.unifor.unicine.core.model.dto.MovieDTO;
import edu.unifor.unicine.core.model.entity.Movie;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {SessionMapper.class})
public interface MovieMapper {

    @Mapping(source = "sessions", target = "sessionDTOS")
    MovieDTO toDTO(Movie movie);

    @InheritInverseConfiguration
    Movie toEntity(MovieDTO movie);

}
