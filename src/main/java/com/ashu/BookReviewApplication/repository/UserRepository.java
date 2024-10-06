package com.ashu.BookReviewApplication.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ashu.BookReviewApplication.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
