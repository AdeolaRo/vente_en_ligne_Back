package com.example.vente_en_ligne.dao;

import com.example.vente_en_ligne.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}