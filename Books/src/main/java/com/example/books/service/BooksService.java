package com.example.books.service;

import com.example.books.model.Author;
import com.example.books.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BooksService {

    private ArrayList<Book> books=new ArrayList<>();

    public ArrayList<Book> getBooks(){
        return books;
    }

    public void addAuthor(Book book) {
        books.add(book);
    }

    public boolean updateAuthor(Integer index, Book book) {
        if(index >= books.size()){
           return false;
        }
        books.set(index,book);
        return true;
    }

    public boolean deleteAuthor(Integer index) {
        if(index >= books.size()){
            return false;
        }
        books.remove(index);
        return true;
    }
}
