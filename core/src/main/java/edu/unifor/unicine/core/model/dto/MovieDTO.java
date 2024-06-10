package edu.unifor.unicine.core.model.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = MovieDTO.class)
public class MovieDTO implements Serializable {
    private Long id;

    private String title;
    private String director;
    private String releaseDate;
    private int duration;
    private String rating;
    private String synopsis;
    private String language;

    @JsonProperty("sessions")
    private List<SessionDTO> sessionsDTO;
}
