package com.example.vente_en_ligne.service;

import com.example.vente_en_ligne.dao.ProductRepository;
import com.example.vente_en_ligne.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setImageUrl(updatedProduct.getImageUrl());
            return productRepository.save(product);
        }
        return null;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

//    public void initProducts() {
//        if (productRepository.count() == 0) {
//            Product product1 = new Product("Laptop", "A high-performance laptop", 1200.00, "url_to_image_1");
//            Product product2 = new Product("Smartphone", "A cutting-edge smartphone", 800.00, "url_to_image_2");
//            Product product3 = new Product("Headphones", "Noise-cancelling headphones", 200.00, "url_to_image_3");
//            Product product4 = new Product("Camera", "High-definition camera", 500.00, "url_to_image_4");
//
//            productRepository.saveAll(List.of(product1, product2, product3, product4));
//        }
//    }
}
