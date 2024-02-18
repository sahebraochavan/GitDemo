package sahebraochavanautomation.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import sahebraochavanautomation.TestComponent.Day40BaseTest;

public class Day37standAloneTestError extends Day40BaseTest {
	

@Test(groups="ErrorHandling")
public void submitOrderError() throws IOException, InterruptedException
{
		
	String productName="ZARA COAT 3";
	landingPage.loginApplication("nandini.1@gmail.com", "Chavan@134");
	landingPage.getErrorMessage();
	Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	
}

}
