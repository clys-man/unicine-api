package edu.unifor.unicine.core.model.mapper;

import edu.unifor.unicine.core.model.dto.SessionDTO;
import edu.unifor.unicine.core.model.entity.Session;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SessionMapper {

    @Mapping(source = "room", target = "roomDTO")
    @Mapping(source = "movie", target = "movieDTO")
    SessionDTO toDTO(Session room);

    @InheritInverseConfiguration
    Session toEntity(SessionDTO movie);

}
