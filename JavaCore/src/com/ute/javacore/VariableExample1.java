package com.ute.javacore;

public class VariableExample1 {
    public static void main(String[] args){

        //khai bao mot bien kieu int 32 bit integer
        int firstNumber ;

        //gán giá trị cho biến firstNumber
        firstNumber = 10;
        System.out.println("First Number =" +firstNumber);

        //Declare a variable type of float(32-bto real number)
        //this number is asigned a value of 10.2
        //the 'f' charater at the end makes java understands that this is a float
        float secondNumber = 10.2f;
        System.out.println("Second Number= " +secondNumber);

        //Declare a number type if double(64-bit real number)
        //This is assigned a value of 10.2
        //character 'd' at the end to tell with java this is the type double
        //Distinguished from a float 'f'
        double thirdNumber = 10.2d;

        System.out.println("Third Number =" +thirdNumber);

        //Declare a character
        char ch = 'a';
        System.out.println("Char ch=" +ch);
    }
}
