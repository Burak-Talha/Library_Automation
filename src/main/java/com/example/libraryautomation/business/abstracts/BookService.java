package com.example.libraryautomation.business.abstracts;



import com.example.libraryautomation.core.utilities.results.DataResult.DataResult;
import com.example.libraryautomation.core.utilities.results.DataResults.DataResults;
import com.example.libraryautomation.core.utilities.results.Result;
import com.example.libraryautomation.entity.Book;

public interface BookService {
    Result add(Book book);
    void update(Book book, int bookId);
    Result delete(int bookId);
    DataResult<Book> getBookByName(String name);
    DataResults<Book> getAllBook();
}
