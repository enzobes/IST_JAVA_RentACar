package com.ist.RentACar.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RENT")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "BEGIN_RENT")
    private Date beginRent;
    @Column(name = "END_RENT")
    private Date endRent;
    /*
    @Column(name = "VOITURE")
    private
    Voiture voiture;
    @Column(name = "CLIENT")
    private
    Person client;
    */

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

    /*
    @ManyToOne
    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    @ManyToOne
    public Person getClient() {
        return client;
    }

    public void setClient(Person client) {
        this.client = client;
    }
    */

}
