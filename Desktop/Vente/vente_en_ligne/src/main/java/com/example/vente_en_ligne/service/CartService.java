package com.example.vente_en_ligne.service;

import com.example.vente_en_ligne.dao.CartRepository;
import com.example.vente_en_ligne.dao.ProductRepository;
import com.example.vente_en_ligne.dao.UserRepository;
import com.example.vente_en_ligne.model.Cart;
import com.example.vente_en_ligne.model.Product;
import com.example.vente_en_ligne.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    private CartRepository cartRepository;

    private ProductRepository productRepository;

    private UserRepository userRepository;

    // Ajouter un produit au panier

    public Cart addProductToCart(Long cartId, Long productId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        Optional<Product> product = productRepository.findById(productId);

        if (cart.isPresent() && product.isPresent()) {
            cart.get().getProducts().add(product.get());
            return cartRepository.save(cart.get());
        }
        return null;
    }

    // Récupérer un panier par utilisateur

    public Optional<Cart> getCartByUserId(Long userId) {
        return userRepository.findById(userId).map(User::getCart);
    }

    // Vider le panier

    public void clearCart(Long cartId) {
        cartRepository.findById(cartId).ifPresent(cart -> {
            cart.getProducts().clear();
            cartRepository.save(cart);
        });
    }
}