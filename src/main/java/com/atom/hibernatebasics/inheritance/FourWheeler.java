package com.atom.hibernatebasics.inheritance;

import jakarta.persistence.Entity;

/**
 * FourWheeler table will not be created.
 * Vehicle table will have tyrePressure as a column.
 * DTYPE (DISCRIMINATOR) column will be created in Vehicle that will have FourWheeler as a value.
 */
@Entity
public class FourWheeler extends Vehicle{
    private int tyrePressure;

    public int getTyrePressure() {
        return tyrePressure;
    }

    public void setTyrePressure(int tyrePressure) {
        this.tyrePressure = tyrePressure;
    }
}
