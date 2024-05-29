package edu.unifor.unicine.movie.repository;

import edu.unifor.unicine.movie.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
