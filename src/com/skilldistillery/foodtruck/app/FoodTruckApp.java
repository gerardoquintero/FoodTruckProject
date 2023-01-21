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
		promptUserAndCreateFoodTruckInfo(sc);

	}

	private Foodtruck promptUserAndCreateFoodTruckInfo(Scanner sc) {
		System.out.println("Enter the name for the food truck: ");
		String foodTruckName = sc.nextLine();
		System.out.println("Enter the food type for the food truck: ");
		String foodTruckType = sc.nextLine();
		System.out.println("Enter the rating for the food truck: ");
		double rating = sc.nextDouble();		
		Foodtruck truck = new Foodtruck(foodTruckName, foodTruckType, rating);
		return truck;
	}

}
