package com.ute.javacore.IO;

import java.util.Scanner;

public class Calculation {
    public static void main(String[] args) {
        int a, b, c;

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập a: ");
        a = sc.nextInt();

        System.out.print("Nhập b: ");
        b = sc.nextInt();

        System.out.print("Nhập c: ");
        c = sc.nextInt();
        System.out.println("a = " + a + ", b = " + b + ", c = " + c );
    }
}
