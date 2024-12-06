package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public boolean existsByUsernameAndPassword(String username, String password);

    public Optional<User> findByUsernameAndPassword(String username, String password);

    public boolean existsByUsername(String username);

    public Optional<User> findByUsername(String username);


    
}
