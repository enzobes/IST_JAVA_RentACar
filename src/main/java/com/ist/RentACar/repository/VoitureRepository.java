package com.ist.RentACar.repository;

import com.ist.RentACar.model.Voiture;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VoitureRepository extends CrudRepository<Voiture, Long> {
    List<Voiture> findByPlateNumber(String plateNumber);
    List<Voiture> findByMarque(String marque);
}
