package com.atom.hibernatebasics.relationship;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    /**
     * Cascading -
     * Lets take the example of employee and locker. Locker will not exist's without employee. If employee is deleted from DB then locker should also be deleted.
     * This can be achieved using cascade
     */
    @OneToOne(cascade = CascadeType.ALL)
    /**
     * If we do not use the @JoinColumn then the name which will be generated will be Employee_lockerid. referencedColumnName is optional it points to id column of Locker.
     */
    @JoinColumn(name = "locker_Id", referencedColumnName = "id")
    private Locker locker;


    /**
     * Employee can have many vehicles, the relationship is 1 - many
     */
    @OneToMany
    @JoinTable(name = "emp_veh", joinColumns = @JoinColumn(name="emp_id"),
            inverseJoinColumns = @JoinColumn(name = "veh_id"))
    private Set<Vehicle> vehicles = new HashSet<>();
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

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicle.setEmployee(this);
        this.vehicles.add(vehicle);
    }
}
