package com.asajenko.patterns.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonExample {

    public void showSingleton() {
        Bicycle cannondale1 = new Bicycle("Cannondale");
        Bicycle cannondale2 = new Bicycle("Cannondale");

        System.out.println("Are the classes the same? " + (cannondale1 == cannondale2) +"\n");

        System.out.println("Cannondale1 brand: " + cannondale1.getBrand());
        System.out.println("Cannondale2 brand: " + cannondale2.getBrand());

        cannondale2.setBrand("Other bike");

        System.out.println("After change cannodnale2 brand:");
        System.out.println("Cannondale1 brand: " + cannondale1.getBrand());
        System.out.println("Cannondale2 brand: " + cannondale2.getBrand());

        System.out.println("---------------- SINGLETON EAGER EXAMPLES---------------- ");
        BicycleSingleton cannondaleSingleton1 = BicycleSingleton.getInstance();
        BicycleSingleton cannondaleSingleton2 = BicycleSingleton.getInstance();

        System.out.println("\nAre the singleton classes the same? "
                + (cannondaleSingleton1 == cannondaleSingleton2));
        System.out.println("Cannondale1 brand: " + cannondaleSingleton1.getBrand() + " and Cannondale2 brand: " + cannondaleSingleton2.getBrand());
        cannondaleSingleton2.setBrand("Cannondale");
        System.out.println("After change brand on cannondaleSingleton2:");
        System.out.println("Cannondale1 brand: " + cannondaleSingleton1.getBrand() + " and Cannondale2 brand: " + cannondaleSingleton2.getBrand() +"\n");

        System.out.println("---------------- SINGLETON REFLECTION EXAMPLE---------------- ");

        try {
            BicycleLazySingleton bicycle1 = BicycleLazySingleton.getInstance();
            Constructor<BicycleLazySingleton> constructor = BicycleLazySingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            BicycleLazySingleton bicycle2 = constructor.newInstance();
            System.out.println("After reflection: ");
            System.out.println("Are the singleton classes the same? "
                    + (bicycle1 == bicycle2));
        } catch(NoSuchMethodException ex) {
            System.out.println("No such method exception");
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e ) {
            System.out.println("Access exception");
        }

        System.out.println("---------------- SINGLETON SERIALIZATION EXAMPLE ---------------- ");
        try {
            BicycleSingleton notSerialized1 = BicycleSingleton.getInstance();
            ObjectOutput output = new ObjectOutputStream(new FileOutputStream("bicycle.ser"));
            output.writeObject(notSerialized1);
            output.close();

            ObjectInput input = new ObjectInputStream(new FileInputStream("bicycle.ser"));
            BicycleSingleton notBicycle2 = (BicycleSingleton) input.readObject();
            System.out.println("Are the singleton classes the same? " + (notSerialized1 == notBicycle2));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            BicycleLazySingleton serialized1 = BicycleLazySingleton.getInstance();
            ObjectOutput output = new ObjectOutputStream(new FileOutputStream("bicycle.ser"));
            output.writeObject(serialized1);
            output.close();

            ObjectInput input = new ObjectInputStream(new FileInputStream("bicycle.ser"));
            BicycleLazySingleton serialized2 = (BicycleLazySingleton) input.readObject();
            System.out.println("Protected from serialization? " + (serialized1 == serialized2));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("---------------- SINGLETON ENUM EXAMPLE ---------------- ");
        BicycleEnumSingleton instance1 = BicycleEnumSingleton.INSTANCE;
        BicycleEnumSingleton instance2 = BicycleEnumSingleton.INSTANCE;
        instance2.setBrand("Cannondale");
        System.out.println("Are the ENUM singleton the same? " + (instance1==instance2));
        System.out.println("Brand instance1: " + instance1.getBrand() + " Brand instance2: " +instance2.getBrand());
    }
}
