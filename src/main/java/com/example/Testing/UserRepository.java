package com.example.Testing;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(int id);
}
