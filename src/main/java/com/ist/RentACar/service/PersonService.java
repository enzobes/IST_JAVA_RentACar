package com.ist.RentACar.service;

import com.ist.RentACar.model.Person;

import java.util.List;

public interface PersonService {
    public List<Person> findAll();
    public void savePerson(Person voiture);
    public Person findOne(long id);
    public void delete(long id);
}
