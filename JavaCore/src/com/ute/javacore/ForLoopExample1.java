package com.ute.javacore;

public class ForLoopExample1 {
    public static void main(String[] args){
        //Declare a variable 'step', step in loop
        int step = 1;
        //Declare a variable value with the start value is 0
        //After each iteration, value will increase 3
        //And the loop will end whe the value greater than or equals to 10
        for(int value = 0; value < 10; value = value +3){
            System.out.println("Step =" + step + "  value = " + value);
            step = step + 1;
        }
    }
}
