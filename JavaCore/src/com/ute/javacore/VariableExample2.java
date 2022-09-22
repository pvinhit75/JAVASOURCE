package com.ute.javacore;

public class VariableExample2 {
    public static void main(String[] args){
        //Declare 3 number type of long (64-bot Integer)
        long firstNumber, secondNumber, thirdNumber;

        //Assign value to firstName
        //Character 'L' at the end to tell java a long type
        //disting from type int
        firstNumber = 100L;

        //Assign values to secondNumber
        secondNumber = 200L;

        //Assign values to thirdNumber
        thirdNumber = firstNumber + secondNumber;

        System.out.println("First Number = " +firstNumber);
        System.out.println("Second Number = " +secondNumber);
        System.out.println("Third Number =" + thirdNumber);


    }
}
