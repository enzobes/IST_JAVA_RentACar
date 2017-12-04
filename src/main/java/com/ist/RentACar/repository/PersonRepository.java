package com.ist.RentACar.repository;

import com.ist.RentACar.model.Person;
import com.ist.RentACar.model.Voiture;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
