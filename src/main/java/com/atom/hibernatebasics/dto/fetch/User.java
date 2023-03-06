package com.atom.hibernatebasics.dto.fetch;

import jakarta.persistence.*;
import org.hibernate.annotations.GeneratorType;

import java.util.Date;

@Entity(name = "USER_INFO")
public class User {
    @Id
    /**
     * hibernate_sequence table is used by all the tables. One thing to notice is a value which is generated let say 1
     * used by Table A then no other table will be allocated with the value 1.
     */
    @GeneratedValue(strategy = GenerationType.AUTO)

    /**
     * A table is created for generating the primary key. This is normally mapped to one table
     */
    /*@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMP_SEQ")
    @SequenceGenerator(name = "EMP_SEQ", sequenceName = "EMP_SEQ", allocationSize = 100)*/
    private int id;
    private String name;
    private String address;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dob")
    private Date date;

    @Lob
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
