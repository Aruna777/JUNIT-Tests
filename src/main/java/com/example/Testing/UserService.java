package com.example.Testing;

public class UserService{
    public User getUserById(int id) throws IllegalAccessException {
        if (id<=0) throw new IllegalAccessException("Error");
        return new User(id, "John Doe");
    }

}
