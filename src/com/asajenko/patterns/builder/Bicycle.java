package com.asajenko.patterns.builder;

import java.util.List;

public class Bicycle {

    private String brand;
    private String model;
    private BicycleType type;
    private boolean frontSuspension;
    private boolean rearSuspension;
    private boolean frontDerailleur;
    private int wheelSize;
    private String color;

    private Bicycle(Builder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.type = builder.type;
        this.frontSuspension = builder.frontSuspension;
        this.rearSuspension = builder.rearSuspension;
        this.frontDerailleur = builder.frontDerailleur;
        this.wheelSize = builder.wheelSize;
        this.color = builder.color;
    }

    public static class Builder {

        private String brand;
        private String model;
        private BicycleType type;
        private boolean frontSuspension;
        private boolean rearSuspension;
        private boolean frontDerailleur = true;
        private int wheelSize;
        private String color;

        private Builder() {}

        private Builder (String brand) {
            this.brand = brand;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }
        public Builder type(BicycleType type) {
            this.type = type;
            return this;
        }
        public Builder frontSuspension() {
            this.frontSuspension = true;
            return this;
        }
        public Builder rearSuspension() {
            this.rearSuspension = true;
            return this;
        }
        public Builder fullSuspension() {
            this.frontSuspension = true;
            this.rearSuspension = true;
            return this;
        }
        public Builder noFrontDerailleur() {
            this.frontDerailleur = false;
            return this;
        }
        public Builder wheelSize(int wheelSize) {
            this.wheelSize = wheelSize;
            return this;
        }
        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Bicycle build() {
            if (!List.of(24,26,29).contains(this.wheelSize)) {
                throw new IllegalArgumentException("wheelSize must be 24, 26 or 29");
            }

            if (!List.of("red", "white", "black").contains(this.color)) {
                throw new IllegalArgumentException("color must be red, white or black");
            }

            return new Bicycle(this);
        }

    }

    public static Builder builder(String brand) {
        return new Builder(brand);
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", type=" + type +
                ", frontSuspension=" + frontSuspension +
                ", rearSuspension=" + rearSuspension +
                ", frontDerailleur=" + frontDerailleur +
                ", wheelSize=" + wheelSize +
                ", color='" + color + '\'' +
                '}';
    }
}