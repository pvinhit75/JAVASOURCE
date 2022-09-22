package com.ute.javacore.Animal;

public abstract class Animal {

    // The Name, for example, Tom Cat, Jerry Mouse.
    private String name;

    // Default constructor.
    public Animal() {
        // Assign the default value to 'name'.
        this.name = this.getAnimalName();
    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // This is an abstract method.
    // Returns the name of this animal.
    // The specific content of this method will be implemented in the subclass.
    public abstract String getAnimalName();
}

