package com.atom.hibernatebasics.inheritance.singleTable;


import jakarta.persistence.*;

@Entity
/**
 * All the child classes member variable will be columns of Vehicle.
 * DTYPE column will be added to discriminate between different child classes.
 * DTYPE holds by default the child classes name.
 */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
/**
 * Default column name of Discriminator is DTYPE and data type is string.
 * To change the name and of the discriminator column use @DiscriminatorColumn
 * To change the data type use the attribute discriminatorType
 */
@DiscriminatorColumn(name = "VEHICLE_TYPE", discriminatorType = DiscriminatorType.STRING)
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
