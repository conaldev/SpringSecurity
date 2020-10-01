package com.minh.repository;

import com.minh.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<MyUser,Integer> {
    Optional<MyUser> findByEmail(String email);
}