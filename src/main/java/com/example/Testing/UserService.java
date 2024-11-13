package com.example.Testing;

import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }
}
