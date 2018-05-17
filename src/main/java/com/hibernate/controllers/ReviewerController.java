package com.hibernate.controllers;

import com.hibernate.domain.Book;
import com.hibernate.domain.BookReviewer;
import com.hibernate.domain.Reviewer;
import com.hibernate.service.BookReviewerService;
import com.hibernate.service.BookService;
import com.hibernate.service.ReviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ReviewerController {
    @Autowired
    ReviewerService reviewerService;
    @Autowired
    BookService bookService;
    @Autowired
    BookReviewerService bookReviewerService;


    @RequestMapping(method = RequestMethod.GET, value = "/reviewers")
    public Set<Reviewer> getAll(){
        return reviewerService.getAllReviewers();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/reviewers/{id}")
    public Reviewer getReviewer(@PathVariable int id){
        return reviewerService.getReviewer(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/reviewers")
    public void addReviewer(@RequestBody Reviewer reviewer){
        reviewerService.addReviewer(reviewer);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/reviewers")
    public void updateReviewer(@RequestBody Reviewer reviewer){
        reviewerService.updateReviewer(reviewer);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/reviewers/{id}")
    public void deleteReviewer(@PathVariable int id){
        reviewerService.deleteReviewer(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/reviewers/{reviewerId}/book/{bookId}/{rate}")
    public void addRateToBook(@PathVariable int reviewerId, @PathVariable int bookId, @PathVariable int rate){
        Reviewer reviewer = reviewerService.getReviewer(reviewerId);
        Book book = bookService.getBook(bookId);

        BookReviewer bookReviewer = new BookReviewer();
        bookReviewer.setBook(book);
        bookReviewer.setReviewer(reviewer);
        bookReviewer.setRate(rate);

        bookReviewerService.addBookReviewer(bookReviewer);
    }


}
