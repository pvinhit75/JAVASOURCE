package com.ute.javacore.IO;


import java.util.Scanner;

public class nextVaNextLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập gì đó: ");
        String a = sc.nextLine();
        System.out.println("Bạn vừa nhập: " + a);

        System.out.print("Nhập thêm gì đó: ");
        String b = sc.next();
        System.out.println("Bạn vừa nhập: " + b);
    }

}
