
package Cucumber.StepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sahebraochavanautomation.TestComponent.Day40BaseTest;
import sahebraochavanautomation.pageobjects.Day38LandingPage;
import sahebraochavanautomation.pageobjects.Day38ProductCatalogue;
import sahebraochavanautomation.pageobjects.Day39CartPage;
import sahebraochavanautomation.pageobjects.Day39CheckoutPage;
import sahebraochavanautomation.pageobjects.Day39ConfirmationPage;

public class StepDefinitionImpl extends Day40BaseTest {
	
	public Day38LandingPage landingPage;
	public Day38ProductCatalogue productCatalogue;
	public Day39ConfirmationPage confirmationPage;
	@Given ("I landed on the Ecommerce page")
	
	public void I_landed_on_the_Ecommerce_page() throws IOException
	{
		landingPage=launchApplication();
	}
	
	@Given ("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username, String password)
	{
		productCatalogue = landingPage.loginApplication(username,password);
	}
	
	@When ("^I add product (.+) to Cart$")
	public void I_add_product_to_Cart(String productName) throws InterruptedException
	{
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addToCart(productName);
		
	}
	
	@When ("^Checkout (.+) and submit the order$")
	public void Checkout_and_submit_the_order(String productName)
	{
		Day39CartPage cartPage = productCatalogue.goToCart();
		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		Day39CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		confirmationPage = checkoutPage.submitOrder();
	}
	
	@Then ("{string} message is displayed on confirmationPage")
	public void message_is_displayed_on_confirmationPage(String string)
	{
		String confirmationUI = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmationUI.equalsIgnoreCase(string));
	}
	
	@Then ("{string} message is displayed")
	public void message_is_displayed(String string)
	{
		landingPage.loginApplication("nandini.1@gmail.com", "Chavan@134");
		landingPage.getErrorMessage();
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}

}
