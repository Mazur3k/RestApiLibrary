package com.hibernate.service;

import com.hibernate.dao.ReviewerRepository;
import com.hibernate.domain.Reviewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ReviewerService {
    @Autowired
    ReviewerRepository reviewerRepository;

    public Set<Reviewer> getAllReviewers(){
        Set<Reviewer> reviewers = new HashSet<>();
        reviewerRepository.findAll().forEach(reviewers::add);
        return reviewers;
    }
    public Reviewer getReviewer(int id){
        return reviewerRepository.findOne(id);
    }
    public void addReviewer(Reviewer reviewer){
        reviewerRepository.save(reviewer);
    }
    public void updateReviewer(Reviewer reviewer){
        reviewerRepository.save(reviewer);
    }
    public void deleteReviewer(int id){
        reviewerRepository.delete(id);
    }


}
