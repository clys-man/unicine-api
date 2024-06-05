package edu.unifor.movieservice.external;

import edu.unifor.movieservice.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Session {

    private Long id;

    private LocalDateTime dateTime;
    private Double ticketPrice;

    private Movie movie;

//    private Room room;
}