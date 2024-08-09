package steps;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitions {
      WebDriver driver;
      String expectedUsername;
      String expectedCongratulationMessage;
      
      @Before
      public void startBrowser() {
    	  driver = new ChromeDriver();
  		driver.manage().window().maximize();  
  		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
      }
	
	@Given("Application should be started in Browser")
	public void application_should_be_started_in_browser() {
		
driver.get("https://practicetestautomation.com/practice-test-login/");

	}


	@When("I enter the valid  {string}")
	public void i_enter_the_valid(String username) {
		expectedUsername=username;
	   driver.findElement(By.id("username")).sendKeys(username);
	 
	}
	@When("I enter valid {string}")
	public void i_enter_valid(String pwd) {
		  driver.findElement(By.id("password")).sendKeys(pwd);
	}
	@Then("I verify that user logged in and see message as  {string}")
	public void i_verify_that_user_logged_in_and_see_message_as(String expectedMesage) {  
		 driver.findElement(By.id("submit")).click();
	String actualMessage=	 driver.findElement(By.xpath("//h1[text()='Logged In Successfully']")).getText();
	System.out.println("actual message found is "+actualMessage);
	System.out.println("expected Mesage is "+expectedMesage);
	Assert.assertEquals(expectedMesage, actualMessage);
	if(actualMessage.equalsIgnoreCase(expectedMesage)) {
		System.out.println("Test passed");
	}
	else {
		System.out.println("Test failed");
	}
	
	}
@Then("{string} sees Congratulations {string}. You successfully logged in!")
public void sees_congratulations_you_successfully_logged_in(String userName, String userNameAgain) throws InterruptedException {
	  // Locate and retrieve the congratulation message element
    WebElement congratulationMessageElement = driver.findElement(By.cssSelector("p.has-text-align-center strong")); 
     expectedCongratulationMessage = "Congratulations " + userNameAgain + ". You successfully logged in!";
    String actualCongratulationMessage = congratulationMessageElement.getText();
    
    // Assert that the congratulation message is correct
    Assert.assertEquals(expectedCongratulationMessage, actualCongratulationMessage);
    
    Assert.assertTrue(actualCongratulationMessage.contains(userName));
    if(expectedCongratulationMessage.contains(userNameAgain)) {
    	System.out.println(userNameAgain+ "is displayed");
    }
    else
    {
    	System.out.println(userNameAgain+ "is not displayed");
    }
 
	Thread.sleep(300);
   // driver.quit();
}
@Then("I verify that user see error message as {string}")
public void i_verify_that_user_see_error_message_as(String expectedErrMessage) throws InterruptedException {
	 driver.findElement(By.id("submit")).click();
	 Thread.sleep(3000);
String ActualErrMessage=  driver.findElement(By.xpath("//div[@id='error']")).getText();
System.out.println("expected message is :"+ActualErrMessage);
Assert.assertEquals(expectedErrMessage, ActualErrMessage);
if(ActualErrMessage.equalsIgnoreCase(expectedErrMessage)) {
	System.out.println("passed");
}
else {
	System.out.println("failed");
}
}


@After
public void closeBrowser() {
	driver.close();  
}
}