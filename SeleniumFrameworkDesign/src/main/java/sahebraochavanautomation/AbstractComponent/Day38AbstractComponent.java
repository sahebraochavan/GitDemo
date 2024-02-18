package sahebraochavanautomation.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sahebraochavanautomation.pageobjects.Day39CartPage;
import sahebraochavanautomation.pageobjects.Day41OrdersPage;

public class Day38AbstractComponent {
	
	WebDriver driver;
	
public Day38AbstractComponent(WebDriver driver) {
	
	this.driver=driver;	
	PageFactory.initElements(driver,this);
	}
@FindBy (css="[routerlink*='cart']")
WebElement cartHeader;
@FindBy (css="[routerlink*='myorders']")
WebElement orderHeader;

	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
	}
	
	public void waitForWebElementToAppear(WebElement findBy)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public Day39CartPage goToCart()
	{
		cartHeader.click();
		Day39CartPage cartPage= new Day39CartPage(driver);
		return cartPage;
	}
	
	public Day41OrdersPage goToOrdersPage()
	{
		orderHeader.click();
		Day41OrdersPage ordersPage= new Day41OrdersPage(driver);
		return ordersPage;
	}
	
	public void waitForDisappear(WebElement spinner) throws InterruptedException
	{
		Thread.sleep(2000);
//		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(spinner));
	}

	

}
