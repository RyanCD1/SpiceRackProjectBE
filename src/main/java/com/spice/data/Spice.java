package com.spice.data;

public class Spice {

	private String name;
	private String cuisine;
	private int flavourRating;
	private int price;

	public Spice(String name, String cuisine, int flavourRating, int price) {
		super();
		this.name = name;
		this.cuisine = cuisine;
		this.flavourRating = flavourRating;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public int getFlavourRating() {
		return flavourRating;
	}

	public void setFlavourRating(int flavourRating) {
		this.flavourRating = flavourRating;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Spice [name=" + name + ", cuisine=" + cuisine + ", flavourRating=" + flavourRating + ", price=" + price
				+ "]";
	}

}
