package com.ashu.BookReviewApplication.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ashu.BookReviewApplication.model.Book;
import com.ashu.BookReviewApplication.repository.BookRepository;
import com.ashu.BookReviewApplication.exception.ResourceNotFoundException;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public void saveBook(Book book) {
        if (book.getTitle() == null || book.getAuthor() == null) {
            throw new IllegalArgumentException("Book title and author cannot be null");
        }
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        Book book = findBookById(id);
        if (book == null) {
            throw new ResourceNotFoundException("Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
    }

    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
    }
}
