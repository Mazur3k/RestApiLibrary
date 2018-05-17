package com.hibernate.service;

import com.hibernate.dao.BookReviewerRepository;
import com.hibernate.domain.BookReviewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BookReviewerService {

    @Autowired
    BookReviewerRepository bookReviewerRepository;

    public Set<BookReviewer> getAllBookReviewers(){
        Set<BookReviewer> bookReviewerSet = new HashSet<>();
        bookReviewerRepository.findAll().forEach(bookReviewerSet::add);
        return bookReviewerSet;
    }
    public BookReviewer getBookReviewer(int id){
        return bookReviewerRepository.findOne(id);
    }
    public void addBookReviewer(BookReviewer bookReviewer){
        bookReviewerRepository.save(bookReviewer);
    }
    public void updateBookReviewer(BookReviewer bookReviewer){
        bookReviewerRepository.save(bookReviewer);
    }
    public void deleteBookReviewer(int id){
        bookReviewerRepository.delete(id);
    }
}
