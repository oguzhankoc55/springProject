package com.project.springProject.controller;


import com.project.springProject.model.Book;
import com.project.springProject.service.BookService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class BookController {


    private final BookService bookService;

    public BookController( BookService bookService) {

        this.bookService = bookService;
    }
    @GetMapping("/")
    public String home(){

        return "Hello";
    }
    @GetMapping("/secured")
    public String secured(){

        return "Hello secured";
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> bookList = bookService.getAllBooks();
        return ResponseEntity.ok(bookList);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        return bookService.findById(id)
                .map(book -> new ResponseEntity<>(book, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody Book book,
                                           BindingResult bindingResult) {
        Optional<Book> currentBook = bookService.findById(id);

        HttpHeaders headers = new HttpHeaders();
        if (bindingResult.hasErrors() || (book == null)) {
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
        if (currentBook.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        bookService.update(book);
        return new ResponseEntity<>(book, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Long id) {
        Optional<Book> bookToDelete = bookService.findById(id);

        if (bookToDelete.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        bookService.delete(id);
        return new ResponseEntity<>(bookToDelete.get(), HttpStatus.NO_CONTENT);
    }

    @PostMapping("/create")
    public ResponseEntity<Book> saveBook(@RequestBody  Book book, BindingResult bindingResult,
                                         UriComponentsBuilder uriComponentsBuilder) {

        HttpHeaders headers = new HttpHeaders();
        if (bindingResult.hasErrors() || (book == null)) {

            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }

        bookService.save(book);
        headers.setLocation(uriComponentsBuilder.path("/books/{id}").buildAndExpand(book.getId()).toUri());
        return new ResponseEntity<>(book, headers, HttpStatus.CREATED);

    }












}
