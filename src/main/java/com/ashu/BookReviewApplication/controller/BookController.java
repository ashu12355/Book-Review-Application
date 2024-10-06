package com.ashu.BookReviewApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        model.addAttribute("books",bookService.findAllBooks());
        return "book_list";
    }

    @GetMapping("/create")
    public String createBook(Model model){
        model.addAttribute("book", new Book());
        return "book_form";
    }

    @PostMapping("/create")
    public String saveBook(@ModelAttribute Book book){
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id , Model model){
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        return "book_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }

}
