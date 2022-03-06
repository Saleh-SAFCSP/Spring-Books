package com.example.books.controllers;

import com.example.books.model.Author;
import com.example.books.model.Book;
import com.example.books.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService=authorService;
    }


    @GetMapping("author")
    public ResponseEntity getAuthors(){
        return ResponseEntity.status(200).body(authorService.getAuthors());
    }

    @PostMapping("author")
    public ResponseEntity addAuthor(@RequestBody @Valid Author author, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError());
        }
        authorService.addAuthor(author);
        return ResponseEntity.status(201).body("Author created");
    }

    @PutMapping("author/{index}")
    public ResponseEntity updateAuthor(@PathVariable Integer index, @RequestBody Author author){

        boolean isAuthorUpdated=authorService.updateAuthor(index,author);
        if(!isAuthorUpdated){
            return ResponseEntity.status(400).body("Index is more than array length");
        } else {
            return ResponseEntity.status(200).body("Author updated");
        }
    }

    @DeleteMapping("author/{index}")
    public ResponseEntity deleteAuthor(@PathVariable Integer index){
        boolean isAuthorDeleted=authorService.deleteAuthor(index);

        if(!isAuthorDeleted){
            return ResponseEntity.status(400).body("Index is more than array length");
        } else {
            return ResponseEntity.status(200).body("Author deleted");
        }
    }



}
