package edu.unifor.unicine.movie.mapper;

import edu.unifor.unicine.movie.dto.ProductDTO;
import edu.unifor.unicine.movie.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDTO(Product product);
    Product toEntity(ProductDTO productDTO);
}
