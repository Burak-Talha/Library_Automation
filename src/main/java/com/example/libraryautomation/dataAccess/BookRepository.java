package com.example.libraryautomation.dataAccess;

import com.example.libraryautomation.entity.Book;
import com.example.libraryautomation.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Integer> {

    public Book getBookByNameContaining(String name);
}
