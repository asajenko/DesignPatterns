package com.asajenko.patterns.singleton;

import java.io.Serializable;

public class BicycleSingleton implements Serializable {

    private static final long serialVersionUID = -437473874857938579L;

    private String brand = "Other bike";
    private static BicycleSingleton instance = new BicycleSingleton();

    private BicycleSingleton() {
    }

    public static BicycleSingleton getInstance() {
        return instance;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
