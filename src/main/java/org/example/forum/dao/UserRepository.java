package org.example.forum.dao;

import org.example.forum.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface UserRepository extends JpaRepository<User, Long> {

    default User create(User user){
        String passwordEncoder = new BCryptPasswordEncoder().toString();
        user.getUsername();
        passwordEncoder = user.getPassword();
        user.setPassword(passwordEncoder);
        return user;
    }

}
