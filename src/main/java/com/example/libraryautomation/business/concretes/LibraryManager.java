package com.example.libraryautomation.business.concretes;

import com.example.libraryautomation.business.abstracts.LibraryService;
import com.example.libraryautomation.dataAccess.BookRepository;
import com.example.libraryautomation.dataAccess.LibraryRepository;
import com.example.libraryautomation.entity.Book;
import com.example.libraryautomation.entity.Library;
import com.example.libraryautomation.core.utilities.results.DataResult.DataResult;
import com.example.libraryautomation.core.utilities.results.DataResults.DataResults;
import com.example.libraryautomation.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryManager implements LibraryService {

    List<Book> books;
    Library library;
    Book book;
    LibraryRepository libraryRepository;
    BookRepository bookRepository;

    @Autowired
    public LibraryManager(LibraryRepository libraryRepository, BookRepository bookRepository){
        this.libraryRepository = libraryRepository;
        this.bookRepository = bookRepository;
    }

    // 11/07/22 Working
    @Override
    public Result add(Library library) {
        if(library != null) {
            libraryRepository.save(library);
            return new Result(true, "The signin transaction is completed");
        }
        return new Result(false, "The informations cannot be null");
    }

    @Override
    public void update(Library library) {
        libraryRepository.save(library);
    }

    @Override
    public Result delete(int libraryId) {
        if(libraryRepository.existsById(libraryId))
        {
            libraryRepository.deleteById(libraryId);
            return new Result(true, "The account deleted successfully");
        }
        else
        {
            return new Result(false, "The cannot delete be cuz it's not exists");
        }
    }

    @Override
    public DataResult<Library> getByName(String libraryName) {
        return new DataResult<>(libraryRepository.findLibraryByNameContaining(libraryName), true);
    }

    @Override
    public DataResults<Library> getAll() {
       return new DataResults<>(libraryRepository.findAll(), true);
    }


    @Override
    public Result addBook(int libraryId, int bookId) {
        if(libraryRepository.existsById(libraryId) && bookRepository.existsById(bookId)) {
            library = libraryRepository.getById(libraryId);
            books.add(bookRepository.getById(bookId));
            library.setBooks(books);
            libraryRepository.save(library);
            return new Result(true);
        }
            return new Result(false);
    }

    @Override
    public Result deleteBook(int libraryId, int bookId) {
        if(libraryRepository.existsById(bookId))
        {
            library = libraryRepository.getById(libraryId);
            book = library.getBooks().get(bookId);
            bookRepository.delete(book);
            return new Result(true, "The account deleted successfully");
        }
        else
        {
            return new Result(false, "The cannot delete be cuz it's not exists");
        }
    }

    @Override
    public DataResults<Book> getLibraryBooks(int libraryId) {
        library = libraryRepository.getById(libraryId);
        return new DataResults<Book>(library.getBooks(), true);
    }

    @Override
    public DataResult<Book> getLibraryBook(int libraryId, int bookId) {
        library = libraryRepository.getById(libraryId);
        book = library.getBooks().get(bookId);
        return new DataResult<>(book, true);
    }
}
