package com.example.libraryautomation.api.controller;

import com.example.libraryautomation.business.abstracts.BookService;
import com.example.libraryautomation.entity.Book;
import com.example.libraryautomation.core.utilities.results.DataResult.DataResult;
import com.example.libraryautomation.core.utilities.results.DataResults.DataResults;
import com.example.libraryautomation.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("book/")
public class BookController{

    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("addBook")
    public Result add(@RequestBody Book book) {
        return bookService.add(book);
    }

    @PutMapping("updatebook/{bookId}")
    public void update(@RequestBody Book book, @PathVariable int bookId) {
        bookService.update(book, bookId);
    }

    @PutMapping("deletebook/{bookId}")
    public Result delete(@PathVariable int bookId) {
        return bookService.delete(bookId);
    }

    @PutMapping("getbyname/{name}")
    public DataResult<Book> getBookByName(@PathVariable String name) {
        return bookService.getBookByName(name);
    }

    @GetMapping("getall")
    public DataResults<Book> getAllBook() {
        return bookService.getAllBook();
    }
}
