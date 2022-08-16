package com.example.multi_tenancy_demo.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.multi_tenancy_demo.entity.Book;
import com.example.multi_tenancy_demo.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void save(Book book){
        bookRepository.save(book);
    }

    public List<Book> getAll() throws SQLException {
        return bookRepository.findAll();
    }

    public Book get(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public Book getByName(String name){
        return bookRepository.findByName(name);
    }

    public void delete(String name){
        bookRepository.deleteByName(name);
    }
}
