package com.atom.hibernatebasics.inheritance.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Bike")
public class TwoWheeler extends Vehicle{
    private int frontTyrePressure;
    private int backTyrePressure;

    public int getFrontTyrePressure() {
        return frontTyrePressure;
    }

    public void setFrontTyrePressure(int frontTyrePressure) {
        this.frontTyrePressure = frontTyrePressure;
    }

    public int getBackTyrePressure() {
        return backTyrePressure;
    }

    public void setBackTyrePressure(int backTyrePressure) {
        this.backTyrePressure = backTyrePressure;
    }
}
