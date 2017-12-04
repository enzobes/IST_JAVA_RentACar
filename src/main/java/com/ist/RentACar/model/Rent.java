package com.ist.RentACar.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RENT")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @Column(name = "BEGIN_RENT")
    private Date beginRent;
    @Column(name = "END_RENT")
    private Date endRent;

    @ManyToOne(cascade=CascadeType.ALL)
    @ElementCollection(targetClass=Voiture.class)
    Voiture voiture;

    @ManyToOne(cascade=CascadeType.ALL)
    @ElementCollection(targetClass=Person.class)
    Person client;


    @Temporal(TemporalType.DATE)
    public Date getBeginRent() {
        return beginRent;
    }

    @Temporal(TemporalType.DATE)
    public Date getEndRent() {
        return endRent;
    }

    public void setBeginRent(Date date) {
        this.beginRent = date;
    }

    public void setEndRent(Date date) {
        this.endRent = date;
    }


    // @ManyToOne(cascade=CascadeType.ALL)
    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    // @ManyToOne(cascade=CascadeType.ALL)
    public Person getClient() {
        return client;
    }

    public void setClient(Person client) {
        this.client = client;
    }


}
