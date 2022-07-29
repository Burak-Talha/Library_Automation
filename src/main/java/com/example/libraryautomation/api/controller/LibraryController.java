package com.example.libraryautomation.api.controller;

import com.example.libraryautomation.business.abstracts.LibraryService;
import com.example.libraryautomation.core.utilities.results.DataResult.DataResult;
import com.example.libraryautomation.core.utilities.results.DataResults.DataResults;
import com.example.libraryautomation.core.utilities.results.Result;
import com.example.libraryautomation.entity.Book;
import com.example.libraryautomation.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("library/")
public class LibraryController   {

    Library library;
    LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService service) {
        this.libraryService = service;
    }

    @PostMapping("addlibrary")
    public Result addLibrary(@RequestBody Library library){
        return libraryService.add(library);
    }

    @PostMapping("updatelibrary")
    public void updateLibrary(@RequestBody Library library){
        libraryService.update(library);
    }

    @PostMapping("deletelibrary/{libraryId}")
    public Result deleteLibrary(@PathVariable int libraryId){
       return libraryService.delete(libraryId);
    }

    @PutMapping("addBook/{book_id}/library/{library_id}")
    public Result addBookToLibrary(@PathVariable int library_id, @PathVariable int book_id){
        return libraryService.addBook(library_id, book_id);
    }

    @PutMapping("deletebook/{book_id}/library/{library_id}")
    public Result deleteBookFromLibrary(@PathVariable int library_id, @PathVariable int book_id){
        return libraryService.deleteBook(library_id, book_id);
    }

    @PutMapping("getlibrarybooks/{libraryId}")
    public DataResults<Book> getLibraryBooks(@PathVariable int libraryId){
        return libraryService.getLibraryBooks(libraryId);
    }

    @PutMapping("getlibrarybook/library/{libraryId}/book/{bookId}")
    public DataResult<Book> getLibraryBook(@PathVariable int libraryId, @PathVariable int bookId){
        return libraryService.getLibraryBook(libraryId, bookId);
    }

    @GetMapping("getall")
    public DataResults<Library> getAll(){
        return libraryService.getAll();
    }

    @GetMapping("getbyname/{name}")
    public DataResult<Library> getLibraryByName(@PathVariable String name){
        return libraryService.getByName(name);
    }
}
