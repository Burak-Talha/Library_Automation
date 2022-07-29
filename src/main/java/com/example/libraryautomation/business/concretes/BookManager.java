package com.example.libraryautomation.business.concretes;

import com.example.libraryautomation.business.abstracts.BookService;
import com.example.libraryautomation.core.utilities.results.DataResult.DataResult;
import com.example.libraryautomation.core.utilities.results.DataResults.DataResults;
import com.example.libraryautomation.core.utilities.results.Result;
import com.example.libraryautomation.dataAccess.BookRepository;
import com.example.libraryautomation.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookManager implements BookService {

    BookRepository bookRepository;
    Book book;
    @Autowired
    public BookManager(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Working 11/07/22
    @Override
    public Result add(Book book) {
        if(book != null) {
            bookRepository.save(book);
            return new Result(true, "The signin transaction is completed");
        }
            return new Result(false, "The informations cannot be null");
    }

    // In test
    @Override
    public void update(Book newBook, int bookId) {

    }


    // Working 11/07/22
    @Override
    public Result delete(int bookId) {
        if(bookRepository.existsById(bookId))
        {
            bookRepository.deleteById(bookId);
            return new Result(true, "The account deleted successfully");
        }
        else
        {
        return new Result(false, "The cannot delete be cuz it's not exists");
        }
    }

    // Working 11/07/22
    @Override
    public DataResult<Book> getBookByName(String name) {
        return new DataResult<Book>(bookRepository.getBookByNameContaining(name), true);
    }

    // Working 11/07/22
    @Override
    public DataResults<Book> getAllBook() {
        return new DataResults<>(bookRepository.findAll(), true);
    }
}
