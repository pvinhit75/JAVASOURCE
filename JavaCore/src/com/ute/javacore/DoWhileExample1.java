package com.ute.javacore;

public class DoWhileExample1 {
    public static void main(String[] args) {
        int value = 3;
        do {
            System.out.println("Value = " + value);
            value = value + 3;

        } while (value < 10);
    }
}
