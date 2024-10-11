package com.example.vente_en_ligne.dao;

import com.example.vente_en_ligne.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
