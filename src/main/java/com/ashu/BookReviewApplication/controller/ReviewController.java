package com.ashu.BookReviewApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashu.BookReviewApplication.model.Review;
import com.ashu.BookReviewApplication.service.ReviewService;


@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/add")
    public String addReview(Model model){
        model.addAttribute("review",new Review());
        return "review_form";
    }

    @PostMapping("/add")
    public String saveReview(@ModelAttribute Review review){
        reviewService.saveReview(review);
        return "redirect:/books";
    }
    
}
