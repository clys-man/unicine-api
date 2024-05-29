package edu.unifor.unicine.movie.controller;

import edu.unifor.unicine.movie.dto.ProductDTO;
import edu.unifor.unicine.movie.mapper.ProductMapper;
import edu.unifor.unicine.movie.model.Product;
import edu.unifor.unicine.movie.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @Transactional
    @PostMapping
    public ResponseEntity<ProductDTO> create(@Valid @RequestBody ProductDTO request) {
        Product user = productMapper.toEntity(request);
        Product savedProduct = productService.save(user);
        ProductDTO savedUserDTO = productMapper.toDTO(savedProduct);

        return new ResponseEntity<>(savedUserDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> list(Pageable pageable) {
        Page<Product> products = productService.listAll(pageable);
        Page<ProductDTO> productDTOS = products.map(productMapper::toDTO);
        return ResponseEntity.ok(productDTOS);
    }
}
