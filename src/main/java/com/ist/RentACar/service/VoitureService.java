package com.ist.RentACar.service;

import com.ist.RentACar.model.Client;
import com.ist.RentACar.model.Voiture;

import java.util.List;

public interface VoitureService {
    List<Voiture> findAll();

    Voiture findByPlaque(String plaque);

    void saveVoiture(Voiture voiture);

    Voiture findOne(long id);

    void delete(long id);

    void rentVoiture(long id, Client c);

    void retournerVoitue(long id);
}
