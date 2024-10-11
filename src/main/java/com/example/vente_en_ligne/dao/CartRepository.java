package com.example.vente_en_ligne.dao;

import com.example.vente_en_ligne.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
