package com.ist.RentACar.service;

import com.ist.RentACar.model.Voiture;

import java.util.List;

public interface VoitureService {
    public List<Voiture> findAll();

    public Voiture findByPlaque(String plaque);
    public void saveVoiture(Voiture voiture);
    public Voiture findOne(long id);
    public void delete(long id);
}
