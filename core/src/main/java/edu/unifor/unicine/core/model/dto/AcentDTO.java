package edu.unifor.unicine.core.model.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = AcentDTO.class)
public class AcentDTO implements Serializable {
    private Long id;

    private int number;
    private String status;

    @JsonProperty("room")
    private RoomDTO roomDTO;

    @JsonProperty("tickets")
    private List<TicketDTO> ticketsDTO;
}
