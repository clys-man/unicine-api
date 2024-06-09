package edu.unifor.unicine.core.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Acent {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private int number;
	private String status; 
	
	@ManyToOne
	private Room room;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "acent")
	private List<Ticket> tickets;
}
