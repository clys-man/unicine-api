package edu.unifor.unicine.core.model.mapper;

import edu.unifor.unicine.core.model.dto.AcentDTO;
import edu.unifor.unicine.core.model.dto.TicketDTO;
import edu.unifor.unicine.core.model.entity.Acent;
import edu.unifor.unicine.core.model.entity.Ticket;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {SessionMapper.class, AcentMapper.class})
public interface TicketMapper {

    @Mapping(source = "acent", target = "acentDTO")
    @Mapping(source = "session", target = "sessionDTO")
    TicketDTO toDTO(Ticket ticket);

    @InheritInverseConfiguration
    Ticket toEntity(TicketDTO ticket);

}
