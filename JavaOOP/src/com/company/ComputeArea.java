package com.company;

import java.util.Scanner;

public class ComputeArea {
    public static void main(String[] args){
        double radius;
        double area;

        radius = 20;

        area = radius * radius * 3.14159;
        System.out.println("The area for the circle " + radius + " is " + area);

        System.out.println("Enter a double value: ");
        Scanner input = new Scanner(System.in);
        double d = input.nextDouble();
        final int SIZE = 3;

        final double PI = 3.14;
    }
}
