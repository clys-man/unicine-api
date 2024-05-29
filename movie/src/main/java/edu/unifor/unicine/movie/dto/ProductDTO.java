package edu.unifor.unicine.movie.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = ProductDTO.class)
public class ProductDTO implements Serializable {
    @NotNull(message = "Id is required")
    private String id;
    @NotNull(message = "Name is required")
    private String name;
    @NotNull(message = "Description is required")
    private String description;
    @NotNull(message = "Price is required")
    private BigDecimal price;
}
