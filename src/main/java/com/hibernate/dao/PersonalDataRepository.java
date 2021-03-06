package com.hibernate.dao;

import com.hibernate.domain.PersonalData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDataRepository extends CrudRepository<PersonalData, Integer> {
}
