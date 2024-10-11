package com.example.vente_en_ligne.service;

import com.example.vente_en_ligne.dao.FavoriteRepository;
import com.example.vente_en_ligne.dao.UserRepository;
import com.example.vente_en_ligne.model.Favorite;
import com.example.vente_en_ligne.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FavoriteService {

    private FavoriteRepository favoriteRepository;

    private UserRepository userRepository;

    // Ajouter un produit aux favoris

    public Favorite addProductToFavorites(Long userId, Long productId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            Favorite favorite = new Favorite();
            favorite.setUser(user.get());
            favorite.setProductId(productId);
            return favoriteRepository.save(favorite);
        }
        return null;
    }

    // Récupérer les produits favoris d'un utilisateur

    public List<Favorite> getFavoritesByUserId(Long userId) {
        return favoriteRepository.findAllByUserId(userId);
    }

    // Supprimer un produit des favoris

    public void removeProductFromFavorites(Long favoriteId) {
        favoriteRepository.deleteById(favoriteId);
    }
}