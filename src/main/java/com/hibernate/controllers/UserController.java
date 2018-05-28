package com.hibernate.controllers;

import com.hibernate.domain.User;

import com.hibernate.service.Mailer;
import com.hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Set;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public Set<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    public User getUser(@PathVariable int id){
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addUser(@Valid @RequestBody User user, HttpServletRequest request){

        User userExist = userService.getUserByEmailAddress(user.getEmail());

        if(userExist != null){
            System.out.println("email address already in use");
        }
        else{
            user.setEnabled(false);
            user.setConfirmationToken(UUID.randomUUID().toString());
            userService.addUser(user);

            String appUrl = request.getScheme() + "://" + request.getServerName()+":"+request.getLocalPort();

            Mailer.send("restapitest2018@gmail.com","strongpassword",user.getEmail(),"Registration Confirmation","To confirm your e-mail address, please click the link below:\n"
                    + appUrl + "/confirm?token=" + user.getConfirmationToken());
        }
    }

    @RequestMapping(value="/confirm", method = RequestMethod.GET)
    public void getConfirmation(@RequestParam String token){
        User user = userService.getUserByConfirmationToken(token);
        if(user==null){
            System.out.println("Wrong token");
        }
        else{
            user.setEnabled(true);
            userService.updateUser(user);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }
}
