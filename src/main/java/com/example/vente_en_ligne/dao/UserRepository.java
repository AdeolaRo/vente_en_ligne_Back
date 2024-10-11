package com.example.vente_en_ligne.dao;

import com.example.vente_en_ligne.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

User findByEmail(String email);

}