package com.company.oop;

import java.util.Scanner;

public class Validation {

    private final static Scanner in = new Scanner(System.in);

    public static int checkInputLimit(int max, int min){
        while(true){
            int result = Integer.parseInt(in.nextLine().trim());

            if (result < min || result > max){
                throw new NumberFormatException();
            }
            return result;
        }catch (NumberFormatException e){
            System.err.println("Please imput number in rage");

        }
    }
    public static boolean checkInputYN(){
        while(String){

        }
    }
}
