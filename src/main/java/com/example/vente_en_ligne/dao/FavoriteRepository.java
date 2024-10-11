package com.example.vente_en_ligne.dao;

import com.example.vente_en_ligne.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findAllByUserId(Long userId);
}
