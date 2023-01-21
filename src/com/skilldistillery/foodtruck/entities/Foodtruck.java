package com.skilldistillery.foodtruck.entities;

import java.util.Objects;

public class Foodtruck {
	private String name;
	private String foodType;
	private double rating;
	private static int nextTruckId = 1;
	private int id;

	public Foodtruck() {
	}

	public Foodtruck(String name, String foodType, double rating) {
		super();
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
		this.id = nextTruckId;
		nextTruckId++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(foodType, id, name, rating);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Foodtruck other = (Foodtruck) obj;
		return Objects.equals(foodType, other.foodType) && id == other.id && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(rating) == Double.doubleToLongBits(other.rating);
	}

	@Override
	public String toString() {
		return "Foodtruck [name=" + name + ", foodType=" + foodType + ", rating=" + rating + ", id=" + id + "]";
	}

}
