package com.ashu.BookReviewApplication.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
    
}

/*
Summary of Key Concepts
@OneToMany(mappedBy = "user", cascade = CascadeType.ALL):

Annotation: It establishes a one-to-many relationship between a User entity and a list of Review entities.
Relationship: One User can be linked to multiple Reviews, but each Review is linked to exactly one User.
--------------------------------------------------------
mappedBy: Specifies that the User is not the owner of the relationship. Instead, the Review entity has a field (user) that maintains the foreign key and owns the relationship.
--------------------------------------------------------
Cascade: CascadeType.ALL ensures that all persistence operations (like saving or deleting) on a User are automatically applied to its associated Reviews. This provides convenience when dealing with the parent-child structure.
--------------------------------------------------------
List<Review> reviews:
This defines a collection of Reviews that are associated with a User. It allows the User to have multiple Reviews, stored in a list structure.
Example: One user can write multiple reviews, and all those reviews are maintained in a list within the User entity.
-------------------------------------------------------
Review Entity Side:
The Review entity contains a @ManyToOne annotation, which refers to the User. This is the owning side of the relationship, responsible for maintaining the foreign key (usually called user_id in the database). 
  
 */