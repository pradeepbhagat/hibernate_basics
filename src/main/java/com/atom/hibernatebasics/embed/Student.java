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
     * It creates a separate table name employee_otherAddresses and save the data.
     * A foreign key student_id is created in employee_otherAddress.
     *
     * To change the name of the new table we can use @JOIN_TABLE
     *
     * To change the name of the FK use joinColumns = @JoinColumn(name = "student_id")
     */
    @ElementCollection
    /**
     * The default table created by @ElementCollection is employee_otherAddresses
     * @JointTable(name="STUDENT_ADDERESSES") will change the name from  employee_otherAddresses to STUDENT_ADDERESSES
     * The default foreign key column name is student_id in the employee_otherAddresses.
     * To change the name of the foreign key column we use  joinColumns = @JoinColumn(name = "changed_student_id") of @JoinTable
     */
    @JoinTable(name="STUDENT_ADDRESSES", joinColumns = @JoinColumn(name = "changed_student_id"))
//    @GenericGenerator(name = "my-hilo", strategy = "hilo")
//    @CollectionId(column = @Column(name="ADDRESS_ID"), generator = "my-hilo", type=@Type(type="long"))
    private Collection<Address> otherAddresses = new ArrayList<>();

    /**
     * When we get the Student value the @ElementCollection is not retrieved until we call the method  getEagerFetchAddresses().
     * By default, the fetch type is LAZY.
     * To get the eagerFetchAddresses automatically when the student object is retrieved set the fetch type to EAGER.
     */
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
