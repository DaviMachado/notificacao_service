package com.example.notificacao_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notificacao_service.domain.entity.ProductEntity;
import com.example.notificacao_service.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	

    @PostMapping
    public ProductEntity addProduct(@RequestBody ProductEntity product) {
        return productRepository.save(product);
    }

    @GetMapping("/{id}")
    public Optional<ProductEntity> getProduct(@PathVariable String id) {
        return productRepository.findById(id);
    }
    
    @GetMapping
    public List<ProductEntity> getAllProducts() {
        return (List<ProductEntity>) productRepository.findAll();
    }

    @PutMapping("/{id}")
    public ProductEntity updateProduct(@PathVariable String id, @RequestBody ProductEntity productDetails) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productRepository.deleteById(id);
    }

}
