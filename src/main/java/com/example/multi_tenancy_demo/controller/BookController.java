package com.example.multi_tenancy_demo.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.multi_tenancy_demo.entity.Book;
import com.example.multi_tenancy_demo.service.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(value = "/")
    public ResponseEntity<?> save(@RequestBody Book book) {
        bookService.save(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Book>> getAll() throws SQLException {
        List<Book> cities = bookService.getAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> get(@PathVariable(value = "id") Long id) {
        Book book = bookService.get(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<Book> get(@PathVariable(value = "name") String name) {
        Book book = bookService.getByName(name);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{name}")
    public ResponseEntity<Book> delete(@PathVariable(value = "name") String name) {
        bookService.delete(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
