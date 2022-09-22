package com.ute.javacore;

public class ForLoopExample2 {
    public static void main(String[] args) {
        int total = 0;
        for (int value = 1; value <= 100; value++) {
            total = total + value;
        }
        System.out.println("Total = " + total);
    }
}
