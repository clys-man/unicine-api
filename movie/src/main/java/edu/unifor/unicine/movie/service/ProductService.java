package edu.unifor.unicine.movie.service;

import edu.unifor.unicine.movie.model.Product;
import edu.unifor.unicine.movie.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Page<Product> listAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
