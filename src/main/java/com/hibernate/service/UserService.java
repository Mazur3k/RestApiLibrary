package com.hibernate.service;

import com.hibernate.dao.UserRepository;
import com.hibernate.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public Set<User> getAllUsers(){
        Set<User> users = new HashSet<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
    public User getUser(int id){
        return userRepository.findOne(id);
    }
    public User getUserByEmailAddress(String email){
        return userRepository.findByEmail(email);
    }
    public User getUserByConfirmationToken(String confirmationToken){
        return userRepository.findByConfirmationToken(confirmationToken);
    }
    public void addUser(User user){
        userRepository.save(user);
    }
    public void updateUser(User user){
        userRepository.save(user);
    }
    public void deleteUser(int id){
        userRepository.delete(id);
    }

}
