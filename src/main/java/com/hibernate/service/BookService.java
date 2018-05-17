package com.hibernate.service;

import com.hibernate.dao.BookRepository;
import com.hibernate.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Set<Book> getAllBooks(){
        Set<Book> books = new HashSet<Book>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    public Set<Book> getByAuthorId(int id){
        Set<Book> books = new HashSet<Book>();
        bookRepository.findByAuthorId(id).forEach(books::add);
        return books;
    }

    public Book getBook(int id){
        return bookRepository.findOne(id);
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void updateBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(int id){
        bookRepository.delete(id);
    }

}
