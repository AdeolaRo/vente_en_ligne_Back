package com.example.vente_en_ligne.service;

import com.example.vente_en_ligne.dao.UserRepository;
import com.example.vente_en_ligne.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public User getUserById(long id){
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers(){
       return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User updateUserById(Long id, User updatedUserData) {
        // Récupérer l'utilisateur existant par ID
        return userRepository.findById(id).map(user -> {
            // Mettre à jour les données de l'utilisateur
            user.setUsername(updatedUserData.getUsername());
            user.setEmail(updatedUserData.getEmail());
            // Sauvegarder l'utilisateur mis à jour
            return userRepository.save(user);
        }).orElse(null);  // Retourne null si l'utilisateur n'existe pas

    }

    // Rechercher un utilisateur par email
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

    // Vérification des rôles (client ou administrateur)
    public boolean isAdmin(User user) {
        return user.getRole().equalsIgnoreCase("ADMIN");
    }

    public boolean isUser(User user) {
        return user.getRole().equalsIgnoreCase("USER");
    }

    // Login utilisateur
    public User loginUser(String email, String password) {
        Optional<User> user = findByEmail(email);
        return user.orElse(null);
    }
}

