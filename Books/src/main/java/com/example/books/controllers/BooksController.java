package com.example.books.controllers;

import com.example.books.model.Book;
import com.example.books.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/")
public class BooksController {

    ArrayList <Book> books=new ArrayList<Book>();
    AuthorService authorService;

    public BooksController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping("book")
    public ArrayList<Book> getBooks2(){
        return books;
    }

    @PostMapping("book")
    public ArrayList<Book> addBook(@RequestBody Book book){
        books.add(book);
        return books;
    }

    @PutMapping("book/{index}")
    public ArrayList<Book> updateBook(@PathVariable Integer index, @RequestBody Book book){
        books.set(index,book);
        return books;
    }

    @DeleteMapping("book/{index}")
    public ArrayList<Book> deleteBook(@PathVariable Integer index){
        books.remove(index);
        return books;
    }



}
