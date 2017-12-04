package com.ist.RentACar.service;

import com.ist.RentACar.model.Person;
import com.ist.RentACar.model.Rent;
import com.ist.RentACar.model.Voiture;
import com.ist.RentACar.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RentServiceImpl implements RentService {
    @Autowired
    RentRepository repoR;
    @Autowired
    VoitureService voitureService;
    @Autowired
    PersonService personService;

    @Override
    public List<Rent> findAll() {
        return (List<Rent>) repoR.findAll();
    }

    @Override
    public void saveRent(Voiture v, Person p) {
        Voiture voiture = voitureService.findByPlaque(v.getPlateNumber());
        Person person = personService.findByNames(p.getFirstName(), p.getLastName());
        Rent r = new Rent();
        r.setVoiture(voiture);
        r.setClient(person);
        repoR.save(r);
        voiture.addRent(r);
        voitureService.saveVoiture(v);

        // TODO: problème lors de l'ajout de la loc à une personne
        //person.addRent(r);
        //personService.savePerson(p);
    }

    @Override
    public Rent findOne(long id) {
        return repoR.findOne(id);
    }

    @Override
    public void delete(long id) {
        repoR.delete(id);
    }
}
