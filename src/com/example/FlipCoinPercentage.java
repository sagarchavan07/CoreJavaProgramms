package com.example;

import java.util.Iterator;
import java.util.Scanner;

public class FlipCoinPercentage {

	public static void main(String[] args) {
		int coinStatus = 0;
		String userInput = null;
		int n = 0;
		int heatCount = 0;
		int tailCount = 0;
		double percentage = 0.00;

		// take the user input from console
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter the number of times to Flip Coin here : ");
			userInput = scanner.next();
		}

		// validate user input
		boolean isValid = validateUserInput(userInput);

		// Flip the coin n th times
		if (isValid) {
			n = Integer.parseInt(userInput);
			if (n > 0) {
				int i = 0;
				while (i < n) {
					i++;
					double result = flipCoin();
					if (result > 0.5) {
						System.out.println(i + "_HEAD");
						heatCount++;
					} else {
						System.out.println(i + "_TAIL");
						tailCount++;
					}
				}
			}
		}
		System.out.println("heatCount : " + heatCount);
		System.out.println("tailCount : " + tailCount);
		
		//Percentage of Head vs Tails
		percentage = ((double)heatCount / tailCount) * 100;
		System.out.println("Percentage of Head vs Tails : " + percentage + " %");

	}

	// validate userInput is a positive integer
	private static boolean validateUserInput(String userInput) {
		try {
			int i = Integer.parseInt(userInput);
			if (i < 0) {
				System.err.println("**Enter positive integer value");
				return false;
			}
		} catch (Exception e) {
			System.err.println("**Invalid Input : " + e.getMessage());
			return false;
		}
		return true;
	}

	private static double flipCoin() {
		return Math.random();
	}

}
