package com.asajenko.patterns.singleton;

public class BicycleBillPughSingleton {

    private BicycleBillPughSingleton() {
    }

    private static class InnerSingletonClass {
        private static final BicycleBillPughSingleton INSTANCE
                = new BicycleBillPughSingleton();
    }

    public static BicycleBillPughSingleton getInstance() {
        return InnerSingletonClass.INSTANCE;
    }
}
