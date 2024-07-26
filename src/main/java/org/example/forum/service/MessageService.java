package org.example.forum.service;

import org.example.forum.dao.MessageRepository;
import org.example.forum.dao.ResponseRepository;
import org.example.forum.dao.UserRepository;
import org.example.forum.entity.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    MessageRepository messageRepository;
    UserRepository userRepository;
    ResponseRepository responseRepository;

    public MessageService(MessageRepository messageRepository, UserRepository userRepository,
                                                        ResponseRepository responseRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
        this.responseRepository = responseRepository;
    }

    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
    public String deleteMessage() {
        messageRepository.delete(new Message());
        return "Message deleted";
    }

}
