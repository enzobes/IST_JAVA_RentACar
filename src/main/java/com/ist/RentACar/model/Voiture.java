package com.ist.RentACar.model;


import javax.persistence.*;
import java.util.Collection;

@Entity
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String plateNumber;
    private String marque;
    //private Collection<Rent> rents;

    protected Voiture() {
    }

    ;

    public Voiture(String plateNumber, String marque) {
        this.plateNumber = plateNumber;
        this.marque = marque;
    }

    /*
    @OneToMany
    public Collection<Rent> getRents() {
        return rents;
    }

    public void setRents(Collection<Rent> rents) {
        this.rents = rents;
    }


    public void addRent(Rent rent) {
        this.getRents().add(rent);
        rent.voiture = this;
    }

    */

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "id=" + id +
                ", plateNumber='" + plateNumber + '\'' +
                ", marque='" + marque + '\'' +
                '}';
    }
}
