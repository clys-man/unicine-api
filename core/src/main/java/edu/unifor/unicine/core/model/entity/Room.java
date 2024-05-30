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
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;
    private int capacity;
    private String type;
    private String location;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
    private List<Session> sessions;
}
