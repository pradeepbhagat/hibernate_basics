package com.atom.hibernatebasics.relationship;


import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
     * Cascade type is of 4 types
     * PERSIST: CASCADE for save operation
     * REMOVE: CASCADE for delete operation
     * REFRESH:
     * DETACH:
     * ALL:
     */
    @OneToOne(cascade = CascadeType.ALL)
    /**
     * If we do not use the @JoinColumn then the name which will be generated will be Employee_lockerid. referencedColumnName is optional it points to id column of Locker.
     */
    @JoinColumn(name = "locker_Id", referencedColumnName = "id") //optional
    private Locker locker;


    /**
     * Employee can have many vehicles, the relationship is 1 - many
     * The below one to many implementation will create a table named emp_veh with column employee_id and veh_id
     *
     * WHAT IF WE DO NOT WANT TO HAVE A THIRD TABLE? REFER Project
     *
     */
    @OneToMany
    //optional
    @JoinTable(name = "emp_veh", joinColumns = @JoinColumn(name="employee_id"),
            inverseJoinColumns = @JoinColumn(name = "veh_id"))
    /**
     * If we do not set the vehicles hibernate will throw an exception. To ignore that exception @NotFound annotation is used.
     */
    @NotFound(action = NotFoundAction.IGNORE)
    private Set<Vehicle> vehicles = new HashSet<>();

    /**
     * Many employees in one department.
     * Default behaviour of @ManyToOne annotation is creation of a third table i.e. employee_department. If we do not want the third table.
     * Mapped by attribute is used.
     *
     * In the example below in the Department class mappedBy attribute is used for the employee list of the Department, find the snapshot below
     * @OneToMany(mappedBy = "department")
     *     private Set<Employee> employees = new HashSet<>();
     */
    @ManyToOne()
    @JoinColumn(name = "department_id") //optional
    private Department department;


    /**
     * Default behaviour of @ManyToMany is to create two table eg. for the below relationship employee_project table is created and project_employee table is created.
     * Instead of creating two tables we can have only table by using
     *@JoinTable(name = "emp_project", joinColumns = @JoinColumn(name = "emp_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
     *
     * mappedBy attribute can not be used in @ManyToMany
     */
    @ManyToMany
    @JoinTable(name = "emp_project", joinColumns = @JoinColumn(name = "emp_id"), inverseJoinColumns = @JoinColumn(name = "project_id")) //optional
    private Set<Project> projects = new HashSet<>();

    public Set<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }

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

    public Department getProject() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicle.setEmployee(this);
        this.vehicles.add(vehicle);
    }
}
