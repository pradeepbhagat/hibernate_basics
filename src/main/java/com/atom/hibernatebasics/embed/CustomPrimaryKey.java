package com.atom.hibernatebasics.embed;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CustomPrimaryKey implements Serializable {
    private int firstId;
    private int secondId;

    public int getFirstId() {
        return firstId;
    }

    public void setFirstId(int firstId) {
        this.firstId = firstId;
    }

    public int getSecondId() {
        return secondId;
    }

    public void setSecondId(int secondId) {
        this.secondId = secondId;
    }
}
