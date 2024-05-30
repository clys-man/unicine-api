package edu.unifor.unicine.core.model.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = SessionDTO.class)
public class SessionDTO {

    private Long id;

    private LocalDateTime dateTime;
    private double ticketPrice;

    @JsonProperty("movie")
    @JsonBackReference
    private MovieDTO movieDTO;

    @JsonProperty("room")
    @JsonManagedReference
    private RoomDTO roomDTO;
}
