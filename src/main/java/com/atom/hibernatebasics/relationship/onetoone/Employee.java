package com.atom.hibernatebasics.relationship.onetoone;


import jakarta.persistence.*;

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
}
