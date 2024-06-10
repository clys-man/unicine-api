package edu.unifor.unicine.core.model.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = RoomDTO.class)
public class RoomDTO implements Serializable {
    private Long id;

    private int number;
    private int capacity;
    private String type;
    private String location;

    @JsonProperty("sessions")
    private List<SessionDTO> sessionsDTO;
    
    @JsonProperty("acents")
    private List<SessionDTO> acentsDTO;

}
