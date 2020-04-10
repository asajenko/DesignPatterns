package com.asajenko.patterns.singleton;

public enum BicycleEnumSingleton {

    INSTANCE;

    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
