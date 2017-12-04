package com.ist.RentACar.service;

import com.ist.RentACar.model.Voiture;
import com.ist.RentACar.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VoitureServiceImpl implements VoitureService{
    @Autowired
    private VoitureRepository repository;

    @Override
    public List<Voiture> findAll() {
        return (List<Voiture>) repository.findAll();
    }

    @Override
    public Voiture findByPlaque(String plaque) {
        return repository.findByPlateNumber(plaque);
    }

    @Override
    public void saveVoiture(Voiture voiture) {
        repository.save(voiture);
    }

    @Override
    public Voiture findOne(long id) {
        return repository.findOne(id);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }
}
