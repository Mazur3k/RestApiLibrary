package com.hibernate.controllers;

import com.hibernate.domain.Author;
import com.hibernate.domain.Book;
import com.hibernate.service.AuthorService;
import com.hibernate.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    AuthorService authorService;

    @RequestMapping(method = RequestMethod.GET, value = "/authors/{authorId}/books")
    public Set<Book> getAllBooksByAuthorId(@PathVariable int authorId){
        return bookService.getByAuthorId(authorId);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/authors/{authorId}/books")
    public void bindBookToAuthor(@RequestBody Book book, @PathVariable int authorId){
        Author author = authorService.getAuthor(authorId);
        book.setAuthor(author);
        bookService.addBook(book);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/books")
    public Set<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/authors/{authorId}/books")
    public void updateBookData(@RequestBody Book book, @PathVariable int authorId){
        book.setAuthor(authorService.getAuthor(authorId));
        bookService.updateBook(book);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/authors/{authorId}/books/{bookId}")
    public void deleteBookById(@PathVariable int bookId){
        bookService.deleteBook(bookId);
    }


}
