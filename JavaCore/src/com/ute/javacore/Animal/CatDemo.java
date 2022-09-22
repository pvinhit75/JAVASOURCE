package com.ute.javacore.Animal;

import java.util.Random;

public class CatDemo {
    public static Animal getRandomAnimal() {
        int random = new Random().nextInt(2);
        Animal animal = null;
        if (random == 0) {
            animal = new Cat("Tom", 3, 20);
        } else {
            animal = new Mouse("Jerry", 5);
        }
        return animal;
    }
}
