package com.example.vente_en_ligne.controller;

import com.example.vente_en_ligne.model.Order;
import com.example.vente_en_ligne.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService; // Injection via le constructeur

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Créer une nouvelle commande
    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestParam Long userId, @RequestParam Double total) {
        Order order = orderService.createOrder(userId, total);
        if (order != null) {
            return ResponseEntity.ok(order);
        }
        return ResponseEntity.badRequest().build();
    }

    // Récupérer toutes les commandes d'un utilisateur
    @GetMapping("/user/{userId}")
    public ResponseEntity<Set<Order>> getOrdersByUserId(@PathVariable Long userId) {
        Set<Order> orders = orderService.getOrdersByUserId(userId);
        if (orders != null && !orders.isEmpty()) {
            return ResponseEntity.ok(orders);
        }
        return ResponseEntity.notFound().build();
    }

    // Récupérer une commande par ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Optional<Order> order = orderService.getOrderById(id);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
