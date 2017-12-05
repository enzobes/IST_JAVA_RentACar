package com.ist.RentACar.repository;

import com.ist.RentACar.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
    Client findClientByFirstNameAndLastName(String firstName, String lastName);
}
