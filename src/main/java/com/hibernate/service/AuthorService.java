package com.hibernate.service;

import com.hibernate.dao.AuthorRepository;
import com.hibernate.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public Set<Author> getAllAuthors(){
        Set<Author> authors = new HashSet<>();
        authorRepository.findAll().forEach(authors::add);
        return authors;
    }
    public Author getAuthor(int id){
        return authorRepository.findOne(id);
    }
    public void addAuthor(Author author){
        authorRepository.save(author);
    }
    public void updateAuthor(Author author){
        authorRepository.save(author);
    }
    public void deleteAuthor(int id){
        authorRepository.delete(id);
    }
}
