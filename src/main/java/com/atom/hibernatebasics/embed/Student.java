package com.atom.hibernatebasics.embed;

import jakarta.persistence.*;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.id.IdentifierGenerator;

import java.util.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String phoneNumber;

    @Column(name = "dob")
    private Date dateOfBirth;

    /**
     * It creates a seprate table name employee_otherAddresses and same the data. A foreign key is generated which mapped in student table.
     * the new table name which is created is Student_otherAddresses
     *
     * To change the name of the new table we can use @JOIN_TABLE
     *
     * To change the name of the FK use joinColumns = @JoinColumn(name = "student_id")
     */
    @ElementCollection
    @JoinTable(name="STUDENT_ADDRESSES", joinColumns = @JoinColumn(name = "student_id"))
    @GenericGenerator(name = "my-hilo", strategy = "hilo")
//    @CollectionId(column = @Column(name="ADDRESS_ID"), generator = "my-hilo", type=@Type(type="long"))
    private Collection<Address> otherAddresses = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    private Collection<Address> eagerFetchAddresses = new ArrayList<>();
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Collection<Address> getOtherAddresses() {
        return otherAddresses;
    }

    public void setOtherAddresses(Collection<Address> otherAddresses) {
        this.otherAddresses = otherAddresses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Address> getEagerFetchAddresses() {
        return eagerFetchAddresses;
    }

    public void setEagerFetchAddresses(Collection<Address> eagerFetchAddresses) {
        this.eagerFetchAddresses = eagerFetchAddresses;
    }
}
