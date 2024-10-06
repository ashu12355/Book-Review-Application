package com.ashu.BookReviewApplication.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashu.BookReviewApplication.exception.ResourceNotFoundException;
import com.ashu.BookReviewApplication.model.Review;
import com.ashu.BookReviewApplication.repository.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public void saveReview(Review review) {
        if (review.getContext() == null || review.getRating() < 1 || review.getRating() > 5) {
            throw new IllegalArgumentException("Review context cannot be null and rating must be between 1 and 5");
        }
        reviewRepository.save(review);
    }

    public void delete(Long reviewId) {
        Review review = findById(reviewId);
        if (review == null) {
            throw new ResourceNotFoundException("Review not found with id: " + reviewId);
        }
        reviewRepository.deleteById(reviewId);
    }

    public Review findById(Long reviewId) {
        return reviewRepository.findById(reviewId).orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + reviewId));
    }

    public List<Review> findByBookId(Long bookId) {
        return reviewRepository.findByBookId(bookId);
    }
}
