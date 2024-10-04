package com.ashu.BookReviewApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashu.BookReviewApplication.model.Book;
import com.ashu.BookReviewApplication.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    private BookService bookService;

    @GetMapping
    public String listBooks(Model model){
        model.addAttribute("books",bookService.getAllBooks());
        return "book_list";
    }

    @GetMapping("/add")
    public String saveBook(@ModelAttribute Book book){
        bookService.saveBook(book);
        return "redirect:/books";
    }

}
