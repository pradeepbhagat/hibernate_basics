package com.atom.hibernatebasics.relationship;

import jakarta.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    /**
     * Many vehicles can have one Employee, i.e. the relationship is many - 1
     * It will create a column in the vehicle table and will hold the employee id.
     */
    @ManyToOne
//    @JoinColumn(name = "emp_id")
//        @JoinTable(name = "emp_veh", joinColumns = @JoinColumn(name="employee_id"),
//            inverseJoinColumns = @JoinColumn(name = "veh_id"))
    private Employee employee;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
