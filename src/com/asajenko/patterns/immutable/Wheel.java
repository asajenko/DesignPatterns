package com.asajenko.patterns.immutable;

public class Wheel implements ImmutableWheel{

    private int wheelSize;

    public Wheel(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }
}
