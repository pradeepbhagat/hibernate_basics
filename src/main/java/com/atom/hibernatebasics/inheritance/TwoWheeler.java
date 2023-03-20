package com.atom.hibernatebasics.inheritance;

import jakarta.persistence.Entity;

/**
 * TwoWheeler table will not be created. Parent class, Vehicle will have two column frontTyrePressure and backTyrePressure.
 *
 * A new column will be added named DTYPE which will hold the class name i.e. TwoWheeler
 */
@Entity
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
