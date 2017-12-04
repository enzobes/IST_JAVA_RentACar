package com.ist.RentACar.loader;

import com.ist.RentACar.model.Voiture;
import com.ist.RentACar.repository.VoitureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Dataloader implements CommandLineRunner{
    private final Logger logger = LoggerFactory.getLogger(Dataloader.class);

    private VoitureRepository repository;

    public Dataloader(VoitureRepository repository) {
        this.repository=repository;
    }

    @Override
    public void run(String... strings)throws Exception {

        logger.info("Chargement des données...");

        repository.save(new Voiture("04AH91", "Renault"));
        repository.save(new Voiture("34GA36", "Audi"));
        repository.save(new Voiture("53KN74", "Mercedes"));
        repository.save(new Voiture("48NA01", "Fiat"));
        repository.save(new Voiture("62AD49", "Citroën"));
        repository.save(new Voiture("82HG30", "Mercedes"));
    }


}
