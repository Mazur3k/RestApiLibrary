package com.hibernate.dao;

import com.hibernate.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface BookRepository extends CrudRepository<Book, Integer>{
    public Set<Book> findByAuthorId(int id);
}
