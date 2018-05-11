package com.hibernate.controllers;

import com.hibernate.domain.Author;
import com.hibernate.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @RequestMapping(method = RequestMethod.GET, value ="/authors")
    public Set<Author> getAuthors(){
        return authorService.getAllAuthors();
    }

    @RequestMapping(method = RequestMethod.GET, value ="/authors/{id}")
    public Author getAuthor(@PathVariable int id){
        return authorService.getAuthor(id);
    }

    @RequestMapping(method = RequestMethod.POST, value ="/authors")
    public void addAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
    }

    @RequestMapping(method = RequestMethod.PUT, value ="/authors")
    public void updateAuthor(@RequestBody Author author){
        authorService.updateAuthor(author);
    }

    @RequestMapping(method = RequestMethod.DELETE, value ="/authors/{id}")
    public void deleteAuthor(@PathVariable int id){
        authorService.deleteAuthor(id);
    }

}
