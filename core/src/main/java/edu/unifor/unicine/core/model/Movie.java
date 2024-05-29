package edu.unifor.unicine.core.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie {
    private String title;
    private String director;
    private String genre;
    private int duration;
    private int year;
}
