package com.hibernate.service;

import com.hibernate.dao.PersonalDataRepository;
import com.hibernate.domain.PersonalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PersonalDataService {

    @Autowired
    PersonalDataRepository personalDataRepository;

    public Set<PersonalData> getAllPersonalDataInDatabase(){
        Set<PersonalData> personalDataSet = new HashSet<>();
        personalDataRepository.findAll().forEach(personalDataSet::add);
        return personalDataSet;
    }

    public PersonalData getPersonalData(int id){
       return personalDataRepository.findOne(id);
    }

    public void addPersonalData(PersonalData personalData){
        personalDataRepository.save(personalData);
    }

    public void updatePersonalData(PersonalData personalData){
        personalDataRepository.save(personalData);
    }

    public void deletePersonalData(int id){
        personalDataRepository.delete(id);
    }
}
