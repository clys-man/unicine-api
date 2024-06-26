package edu.unifor.unicine.core.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private LocalDateTime dateTime;
    private double ticketPrice;

    @ManyToOne
    private Sale sale;

    @ManyToOne
    private Acent acent;

    @ManyToOne
    private Session session;
}
