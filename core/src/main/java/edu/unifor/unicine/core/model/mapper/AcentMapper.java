package edu.unifor.unicine.core.model.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import edu.unifor.unicine.core.model.dto.AcentDTO;
import edu.unifor.unicine.core.model.entity.Acent;

@Mapper(componentModel = "spring", uses = {TicketMapper.class})
public interface AcentMapper {

    @Mapping(source = "room", target = "roomDTO")
    @Mapping(source = "tickets", target = "ticketsDTO")
    AcentDTO toDTO(Acent acent);

    @InheritInverseConfiguration
    Acent toEntity(AcentDTO acent);

}
