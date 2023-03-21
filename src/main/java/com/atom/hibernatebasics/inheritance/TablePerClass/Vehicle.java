package com.atom.hibernatebasics.inheritance.TablePerClass;

import jakarta.persistence.*;

@Entity
/**
 * All the child class will have its own table.
 * The member variable of vehicle class will be added as a column to the child class table.
 */
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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
