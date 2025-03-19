package com.nexign.orderService.service;

import com.nexign.orderService.dto.Product;
import com.nexign.orderService.repostitory.ProductEntityRepository;
import com.nexign.orderService.util.ProductEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductEntityRepository productRepository;
    private final ProductEntityMapper productMapper;

    @Autowired
    public ProductService(ProductEntityRepository productRepository, ProductEntityMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProduct)
                .toList();
    }

    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id)
                .map(productMapper::toProduct);
    }

    public Product createProduct(Product productDto) {
        productRepository.save(productMapper.toEntity(productDto));
        return productDto;
    }


    public boolean deleteProduct(Integer id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
