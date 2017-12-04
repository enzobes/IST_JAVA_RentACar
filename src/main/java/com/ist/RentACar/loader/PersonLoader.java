package com.ist.RentACar.loader;

import com.ist.RentACar.model.Person;
import com.ist.RentACar.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class PersonLoader implements CommandLineRunner{
    private final Logger logger = LoggerFactory.getLogger(PersonLoader.class);

    private PersonRepository repository;

    public PersonLoader(PersonRepository repository) {
        this.repository=repository;
    }

    @Override
    public void run(String... strings)throws Exception {

        logger.info("Chargement des données d'utilisateurs");

        repository.save(new Person("John", "Doe"));
        repository.save(new Person("Albert", "Einstein"));
        repository.save(new Person("Gerard", "Depardieu"));
        repository.save(new Person("Jacques", "Chirac"));
        repository.save(new Person("Elon", "Munsk"));
    }


}
