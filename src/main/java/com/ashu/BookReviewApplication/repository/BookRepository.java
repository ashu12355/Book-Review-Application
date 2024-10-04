package com.ashu.BookReviewApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashu.BookReviewApplication.model.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
    
}
