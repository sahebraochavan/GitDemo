package sahebraochavanautomation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sahebraochavanautomation.AbstractComponent.Day38AbstractComponent;

public class Day41OrdersPage extends Day38AbstractComponent {
	
	WebDriver driver;
	@FindBy(css=".totalRow button")
	WebElement checkOut;
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> productNames;
//	List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
//	driver.findElement(By.cssSelector(".totalRow button")).click();
	
	public Day41OrdersPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public Boolean verifyOrderDisplay(String productName)
	{
		Boolean match=productNames.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
		

}
