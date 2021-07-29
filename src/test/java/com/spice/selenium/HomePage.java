package com.spice.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	@FindBy(id = "spiceName")
	private WebElement spiceName;

	@FindBy(id = "spiceCuisine")
	private WebElement spiceCuisine;

	@FindBy(id = "spiceFlavourRating")
	private WebElement spiceFlavourRating;

	@FindBy(id = "spicePrice")
	private WebElement spicePrice;

	@FindBy(id = "submitPostForm")
	private WebElement submitPostForm;

	@FindBy(id = "getAllButton")
	private WebElement getAllButton;

	@FindBy(id = "getAllOutput")
	private WebElement getAllOutput;

	public void createSpice(String name, String cuisine, int flavourRating, int price) {
		this.spiceName.sendKeys(name);
		this.spiceCuisine.sendKeys(cuisine);
		this.spiceFlavourRating.sendKeys(String.valueOf(flavourRating));
		this.spicePrice.sendKeys(String.valueOf(price));
		this.submitPostForm.click();
	}

	public void readSpices() {
		this.getAllButton.click();
	}

	public WebElement fetchGetAllOutput() {
		return getAllOutput;
	}
}
