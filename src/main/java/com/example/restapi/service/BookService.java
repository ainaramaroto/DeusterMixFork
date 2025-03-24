package com.example.restapi.service;

import com.example.restapi.model.Libro;
import com.example.restapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Libro> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Libro> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Libro createBook(Libro book) {
        return bookRepository.save(book);
    }

    public Libro updateBook(Long id, Libro bookDetails) {
        Optional<Libro> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Libro book = optionalBook.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            return bookRepository.save(book);
        } else {
            throw new RuntimeException("Book not found");
        }
    }

    public void deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new RuntimeException("Book not found with id: " + id);
        }
    }
}