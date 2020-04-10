package com.asajenko.patterns.builder;

public class BuilderExample {

    public void showBuilder() {
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

        Bicycle cannondaleRoadBike2 = Bicycle.builder("Cannondale")
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
