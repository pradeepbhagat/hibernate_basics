package com.atom.hibernatebasics.hql;

import jakarta.persistence.*;

@Entity
/**
 * parameter binding can be done via index or name
 */
@NamedQuery(name="Employee.byId", query = "from Employee where id = ?1")
/**
 * parameter binding can be done via index or name
 */
@NamedNativeQuery(name = "Employee.byName", query = "SELECT * from Employee where name = ?1 ", resultClass = Employee.class)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    private String department;

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
