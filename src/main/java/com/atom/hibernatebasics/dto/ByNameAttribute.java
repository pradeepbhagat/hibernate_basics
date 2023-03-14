package com.atom.hibernatebasics.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//Revision date - 14/03/2023
@Entity(name = "USER_DETAILS") //Entity name will be changed to USER_DETAILS from ByNameAttribute
public class ByNameAttribute {
    @Id
    @Column(name = "USER_ID")
    private int prop1;

    @Column(name = "USER_NAME")
    private String prop2;

    @Column(name = "USER_AGE")
    private int prop3;

    public int getProp3() {
        return prop3;
    }

    public int getProp1() {
        return prop1;
    }

    public void setProp1(int prop1) {
        this.prop1 = prop1;
    }

    public String getProp2() {
        return prop2+" value is set from getter always";
    }

    public void setProp2(String prop2) {
        this.prop2 = prop2;
    }

    public void setProp3(int prop3) {
        this.prop3 = prop3;
    }
}
