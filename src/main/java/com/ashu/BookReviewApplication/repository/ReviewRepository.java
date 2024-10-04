package com.ashu.BookReviewApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashu.BookReviewApplication.model.Review;

public interface ReviewRepository extends JpaRepository<Review,Long>{
    
}
