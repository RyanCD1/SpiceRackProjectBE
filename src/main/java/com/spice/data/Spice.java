package com.spice.data;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Spice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String cuisine;
	private int flavourRating;
	private int price;

	public Spice() {
	}

	public Spice(int id, String name, String cuisine, int flavourRating, int price) {
		super();
		this.id = id;
		this.name = name;
		this.cuisine = cuisine;
		this.flavourRating = flavourRating;
		this.price = price;
	}

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Spice [name=" + name + ", cuisine=" + cuisine + ", flavourRating=" + flavourRating + ", price=" + price
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuisine, flavourRating, id, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Spice other = (Spice) obj;
		return Objects.equals(cuisine, other.cuisine) && flavourRating == other.flavourRating && id == other.id
				&& Objects.equals(name, other.name) && price == other.price;
	}

}
