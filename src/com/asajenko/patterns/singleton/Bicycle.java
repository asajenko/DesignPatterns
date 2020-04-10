package com.asajenko.patterns.singleton;

public class Bicycle {

    private String brand;

    public Bicycle(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
