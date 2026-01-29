package com.p2p.server.p2p_backend.service;

import com.p2p.server.p2p_backend.model.User;
import com.p2p.server.p2p_backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.time.Instant;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(User user) throws Exception {
        // Set UTC timestamp as ISO 8601 string for Firestore
        String utcTimestamp = Instant.now().toString();
        user.setCreatedAt(utcTimestamp);
        
        return repository.createUser(user);
    }
}