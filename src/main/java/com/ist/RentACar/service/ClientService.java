package com.ist.RentACar.service;

import com.ist.RentACar.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> findAll();

    Client findByNames(String firstName, String lastName);

    void saveClient(Client client);

    Client findOne(long id);

    void delete(long id);
}
