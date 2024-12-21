package runner_execution;

import static browsers.BrowserManager.Browser_Launch;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import browsers.BrowserManager;
import pagemodules.LoginPage;

public class Execution extends BrowserManager{
	

	   public static WebDriver driver;
	
	LoginPage login = new LoginPage();
    
	 @Test
	 public void testCase1() throws InterruptedException {
	   System.out.println("This is the A Normal Test Case"); 
	  login.DirectSignIn();
	 
	 }

	 @BeforeMethod
	 public void beforeMethod() {
	   System.out.println("This will execute foruth before every Method and after the before class");
	
	 }
	 
	 @AfterMethod
	 public void afterMethod() {
	   System.out.println("This will execute after every Method");
	 }
	 
	 @BeforeClass
	 public void beforeClass() {
	   System.out.println("This will execute third before the Class and after the befortest");
	 }
	 
	 @AfterClass
	 public void afterClass() {
	   System.out.println("This will execute after the Class");
    
	  
	 }
	 
	 @BeforeTest
	 public void beforeTest() {
	   System.out.println("This will execute second before the Test and after the before test suite");
	 }
	 
	 @AfterTest
	 public void afterTest() {
	   System.out.println("This will execute after the Test");

	 }
	 
	 @BeforeSuite
	 public void beforeSuite() {
	   System.out.println("This will execute first before the Test Suite");
	   Browser_Launch();
	 }
	 
	 @AfterSuite
	 public void afterSuite() {
	   System.out.println("This will execute after the Test Suite");
	  }
	}
	

