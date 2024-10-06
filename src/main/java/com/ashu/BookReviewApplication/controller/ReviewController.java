package com.ashu.BookReviewApplication.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ashu.BookReviewApplication.model.Review;
import com.ashu.BookReviewApplication.model.User;
import com.ashu.BookReviewApplication.service.BookService;
import com.ashu.BookReviewApplication.service.ReviewService;
import com.ashu.BookReviewApplication.service.UserService;
import java.security.Principal;

@Controller
@RequestMapping("/books/{bookId}/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String listReview(@PathVariable Long bookId, Model model) {
        List<Review> reviews = reviewService.findByBookId(bookId);
        model.addAttribute("reviews", reviews);
        return "review_list";  // Correct name for listing reviews
    }

    @GetMapping("/create")
    public String createReviewForm(@PathVariable Long bookId, Model model) {
        model.addAttribute("bookId", bookId);
        model.addAttribute("review", new Review());
        return "review_form";  // Correct name for the review creation form
    }

  @PostMapping
public String createReview(@PathVariable Long bookId, @ModelAttribute Review review, Principal principal) {
    UserDetails userDetails = userService.loadUserByUsername(principal.getName());
    User user = (User) userDetails; // Cast to your User model if necessary

    review.setBook(bookService.findBookById(bookId));
    review.setUser(user); // Set the user object instead of the username
    reviewService.saveReview(review);

    return "redirect:/books/" + bookId + "/reviews";
}


    @GetMapping("/edit/{reviewId}")
    public String editReviewForm(@PathVariable Long reviewId, Model model) {
        Review review = reviewService.findById(reviewId);
        model.addAttribute("review", review);
        return "review_form";  // Reusing review_form for editing reviews
    }

    @PostMapping("/edit/{reviewId}")
    public String editReview(@PathVariable Long reviewId, @ModelAttribute Review review) {
        review.setId(reviewId);
        reviewService.saveReview(review);
        return "redirect:/books/" + review.getBook().getId() + "/reviews";
    }

    @GetMapping("/delete/{reviewId}")
    public String deleteReview(@PathVariable Long reviewId) {
        Review review = reviewService.findById(reviewId);
        Long bookId = review.getBook().getId();
        reviewService.delete(reviewId);
        return "redirect:/books/" + bookId + "/reviews";
    }
}
