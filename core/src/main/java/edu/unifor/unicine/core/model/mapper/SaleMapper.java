package edu.unifor.unicine.core.model.mapper;

import edu.unifor.unicine.core.model.dto.SaleDTO;
import edu.unifor.unicine.core.model.entity.Sale;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TicketMapper.class})
public interface SaleMapper {

    @Mapping(source = "tickets", target = "ticketsDTO")
    SaleDTO toDTO(Sale ticket);

    @InheritInverseConfiguration
    Sale toEntity(SaleDTO ticket);

}
