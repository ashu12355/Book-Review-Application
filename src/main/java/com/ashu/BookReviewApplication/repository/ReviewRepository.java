package com.ashu.BookReviewApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.ashu.BookReviewApplication.model.Review;

public interface ReviewRepository extends JpaRepository<Review,Long>{
    List<Review> findByBookId(Long bookId);
}
