package com.ist.RentACar.service;

import com.ist.RentACar.model.Client;
import com.ist.RentACar.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository repository;

    @Override
    public List<Client> findAll() {
        return (List<Client>) repository.findAll();
    }

    @Override
    public Client findByNames(String firstName, String lastName) {
        return repository.findClientByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public void saveClient(Client client) {
        repository.save(client);
    }

    @Override
    public Client findOne(long id) {
        return repository.findOne(id);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }
}
