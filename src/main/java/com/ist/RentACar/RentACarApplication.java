package com.ist.RentACar;

import com.ist.RentACar.model.Voiture;
import com.ist.RentACar.service.VoitureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentACarApplication {

    private static final Logger log = LoggerFactory.getLogger(RentACarApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(RentACarApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(VoitureRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Voiture("04AH91", "Renault"));
            repository.save(new Voiture("34GA36", "Audi"));
            repository.save(new Voiture("53KN74", "Mercedes"));
            repository.save(new Voiture("48NA01", "Fiat"));
            repository.save(new Voiture("62AD49", "Citroën"));
            repository.save(new Voiture("82HG30", "Mercedes"));

            // fetch all customers
            log.info("Voitures found with findAll():");
            log.info("-------------------------------");
            for (Voiture voiture : repository.findAll()) {
                log.info(voiture.toString());
            }
            log.info("");

            // fetch an individual voiture by ID
            Voiture voiture = repository.findOne(1L);
            log.info("Voiture found with findOne(1L):");
            log.info("--------------------------------");
            log.info(voiture.toString());
            log.info("");


            // fetch voitures by last marque
            log.info("Customer found with findByMarque('Mercedes'):");
            log.info("--------------------------------------------");
            for (Voiture bauer : repository.findByMarque("Mercedes")) {
                log.info(bauer.toString());
            }
            log.info("");

        };
    }
}
