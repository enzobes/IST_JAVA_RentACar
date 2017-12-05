package com.ist.RentACar.model;


import javax.persistence.*;

@Entity
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String plateNumber;
    private String marque;
    @ManyToOne
    //@JoinColumn(name = "client_id")
    private Client client;

    public Voiture() {
    }

    public Voiture(String plateNumber, String marque) {
        this.plateNumber = plateNumber;
        this.marque = marque;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

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
                ", client='" + client.toString() + '\'' +
                '}';
    }
}
