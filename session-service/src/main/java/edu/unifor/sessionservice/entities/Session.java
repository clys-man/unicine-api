package edu.unifor.sessionservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Session")
@Table(name = "sessions")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime dateTime;
    private double ticketPrice;

//    @ManyToOne
//    private Movie movie;
//
//    @ManyToOne
//    private Room room;
}
