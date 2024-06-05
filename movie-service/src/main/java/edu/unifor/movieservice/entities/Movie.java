package edu.unifor.movieservice.entities;

import edu.unifor.movieservice.external.Session;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Movie")
@Table(name = "movies")
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String director;
    private String releaseDate;
    private Integer duration;
    private String rating;
    private String synopsis;
    private String language;

    @Transient
    private List<Session> sessions;

}