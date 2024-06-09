package edu.unifor.unicine.core.model.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = SaleDTO.class)
public class SaleDTO implements Serializable {
    private Long id;

    private String code;

    private LocalDateTime dateTime;
    private double totalPrice;

    @JsonProperty("tickets")
    @JsonManagedReference
    private List<TicketDTO> ticketsDTO;
}
