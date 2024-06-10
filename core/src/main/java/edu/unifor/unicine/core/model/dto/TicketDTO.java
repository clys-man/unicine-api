package edu.unifor.unicine.core.model.dto;

import com.fasterxml.jackson.annotation.*;
import edu.unifor.unicine.core.model.entity.Acent;
import edu.unifor.unicine.core.model.entity.Session;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = TicketDTO.class)
public class TicketDTO implements Serializable {
    private Long id;

    private String code;

    private LocalDateTime dateTime;
    private double ticketPrice;

    @JsonProperty("acent")
    private Acent acentDTO;

    @JsonProperty("session")
    private Session sessionDTO;

    @JsonProperty("sale")
    private SaleDTO saleDTO;
}
