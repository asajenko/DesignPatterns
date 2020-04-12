package com.asajenko.patterns.immutable;

import java.util.List;
import java.util.stream.Collectors;

public final class ImmutableBicycle {

    private final String brand;
    private final String model;
    private final List<Wheel> wheels;

    public ImmutableBicycle(String brand, String model, List<Wheel> wheels) {
        this.brand = brand;
        this.model = model;
        this.wheels = wheels.stream().map(w -> new Wheel(w.getWheelSize())).collect(Collectors.toUnmodifiableList());
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public List<Wheel> getWheels() {
        return wheels.stream().map(w -> new Wheel(w.getWheelSize())).collect(Collectors.toUnmodifiableList());
    }
}
