package com.ashu.BookReviewApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashu.BookReviewApplication.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
    
}
