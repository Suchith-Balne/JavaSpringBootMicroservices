package com.java.simplesocialmediaapp.restfulwebservices.repository;

import com.java.simplesocialmediaapp.restfulwebservices.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostJpaRepository extends JpaRepository<Post, Integer> {
}
