package edu.unifor.unicine.core.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;
    private double ticketPrice;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Room room;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "session")
    private List<Ticket> tickets;
}
