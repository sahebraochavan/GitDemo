package sahebraochavanautomation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sahebraochavanautomation.AbstractComponent.Day38AbstractComponent;

public class Day39CartPage extends Day38AbstractComponent {
	
	WebDriver driver;
	@FindBy(css=".totalRow button")
	WebElement checkOut;
	@FindBy(css=".cartSection h3")
	private List<WebElement> cartProducts;
//	List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
//	driver.findElement(By.cssSelector(".totalRow button")).click();
	
	public Day39CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public Boolean verifyProductDisplay(String productName)
	{
		Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public Day39CheckoutPage goToCheckout()
	{
		checkOut.click();
		return new Day39CheckoutPage(driver);
	}
	
	 
	

}
