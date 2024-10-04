package com.ashu.BookReviewApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String context;
    private int rating;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    
}

/*
Explanation:
@ManyToOne:

Relationship: This denotes a many-to-one relationship. In this case, many Reviews can be linked to one User and one Book.
A review is written by a user, and the review is about a specific book.

@JoinColumn(name = "user_id"):
Specifies the foreign key column user_id in the Review table, which links to the User entity (the user who wrote the review).

@JoinColumn(name = "book_id"):
Specifies the foreign key column book_id in the Review table, which links to the Book entity (the book being reviewed).
--------------------------------------------------------
Why It Matters:
These annotations define the ownership of the relationships, where the Review entity is related to both a User and a Book.
The Review table will store foreign keys (user_id and book_id) to connect each review to a user and a book.
In summary, each Review is linked to a single User (the author of the review) and a single Book (the subject of the review). */
