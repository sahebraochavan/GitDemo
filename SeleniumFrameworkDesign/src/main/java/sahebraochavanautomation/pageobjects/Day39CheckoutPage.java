package sahebraochavanautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import sahebraochavanautomation.AbstractComponent.Day38AbstractComponent;

public class Day39CheckoutPage extends Day38AbstractComponent{
	
	WebDriver driver;
	public Day39CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".actions a")
	WebElement submit;
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	@FindBy(xpath="//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	By results = By.cssSelector(".ta-results");
	
	
	public void selectCountry(String countryName)
	{
		Actions a=new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
	}
	
	public Day39ConfirmationPage submitOrder()
	{
		submit.click();
		return new Day39ConfirmationPage(driver);
	}
	

}
