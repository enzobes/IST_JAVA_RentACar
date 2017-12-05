package com.ist.RentACar.web;


import com.ist.RentACar.jms.*;
import com.ist.RentACar.model.Client;
import com.ist.RentACar.model.User;
import com.ist.RentACar.model.Voiture;
import com.ist.RentACar.service.VoitureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.jms.JMSException;
import java.util.List;
import java.util.Objects;

@Controller
public class RentACarWebService {

    private static final Logger log = LoggerFactory.getLogger(RentACarWebService.class);

    @Autowired
    private VoitureService voitureService; // TODO : replace by Producers

    @Autowired
    private PostVoitureProducer postVoitureProducer;
    @Autowired
    private GetVoitureProducer getVoitureProducer;
    @Autowired
    private LouerProducer louerProducer;
    @Autowired
    private RetournerProducer retournerProducer;
    @Autowired
    private DeleteProducer deleteProducer;


    // La voiture créée a pour paramètre l'objet json envoyé avec la requete
    @CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 4800L, allowCredentials = "false")
    @RequestMapping(value = "/voiture", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void creerVoiture(@RequestBody Voiture v) throws InterruptedException, JMSException {
        log.info("POST voiture: " + v.toString());
        this.postVoitureProducer.send(v);
        Thread.sleep(1000L);
    }

    // Renvoie la voiture associée à l'id
    @CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 4800L, allowCredentials = "false")
    @RequestMapping(value = "/voiture/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Voiture obtenirUneVoiture(@PathVariable(value = "id") long id) {
        log.info("GET /voiture/:id");
        //this.getVoitureProducer.send(id);
        return this.voitureService.findOne(id);
    }

    // Renvoie la liste des voitures
    @CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 4800L, allowCredentials = "false")
    @RequestMapping(value = "/voiture", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Voiture> listeDeVoitures() {
        log.info("GET /voiture");
        return this.voitureService.findAll();
    }

    // Loue la voiture dont l'id est dans l'url et lui associe le client
    // envoyé dans le body de la requête
    @CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 4800L, allowCredentials = "false")
    @RequestMapping(value = "/louer/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void louerUneVoiture(@PathVariable("id") Long id, @RequestBody Client c) throws InterruptedException, JMSException {
        log.info("PUT /louer/:id");
        log.info(c.toString());
        // voitureService.rentVoiture(id, c);
        this.louerProducer.send(c, id);
        Thread.sleep(1000L);
    }

    // Retourner la voiture après une location
    @CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 4800L, allowCredentials = "false")
    @RequestMapping(value = "/retourner/{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void retournerVoiture(@PathVariable("id") Long id) throws InterruptedException, JMSException{
        log.info("POST /retourner/" + id.toString());
        this.retournerProducer.send(id);
        //voitureService.retournerVoitue(id);
        Thread.sleep(1000L);

    }


    // Suppression d'une voiture du garage
    @CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 4800L, allowCredentials = "false")
    @RequestMapping(value = "/voiture/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteCar(@PathVariable Long id) throws InterruptedException, JMSException{
        log.info("DELETE /voiture/:id");
        //voitureService.delete(id);
        deleteProducer.send(id);
        Thread.sleep(1000L);
    }

    @CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 4800L, allowCredentials = "false")
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
