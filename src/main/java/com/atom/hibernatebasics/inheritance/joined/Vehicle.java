package com.atom.hibernatebasics.inheritance.joined;

import jakarta.persistence.*;

@Entity
/**
 * The value set for the child class for id and name will be filled in the Vehicle class instead of child class.
 * For example
 * TwoWheeler is a child class
 * twoWheeler.setName(..)// the value set over here will be directly filled in the vehicle table instead of twowheeler
 *
 */
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
