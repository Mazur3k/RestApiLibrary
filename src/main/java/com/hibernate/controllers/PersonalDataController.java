package com.hibernate.controllers;

import com.hibernate.domain.Author;
import com.hibernate.domain.PersonalData;
import com.hibernate.service.AuthorService;
import com.hibernate.service.PersonalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class PersonalDataController {
    @Autowired
    AuthorService authorService;
    @Autowired
    PersonalDataService personalDataService;

    @RequestMapping(method = RequestMethod.GET, value = "/data")
    public Set<PersonalData> getAllData(){
        return personalDataService.getAllPersonalDataInDatabase();
    }
    @RequestMapping(method = RequestMethod.POST, value = "/author/{authorId}/data")
    public void addPersonalData(@RequestBody PersonalData personalData, @PathVariable int authorId){
        Author author = authorService.getAuthor(authorId);
        //set on personalData because its owner of relationship
        personalData.setAuthor(author);
        personalDataService.addPersonalData(personalData);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/author/{authorId}/data")
    public PersonalData getPersonalDataByAuthorId(@PathVariable int authorId){
        Author author = authorService.getAuthor(authorId);
        return author.getPersonalData();
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/author/{authorId}/data")
    public void deletePersonalData(@PathVariable int authorId){
        personalDataService.deletePersonalData(authorService.getAuthor(authorId).getPersonalData().getId());
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/author/{authorId}/data")
    public void updatePersonalData(@RequestBody PersonalData personalData, @PathVariable int authorId){
        personalData.setAuthor(authorService.getAuthor(authorId));
        personalDataService.updatePersonalData(personalData);
    }
}
