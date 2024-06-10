package edu.unifor.unicine.core.model.mapper;

import edu.unifor.unicine.core.model.dto.MovieDTO;
import edu.unifor.unicine.core.model.entity.Movie;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(source = "sessions", target = "sessionsDTO")
    MovieDTO toDTO(Movie movie);

    @InheritInverseConfiguration
    Movie toEntity(MovieDTO movie);

}
