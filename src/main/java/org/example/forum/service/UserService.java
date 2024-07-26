package org.example.forum.service;

import org.example.forum.dao.MessageRepository;
import org.example.forum.dao.ResponseRepository;
import org.example.forum.dao.UserRepository;
import org.example.forum.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;
    MessageRepository messageRepository;
    ResponseRepository responseRepository;

    public UserService(UserRepository userRepository, MessageRepository messageRepository,
                                                    ResponseRepository responseRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
        this.responseRepository = responseRepository;
    }

    public User createUser(User user) {
        return userRepository.create(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
    public User updateUser(User user) {
        return userRepository.create(user);
    }

}
