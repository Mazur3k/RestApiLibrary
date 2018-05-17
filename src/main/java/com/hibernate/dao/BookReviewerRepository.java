package com.hibernate.dao;

import com.hibernate.domain.BookReviewer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReviewerRepository extends CrudRepository<BookReviewer, Integer>{
}
