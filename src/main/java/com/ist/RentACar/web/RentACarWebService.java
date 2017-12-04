package com.ist.RentACar.web;


import com.ist.RentACar.model.Person;
import com.ist.RentACar.model.User;
import com.ist.RentACar.model.Voiture;
import com.ist.RentACar.repository.VoitureRepository;
import com.ist.RentACar.service.VoitureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class RentACarWebService {

    private static final Logger log = LoggerFactory.getLogger(RentACarWebService.class);

    @Autowired
    private VoitureService voitureService;

    // La voiture créée a pour paramètre l'objet json envoyé avec la requete
    @RequestMapping(value = "/voiture", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void creerVoiture(@RequestBody Voiture v) {
        System.out.println("POST voiture");
        this.voitureService.saveVoiture(v);
    }

    // Renvoie la voiture associée à l'id
    @RequestMapping(value = "/voiture/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Voiture obtenirUneVoiture(@PathVariable(value = "id") long id) {
        return this.voitureService.findOne(id);
    }

    // Renvoie la liste des voitures
    @RequestMapping(value = "/voiture", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Voiture> listeDeVoitures() {
        // TODO

        return this.voitureService.findAll();
    }

    // Loue la voiture dont l'id est dans l'url et lui associe le client
    // envoyé dans le body de la requête
    @RequestMapping(value = "/louer/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void louerUneVoiture(@PathVariable("id") int id, @RequestBody Person p) {
        // TODO
    }

    // Retourner la voiture après une location
    @RequestMapping(value = "/retourner/{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void retournerVoiture(@PathVariable("id") int id) {
    // TODO
    }


    // Suppression d'une voiture du garage
    @RequestMapping(value = "/voiture/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteCar(@PathVariable int id) {
        // TODO
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity response(@RequestBody User u) {
        System.out.println(u.toString());
        if (Objects.equals(u.getLogin(), "admin") && Objects.equals(u.getPassword(), "admin")) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }
}
