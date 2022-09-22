package com.ute.javacore;

public class SwitchExample2 {
	public static void main(String[] args) {
		// Declare a variable age
		int age = 40;

		// Check the value of age
		switch (age) {
		// case age = 18
		case 18:
			System.out.println("You are 18 year old");
			break;
		// Case age 20,30,40
		case 20:
		case 30:
		case 40:
			System.out.println("You are: " + age);
			break;
		// Remaining case:
		default:
			System.out.println("Other age");

		}
	}

}
