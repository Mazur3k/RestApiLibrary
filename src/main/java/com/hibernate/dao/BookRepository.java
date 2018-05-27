package com.hibernate.dao;

import com.hibernate.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{
    Set<Book> findByAuthorId(int id);
}
