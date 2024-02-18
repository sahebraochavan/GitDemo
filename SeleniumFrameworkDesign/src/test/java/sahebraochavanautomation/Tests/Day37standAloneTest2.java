package sahebraochavanautomation.Tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import sahebraochavanautomation.AbstractComponent.Day38AbstractComponent;
import sahebraochavanautomation.TestComponent.Day40BaseTest;
import sahebraochavanautomation.TestComponent.Day44Retry;
import sahebraochavanautomation.pageobjects.Day38LandingPage;
import sahebraochavanautomation.pageobjects.Day38ProductCatalogue;
import sahebraochavanautomation.pageobjects.Day39CartPage;
import sahebraochavanautomation.pageobjects.Day39CheckoutPage;
import sahebraochavanautomation.pageobjects.Day39ConfirmationPage;
import sahebraochavanautomation.pageobjects.Day41OrdersPage;

public class Day37standAloneTest2 extends Day40BaseTest {

	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = "Purchase")
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		Day38ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"),
				input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addToCart(input.get("product"));
		Day39CartPage cartPage = productCatalogue.goToCart();
		Boolean match = cartPage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		Day39CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		Day39ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmationUI = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmationUI.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

	@Test(dependsOnMethods = { "submitOrder" },retryAnalyzer=Day44Retry.class)
	public void orderHistoryDisplay() {
		Day38ProductCatalogue productCatalogue = landingPage.loginApplication("nandini.1@gmail.com", "Chavan@1234");
		Day41OrdersPage orderPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(productName));

	}

	@DataProvider
	public Object[][] getData() throws IOException {
//	
		List<HashMap<String, String>> data = getDataJsonToMap(System.getProperty("user.dir")
				+ "\\src\\test\\java\\sahebraochavanautomation\\data\\PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
