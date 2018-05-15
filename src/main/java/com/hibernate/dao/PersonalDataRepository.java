package com.hibernate.dao;

import com.hibernate.domain.PersonalData;
import org.springframework.data.repository.CrudRepository;

public interface PersonalDataRepository extends CrudRepository<PersonalData, Integer> {
}
