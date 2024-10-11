package com.example.vente_en_ligne.controller;

import com.example.vente_en_ligne.model.Favorite;
import com.example.vente_en_ligne.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    // Ajouter un produit aux favoris d'un utilisateur
    @PostMapping("/{userId}/add/{productId}")
    public Favorite addProductToFavorites(@PathVariable Long userId, @PathVariable Long productId) {
        return favoriteService.addProductToFavorites(userId, productId);
    }

    // Récupérer les favoris d'un utilisateur
    @GetMapping("/{userId}")
    public List<Favorite> getFavoritesByUserId(@PathVariable Long userId) {
        return favoriteService.getFavoritesByUserId(userId);
    }

    // Supprimer un produit des favoris
    @DeleteMapping("/remove/{favoriteId}")
    public void removeProductFromFavorites(@PathVariable Long favoriteId) {
        favoriteService.removeProductFromFavorites(favoriteId);
    }
}
