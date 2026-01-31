package com.fullstack.service;

import com.fullstack.entity.Product;
import com.fullstack.exception.RecordNotFoundException;
import com.fullstack.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product addProduct(Product product){

        return productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(long productId){
        return Optional.ofNullable(productRepository.findById(productId).orElseThrow(() -> new RecordNotFoundException("Product Not Available")));
    }
}
