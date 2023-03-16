package com.atom.hibernatebasics.embed;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

//Revision date - 14/03/2023
@Embeddable
public class Address {
    private String street;

    /**
     * Two ways to change the column name
     * 1. @Column annotation. If we configure column name using this option all the enity using the Address class will have the same column name. What if we want to
     * change the column name as per the class usin the Address class. use the second option
     * 2. The enity embedding this class.
     */
    @Column(name = "pin_code")
    private String pincode;
    private String city;
    private String state;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
