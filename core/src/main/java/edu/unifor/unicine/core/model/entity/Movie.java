package edu.unifor.unicine.core.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String director;
    private String releaseDate;
    private int duration;
    private String rating;
    private String synopsis;
    private String language;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    private List<Session> sessions;

}
