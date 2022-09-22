package com.ute.javacore;

public class ElseIfExample1 {

    public static void main(String[] args) {

//        int age = 35;
//        System.out.println("nhập tuổi: = " + age);
//
//        if (age < 18) {
//            System.out.println("Nguoi thieu nien");
//        } else if (age < 30) {
//            System.out.println("Nguoi truong thanh");
//        } else {
//            System.out.println("Nguoi trung nien");
//        }
        // hoc sinh gioi co diem > 8
        //  kha < 8 co diem toan > 9
        // hoc sinh Trung binh
//        int score = 7;
//        int scoreMath = 10;
//        System.out.println("Nhap diem so:" + score);
//
//
//        if (score > 8) {
//            System.out.println("Hoc sinh gioi");
//        } else if ( score < 8 && scoreMath > 9) {
//            System.out.println("Hoc sinh kha");
//        } else {
//            System.out.println("Hoc sinh trung binh");
//        }
        //cho tong 3 so, va kiem tra tong 3 so la chan hay le
        // so khong bao gio chia het cho 2
        int tong;
        int a = 2;
        int b = 4;
        int c = 2;
        System.out.println("Nhap a: " + a);
        System.out.println("Nhap b: " +b);
        System.out.println("Nhap c: " +c);
        tong = a+b+c;
        if(tong % 2 != 0){
            System.out.println("So le");
    // chia lay phan du
        }else{
            System.out.println("La so chan");
        }
       //bai tap  class BTVN iff else //cho 1 chu so thap phan co kieu int, lam sao de biet int do chuyen 12.00 -> == va != 12???

    }
}
