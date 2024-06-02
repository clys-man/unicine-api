package edu.unifor.unicine.core.model.mapper;

import edu.unifor.unicine.core.model.dto.RoomDTO;
import edu.unifor.unicine.core.model.entity.Room;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {SessionMapper.class})
public interface RoomMapper {

    @Mapping(source = "sessions", target = "sessionDTOS")
    @Mapping(source = "acents", target = "acentDTOS")
    RoomDTO toDTO(Room room);

    @InheritInverseConfiguration
    Room toEntity(RoomDTO room);

}
