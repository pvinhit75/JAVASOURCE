package com.ute.javacore;

public class SwitchExample1 {
	public static void main(String[] args) {
		int age = 20;
		switch (age) {
		case 18:
			System.out.println("you are 18 year old");
			break;
		case 20:
			System.out.println("You are 20 year old");
			break;
		default:
			System.out.println("You are not 18 or 20 year old");
		}

	}

}
