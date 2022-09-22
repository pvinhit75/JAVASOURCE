package com.ute.javacore;

public class ElseIfExample2 {
	public static void main(String[] args) {
		// Declare a variable of type int, represents your age.
		int age = 20;

		// Test if less than or equals 17
		if (age <= 17) {
			System.out.println("Your are 17 or younger");

		}

		// test if age greater than 18 and less than 40

		else if (age > 18 && age < 40) {
			System.out.println("You are between 17 than 39");

		}
		// Remaining cases(Greater than or equal to 40
		else {
			// Nested if statements
			// Test age not equals 50.
			if (age != 50) {
				System.out.println("You are not 50 year old");

			}
			// Negative statements
			if (!(age == 50)) {
				System.out.println("You are not 50 year old");

			}
			// if age is 60 or 70
			if (age == 60 || age == 70) {
				System.out.println("You are 60 or 70 year old");
			}
		}

	}

}
