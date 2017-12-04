package com.ist.RentACar.repository;

import com.ist.RentACar.model.Rent;
import com.ist.RentACar.model.Voiture;
import org.springframework.data.repository.CrudRepository;

public interface RentRepository extends CrudRepository<Rent, Long> {
}
