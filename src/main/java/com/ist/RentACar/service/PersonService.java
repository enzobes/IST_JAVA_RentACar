package com.ist.RentACar.service;

import com.ist.RentACar.model.Person;

import java.util.List;

public interface PersonService {
    public List<Person> findAll();

    public Person findByNames(String firstName, String lastName);

    public void savePerson(Person person);
    public Person findOne(long id);
    public void delete(long id);
}
