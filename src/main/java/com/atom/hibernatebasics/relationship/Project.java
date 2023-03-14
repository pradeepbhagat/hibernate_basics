package com.atom.hibernatebasics.relationship;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    /**
     * Default behaviour of @ManyToMany is to create two table eg. for the below relationship employee_project table is created and project_employee table is created.
     * Instead of creating two tables we can have only table by using
     *@JoinTable(name = "emp_project", joinColumns = @JoinColumn(name = "emp_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
     *
     * mappedBy attribute can not be used in @ManyToMany
     */
    @ManyToMany
    private Set<Employee> employees = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Employee> getEmployee() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }
}
