package com.asajenko.patterns;

import com.asajenko.patterns.builder.Bicycle;
import com.asajenko.patterns.builder.BicycleType;

public class App {

    public static void main(String[] args) {
        Bicycle cannondaleMTB = Bicycle.builder("Cannodnale")
                .model("FSI")
                .frontSuspension()
                .color("red")
                .type(BicycleType.MTB)
                .wheelSize(29)
                .noFrontDerailleur()
                .build();

        Bicycle cannondaleRoadBike = Bicycle.builder("Cannondale")
                .model("SystemSix")
                .type(BicycleType.ROAD)
                .color("black")
                .wheelSize(29)
                .build();

        Bicycle cannodaleFullSuspension = Bicycle.builder("Cannondale")
                .model("Scalpel")
                .fullSuspension()
                .noFrontDerailleur()
                .wheelSize(29)
                .color("black")
                .type(BicycleType.MTB)
                .build();

        System.out.println(cannondaleMTB);
        System.out.println(cannondaleRoadBike);
        System.out.println(cannodaleFullSuspension);
    }
}
