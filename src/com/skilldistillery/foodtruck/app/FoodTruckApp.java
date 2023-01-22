package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.Foodtruck;

public class FoodTruckApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FoodTruckApp myApp = new FoodTruckApp();
		Foodtruck[] myTrucks = new Foodtruck[5];
//		can not compile having using a private modifier on a variable declaration
		myApp.runApp(myTrucks);
	}

	private void runApp(Foodtruck[] myTrucks) {
		Scanner sc = new Scanner(System.in);
		myTrucks = createFiveFoodTrucks(myTrucks, sc);
		int userMenuSelection = displayMenuAndGetUserSelection(sc);
		executeUserMenuChoice(userMenuSelection, myTrucks);
	}

	private void executeUserMenuChoice(int userMenuSelection, Foodtruck[] myTrucks) {
		switch (userMenuSelection) {
		case 1:
			listAllFoodTrucks(myTrucks);
			break;
		case 2:
			showAverageRating(myTrucks);
			break;
		case 3:
			showHighestRatedTruck(myTrucks);
			break;
		case 4:
			quitProgram();
			break;
		default:
			System.out.println("Please select a valid number. ");
			break;
		}
	}

	private void quitProgram() {
		System.out.println("Quitting Program. Goodbye...");
	}

	private void showHighestRatedTruck(Foodtruck[] myTrucks) {
		Foodtruck highestRatedTruck = myTrucks[0];
		for (int i = 0; i < myTrucks.length; i++) {
			if (myTrucks[i] != null) {
				if (highestRatedTruck.getRating() < myTrucks[i].getRating()) {
					highestRatedTruck = myTrucks[i];
				}
			}
		}
		System.out.println(highestRatedTruck.toString());
	}

	private void showAverageRating(Foodtruck[] myTrucks) {
		double runningSum = 0;
		double numberOfTrucks = 0;
		for (int i = 0; i < myTrucks.length; i++) {
			if (myTrucks[i] != null) {
				runningSum = runningSum + myTrucks[i].getRating();
				numberOfTrucks++;
			}
		}
		double averageRating = runningSum / numberOfTrucks;
		System.out.println("The average rating of all of the food trucks is " + averageRating);
	}

	private void listAllFoodTrucks(Foodtruck[] myTrucks) {
		for (int i = 0; i < myTrucks.length; i++) {
			if (myTrucks[i] != null) {
				System.out.println(myTrucks[i]);
			}
		}

	}

	private int displayMenuAndGetUserSelection(Scanner sc) {
		System.out.println("---Menu---");
		System.out.println("    1. List all existing food trucks.");
		System.out.println("    2. See the average rating of food trucks.");
		System.out.println("    3. Display the highest-rated food truck.");
		System.out.println("    4. Quit the program.");
		System.out.println("Enter a number to make a selection.");

		int userMenuSelection = sc.nextInt();
		return userMenuSelection;
	}

	private Foodtruck promptUserAndCreateFoodTruckInfo(Scanner sc) {
		System.out.println("Enter the name for the food truck: ");
		String foodTruckName = sc.nextLine();
		if (foodTruckName.equalsIgnoreCase("quit")) {
			return null;
		}
		System.out.println("Enter the food type for the food truck: ");
		String foodTruckType = sc.nextLine();
		System.out.println("Enter the rating for the food truck: ");
		double rating = sc.nextDouble();
		sc.nextLine();
		Foodtruck truck = new Foodtruck(foodTruckName, foodTruckType, rating);
		return truck;
	}

	private Foodtruck[] createFiveFoodTrucks(Foodtruck[] myTrucks, Scanner sc) {
		for (int i = 0; i < myTrucks.length; i++) {
			int foodTruckNumber = i + 1;
			System.out.println("Food truck #" + foodTruckNumber);
			Foodtruck truck = promptUserAndCreateFoodTruckInfo(sc);
			if (truck != null) {
				myTrucks[i] = truck;
			} else {
				System.out.println("Ending input");
				break;
			}
		}
		return myTrucks;
	}
}
