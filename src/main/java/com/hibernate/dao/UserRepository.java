package com.hibernate.dao;

import com.hibernate.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
    User findByConfirmationToken(String confirmationToken);
}
