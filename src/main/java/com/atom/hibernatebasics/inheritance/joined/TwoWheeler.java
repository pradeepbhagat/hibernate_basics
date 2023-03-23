package com.atom.hibernatebasics.inheritance.joined;

import jakarta.persistence.Entity;

/**
 * TwoWheeler is inherited from vehicle.
 * twoWheeler.setName() when used will fill the value in Vehicle table instead of TwoWheeler table.
 *
 * select * from vehicle join TwoWheeler on Vehicle.id = TwoWheeler.id;
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
