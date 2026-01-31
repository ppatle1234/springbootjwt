package com.fullstack.controller;

import com.fullstack.entity.Product;
import com.fullstack.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("add-product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<Product>> findAll(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findbyid/{productId}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable long productId){
        return new ResponseEntity<>(productService.findById(productId), HttpStatus.OK);
    }

}
