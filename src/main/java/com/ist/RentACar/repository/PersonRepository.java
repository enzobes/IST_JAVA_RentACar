package com.ist.RentACar.repository;

import com.ist.RentACar.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findByFirstNameAndLastName(String firstName, String lastName);
}
