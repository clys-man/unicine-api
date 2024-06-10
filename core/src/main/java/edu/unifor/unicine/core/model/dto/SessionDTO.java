package edu.unifor.unicine.core.model.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = SessionDTO.class)
public class SessionDTO {

    private Long id;

    private LocalDateTime dateTime;
    private double ticketPrice;

    @JsonProperty("movie")
    @JsonBackReference
    private MovieDTO movieDTO;

    @JsonProperty("tickets")
    @JsonBackReference
    private List<TicketDTO> ticketsDTO;

    @JsonProperty("room")
    @JsonManagedReference
    private RoomDTO roomDTO;
}
