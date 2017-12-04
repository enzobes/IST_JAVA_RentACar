package com.ist.RentACar.model;


import javax.persistence.*;
import java.util.Collection;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    // private Collection<Rent> rents;

    protected Person() {};

    public Person(String firstName, String lastName) {
        this.firstName=firstName;
        this.lastName=lastName;
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
        rent.client = this;
    }
    */

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
