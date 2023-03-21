package com.atom.hibernatebasics.inheritance.TablePerClass;

import jakarta.persistence.Entity;

/**
 * A new table will be created for TwoWheeler.
 * It will not have DTYPE column.
 * It will have extra column added from Vehicle, i.e. id and name.
 * @GeneratedValue of id will also work for TwoWheeler
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
