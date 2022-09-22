package com.ute.javacore.Animal;

public class InheritMethodDemo {
    public static void main(String[] args) {
        Cat tom = new Cat("Tom", 3, 20);
        System.out.println("name:" + tom.getName());
        System.out.println("animalName:" + tom.getAnimalName());

        System.out.println("---------------");
        System.out.println("Age:" + tom.getAge());
        System.out.println("Height" + tom.getHeight());
    }
}
