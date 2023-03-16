package com.atom.hibernatebasics.embed;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//Revision date - 14/03/2023
@Entity
public class Employee {

    @EmbeddedId
    @Id
    private CustomPrimaryKey id;

/*    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;*/

    private String name;
    private String phoneNumber;

    @Column(name = "dob")
    private Date dateOfBirth;

    /**
     * All the properties of Address class will be a column of Employee. No Address table will be created
     */
    @Embedded
    @AttributeOverride(name = "city", column = @Column(name = "override_city"))
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "office_street")),
            @AttributeOverride(name = "pincode", column = @Column(name = "office_pincode")),
            @AttributeOverride(name = "city", column = @Column(name = "office_city")),
            @AttributeOverride(name = "state", column = @Column(name = "office_state"))})
    private Address officeAddress;

    /**
     * It creates a seprate table name employee_otherAddresses and same the data. A foreign key is generated which mapped in employee table.
     * the new table name which is created is Employee_otherAddresses
     *
     * To change the name of the new table we can use @JOIN_TABLE
     */
    @ElementCollection
    @JoinTable(name="USER_ADDRESS")
    private Set<Address> otherAddresses = new HashSet<>();
    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }

    public CustomPrimaryKey getId() {
        return id;
    }

    public void setId(CustomPrimaryKey id) {
        this.id = id;
    }

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

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Set<Address> getOtherAddresses() {
        return otherAddresses;
    }

    public void setOtherAddresses(Set<Address> otherAddresses) {
        this.otherAddresses = otherAddresses;
    }
}
