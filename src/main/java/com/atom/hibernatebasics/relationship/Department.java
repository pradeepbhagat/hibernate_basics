package com.atom.hibernatebasics.relationship;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The default behaviour of @OneToMany relationship creates a third table eg employee_department. If we do not want to create a third table
     * mappedBy attribute is used.
     * Employee table will have department_id as a column
     */
   @OneToMany(mappedBy = "department")
    private Set<Employee> employees = new HashSet<>();
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employee.setDepartment(this);
        this.employees.add(employee);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
