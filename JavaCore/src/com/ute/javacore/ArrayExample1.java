package com.ute.javacore;

public class ArrayExample1 {
	public static void main(String[] args) {
		int[] myArray = new int[5];

		myArray[1] = 10;
		myArray[2] = 14;
		myArray[3] = 27;
		myArray[4] = 18;

		System.out.println("Array Length= " + myArray.length);

		System.out.println("myArray[3]=" + myArray[3]);

		for (int index = 0; index < myArray.length; index++) {
			System.out.println("Element" + index + "=" + myArray[index]);
		}

	}
}
