package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public boolean existsByUsernameAndPassword(String username, String password);

    public User findByUsernameAndPassword(String username, String password);

    public boolean existsByUsername(String username);
}
