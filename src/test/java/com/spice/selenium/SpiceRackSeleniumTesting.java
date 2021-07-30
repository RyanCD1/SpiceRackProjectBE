package com.spice.selenium;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql(scripts = { "classpath:spice-schema.sql",
		"classpath:spice-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class SpiceRackSeleniumTesting {

	@LocalServerPort

	private int port;

	private WebDriver driver;

	@BeforeEach
	public void setup() {
		ChromeOptions opts = new ChromeOptions();
		opts.setHeadless(true);
		driver = new ChromeDriver(opts);
	}

	@Test
	public void testSpiceCreation() throws Exception {
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1:5500/SpiceRack/HTML/addSpiceForm.html");

		driver.findElement(By.id("spiceName")).sendKeys("TestSpice");
		driver.findElement(By.id("spiceCuisine")).sendKeys("Global");
		driver.findElement(By.id("spiceFlavourRating")).sendKeys("11");
		driver.findElement(By.id("spicePrice")).sendKeys("4");

		driver.findElement(By.id("submitPostForm")).submit();

		new WebDriverWait(driver, 4).until(ExpectedConditions.alertIsPresent());

		Alert createAlert = driver.switchTo().alert();
		createAlert.getText();

		assertThat(driver.switchTo().alert().getText().contains("You have succesffuly added a Spice to the list!"))
				.isTrue();
	}

	@Test
	void testRead() {
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1:5500/SpiceRack/HTML/index.html");

		driver.findElement(By.id("spiceId")).sendKeys("1");
		driver.findElement(By.id("getByIdButton")).click();

		new WebDriverWait(driver, 4).until(
				ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.id("getByIdOutput")), "innerHTML"));

		String expectedSpice = driver.findElement(By.id("getByIdOutput")).getText();
		String actualSpice = "Cinnamon";

		assertThat(expectedSpice = actualSpice);
	}

	@Test
	void testUpdate() {
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1:5500/SpiceRack/HTML/theGreatSpiceList.html");

		driver.findElement(By.className("updateButton")).click();
		driver.findElement(By.id("updateName")).sendKeys("TestSpice");
		driver.findElement(By.id("updateCuisine")).sendKeys("Global");
		driver.findElement(By.id("updateFlavourRating")).sendKeys("11");
		driver.findElement(By.id("updatePrice")).sendKeys("4");

		driver.findElement(By.id("submitUpdateForm")).submit();

		new WebDriverWait(driver, 4).until(ExpectedConditions.alertIsPresent());

		Alert createAlert = driver.switchTo().alert();
		createAlert.getText();

		assertThat(driver.switchTo().alert().getText().contains("You have succesffuly updated a Spice!")).isTrue();
	}

	@Test
	void testDelete() {
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1:5500/SpiceRack/HTML/theGreatSpiceList.html");

		driver.findElement(By.className("deleteButton")).click();

		new WebDriverWait(driver, 4).until(ExpectedConditions.alertIsPresent());

		Alert createAlert = driver.switchTo().alert();
		createAlert.getText();

		assertThat(driver.switchTo().alert().getText().contains("You have succesfully deleted a Spice!")).isTrue();
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}
}
