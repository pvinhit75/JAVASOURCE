package com.ute.javacore.Animal;

public class Mouse extends Animal {
    private int weight;

    public Mouse(String jerry, int i) {
        this(100);
    }

    public Mouse(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String getAnimalName() {
        return null;
    }
}
