package com.asajenko.patterns.immutable;

import java.util.Arrays;
import java.util.List;

public class ImmutableExample {

    public void showImmutable() {
        String myBike = "Cannondale";
        System.out.println("My bike hashCode: " + myBike.hashCode());
        myBike += " Fsi";
        System.out.println("My bike hashCode after modification: " + myBike.hashCode());


        Wheel wheel1 = new Wheel(29);
        Wheel wheel2 = new Wheel(29);
        List<Wheel> wheels = Arrays.asList(wheel1, wheel2);
        ImmutableBicycle immutableBicycle = new ImmutableBicycle(
                "Cannondale",
                "FSI",
                wheels
        );

        try {
            wheels.add(new Wheel(123));
        } catch(UnsupportedOperationException ex) {
            System.out.println("You cannot add element to wheels list");
        }

        wheel1.setWheelSize(321);
        System.out.println("wheel in bike not change value: " + immutableBicycle.getWheels().get(0).getWheelSize());

        try {
            immutableBicycle.getWheels().add(new Wheel(999));
        } catch(UnsupportedOperationException ex) {
            System.out.println("You cannot add element to wheels list from immutableBicycle");
        }

        immutableBicycle.getWheels().get(0).setWheelSize(321);
        System.out.println("wheel in bike not change value: " + immutableBicycle.getWheels().get(0).getWheelSize());

        //Example for Immutable interface design pattern.
        Wheel wheel = new Wheel(29);
        wheel.setWheelSize(123);
        System.out.println("wheel size change value: " + wheel.getWheelSize());
        //Immutable wheel not have setter. It is Immutable interface design pattern.
        ImmutableWheel immutableWheel = new Wheel(29);
    }
}
