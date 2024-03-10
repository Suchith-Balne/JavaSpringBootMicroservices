package com.java.simplesocialmediaapp.restfulwebservices.repository;

import com.java.simplesocialmediaapp.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Integer> {
}
