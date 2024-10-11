package com.example.vente_en_ligne.service;

import com.example.vente_en_ligne.dao.OrderRepository;
import com.example.vente_en_ligne.dao.UserRepository;
import com.example.vente_en_ligne.model.Order;
import com.example.vente_en_ligne.model.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderService {


    private OrderRepository orderRepository;

    private UserRepository userRepository;

    // Créer une nouvelle commande
    public Order createOrder(Long userId, Double total) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            Order order = new Order();
            order.setUser(user.get());
            order.setTotal(total);
            order.setOrderDate(new Date());
            return orderRepository.save(order);
        }
        return null;
    }

    // Récupérer toutes les commandes d'un utilisateur
    public Set<Order> getOrdersByUserId(Long userId) {
        return userRepository.findById(userId).map(User::getOrders).orElse(null);
    }

    // Récupérer une commande par ID
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }
}