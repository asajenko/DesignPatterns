package com.asajenko.patterns;

import com.asajenko.patterns.builder.Bicycle;
import com.asajenko.patterns.builder.BicycleType;
import com.asajenko.patterns.builder.BuilderExample;
import com.asajenko.patterns.singleton.SingletonExample;

public class App {

    public static void main(String[] args) {
        System.out.println("---------------- BUILDER EXAMPLES ---------------- ");
        new BuilderExample().showBuilder();
        System.out.println("---------------- SINGLETON EXAMPLES ---------------- ");
        new SingletonExample().showSingleton();
    }
}
