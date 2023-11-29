package com.project.springProject.service;

import com.project.springProject.model.Book;
import com.project.springProject.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> findBookById(Long id){
        return bookRepository.findById(id);
    }
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    public void save(Book book) {
        bookRepository.save(book);
    }
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
    public void update(Book book) {
        bookRepository.save(book);
    }
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
