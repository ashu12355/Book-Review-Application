package com.ashu.BookReviewApplication.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashu.BookReviewApplication.model.Book;
import com.ashu.BookReviewApplication.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    
    public void saveBook(Book book){
        bookRepository.save(book);
    }
}
