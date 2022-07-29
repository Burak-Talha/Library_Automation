package com.example.libraryautomation.business.abstracts;

import com.example.libraryautomation.entity.Book;
import com.example.libraryautomation.entity.Library;
import com.example.libraryautomation.core.utilities.results.DataResult.DataResult;
import com.example.libraryautomation.core.utilities.results.DataResults.DataResults;
import com.example.libraryautomation.core.utilities.results.Result;

public interface LibraryService {

     Result add(Library library);
     void update(Library library);
     Result delete(int libraryId);
     DataResult<Library> getByName(String libraryName);
     DataResults<Library> getAll();
     Result addBook(int libraryId, int bookId);
     Result deleteBook(int libraryId, int bookId);
     DataResults<Book> getLibraryBooks(int libraryId);
     DataResult<Book> getLibraryBook(int libraryId, int bookId);
}
