package com.ashu.BookReviewApplication.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    
}

/*
Explanation:
@OneToMany(mappedBy = "book"):

Relationship: A one-to-many relationship where one Book can have many Reviews.
mappedBy = "book": The Review entity owns the relationship, and the book field in the Review entity contains the foreign key that links a review to a specific book.
--------------------------------------------------------
cascade = CascadeType.ALL:

Ensures that any operation (such as save, update, delete) performed on the Book entity will also cascade to its associated Review entities. For example, deleting a Book will delete all related Reviews.
--------------------------------------------------------
List<Review> reviews:

This holds a collection of all the reviews associated with a particular Book.
 */
