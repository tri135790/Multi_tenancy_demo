package com.example.multi_tenancy_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.multi_tenancy_demo.entity.Book;

public interface BookRepository extends JpaRepository<Book,Long> {

    Book findByName(String name);

    void deleteByName(String name);
}
