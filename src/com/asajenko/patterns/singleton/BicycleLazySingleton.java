package com.asajenko.patterns.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class BicycleLazySingleton implements Serializable {

    private static final long serialVersionUID = -47246287364872364L;
    private static volatile BicycleLazySingleton instance;

    private BicycleLazySingleton() {
//        Uncomment this block to see how to protect from reflection
//        throw new IllegalStateException("Cannot create new instance. This class is Singleton, try use getInstance()");
    }

    public static BicycleLazySingleton getInstance() {
        if (instance == null)
            synchronized (BicycleLazySingleton.class) {
                if (instance == null) {
                    instance = new BicycleLazySingleton();
                }
            }
        return instance;
    }

    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }

    @Override
    protected BicycleLazySingleton clone() throws CloneNotSupportedException {
        return getInstance();
    }
}
