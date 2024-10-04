package com.ashu.BookReviewApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashu.BookReviewApplication.model.Review;
import com.ashu.BookReviewApplication.repository.ReviewRepository;

@Service
public class ReviewService {
    
    @Autowired
    private ReviewRepository reviewRepository;

    public void saveReview(Review review){
        reviewRepository.save(review);
    }
}
