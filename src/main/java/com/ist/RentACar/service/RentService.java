package com.ist.RentACar.service;

import com.ist.RentACar.model.Person;
import com.ist.RentACar.model.Rent;
import com.ist.RentACar.model.Voiture;

import java.util.List;

public interface RentService {
    public List<Rent> findAll();

    public void saveRent(Voiture v, Person p);

    public Rent findOne(long id);

    public void delete(long id);
}
