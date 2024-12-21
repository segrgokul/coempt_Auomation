package pagemodules;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.Basic_Functions;
import pom.pom;
import webelement.LoginPageXPath;  // Import the factory class

public class LoginPage extends Basic_Functions {

    static WebElement alertOkBtn;

    public void DirectSignIn() throws InterruptedException {
      
    	LoginPageXPath loginPage = new LoginPageXPath(driver);
    	
    	try {
    	
    	fluentWait(driver,pom.getInstanceLoginXP().password,50);
    	 click(driver,pom.getInstanceLoginXP().password);
    	 SENDKEYS(pom.getInstanceLoginXP().password,"check");
    	 System.out.println("check");
    	}
    	
    	catch(Exception e){
        
    	 explicitWait(driver,loginPage.password,10);
       	 click(driver,loginPage.password);
       	 implicitWait(driver,10);
       	 
       	 SENDKEYS(loginPage.password,"test");
       	 System.out.println("test");
       	 
  
   	 
    		
    	}
    	// Use the getInstance method to get the LoginPageXPath instance
        // Now you can use loginPage for actions
      // Access the signin button from the singleton instance
//        fluentWait(driver,pom.getInstanceLoginXP.);  // Assuming you have a fluentWait method
//        click(driver, signinBtn);  // Assuming you have a click method
//
//        Thread.sleep(1000);
//        
//        WebElement invalidUserName = driver.findElement(By.xpath("//h2[@class='swal2-title']"));
//
//        if (invalidUserName.isDisplayed()) {
//            alertOkBtn = driver.findElement(By.xpath("//button[@type='button' and text()='OK']"));
//            System.out.println("Unable to enter the login page with direct signin button");
//            alertOkBtn.click();
//        }
//    
    }

	

	public void DirectPassEntry() throws InterruptedException {
		LoginPageXPath loginPage = new LoginPageXPath(driver);
		
			    
			     
			
	
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
 		password.click();	
		password.sendKeys("Coempt@bpud");
		
		
		
		WebElement signinBtn = driver.findElement(By.xpath("//button[@id='btnLogin']"));
		signinBtn.click();	
		
		
		Thread.sleep(1000);
		WebElement invaidUserName = driver.findElement(By.xpath("//h2[@class='swal2-title' and text()='Invalid Username!']"));
		
		
		if (invaidUserName.isDisplayed()) {
			alertOkBtn = driver.findElement(By.xpath("//button[@type='button' and text()='OK']"));
			
			System.out.println("Unable to enter with direct password");
			alertOkBtn.click();
			Thread.sleep(1000);
			password.clear();
			
	}}
	
	public void DirectUserEntry() throws InterruptedException {
		LoginPageXPath loginPage = new LoginPageXPath(driver);
	
			    
			     
			
	
		WebElement	username = driver.findElement(By.xpath("//input[@id='username']"));
		username.click();	
		username.sendKeys("admin");
		
		
		WebElement signinBtn = driver.findElement(By.xpath("//button[@id='btnLogin']"));
		signinBtn.click();	
		
		
		Thread.sleep(1000);
		WebElement invaidPass = driver.findElement(By.xpath("//h2[@class='swal2-title' and text()='Invalid Password!']"));
		
		
		if (invaidPass.isDisplayed()) {
			alertOkBtn = driver.findElement(By.xpath("//button[@type='button' and text()='OK']"));
			
			System.out.println("Unable to enter with direct username");
			alertOkBtn.click();
			Thread.sleep(1000);
			username.clear();
			
	}}
	
	public void LoginInFail() throws InterruptedException {
	Thread.sleep(1000);
	LoginPageXPath loginPage = new LoginPageXPath(driver);
	
		    
		     
		

	WebElement	username = driver.findElement(By.xpath("//input[@id='username']"));
	username.click();	
	
	username.sendKeys(RandomStringUtils.randomAlphanumeric(8));

	WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
	password.click();	
	password.sendKeys(RandomStringUtils.randomAlphanumeric(8));

	
	WebElement signinBtn = driver.findElement(By.xpath("//button[@id='btnLogin']"));
	signinBtn.click();	
	

	
	Thread.sleep(1000);
	WebElement loginFail = driver.findElement(By.xpath("//h2[@class='swal2-title' and text()='Login Failed']"));
	
	
	if (loginFail.isDisplayed()) {
		alertOkBtn = driver.findElement(By.xpath("//button[@type='button' and text()='OK']"));
		
		System.out.println("Unable to enter with invalid username and password");
		alertOkBtn.click();
		Thread.sleep(1000);
		username.clear();
		password.clear();
		
}}
	

	
	
	
	public void Login() throws InterruptedException {
		LoginPageXPath loginPage = new LoginPageXPath(driver);
			
				    
				     
				   
			WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
			username.click();	
			username.sendKeys("admin");
	
     		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
     		password.click();	
			password.sendKeys("Coempt@bpu");
	
			
			WebElement signinBtn = driver.findElement(By.xpath("//button[@id='btnLogin']"));
			signinBtn.click();	
			
			Thread.sleep(7000);
			
		WebElement loginTags = driver.findElement(By.xpath("//span[@class='nk-menu-text' and contains(text(),'(Admin)')]"));
			
			System.out.println(loginTags.isDisplayed());
			
			if (loginTags.isDisplayed()) {
				
			System.out.println("The Admin Login Page has login and the landing page of KNRUHS is displayed");
	}}
			
	public void Logout() {		
		LoginPageXPath loginPage = new LoginPageXPath(driver);
		
			     
			
		
			WebElement loginTags = driver.findElement(By.xpath("//span[@class='nk-menu-text' and contains(text(),'(Admin)')]"));
			
			System.out.println(loginTags.isDisplayed());
			
			if (loginTags.isDisplayed()) {
				
				System.out.println("The Admin Login Page has login and the landing page of KNRUHS is displayed");
				loginTags.click();
				
				WebElement signoutBtn = driver.findElement(By.xpath("//span[contains(text(),'Sign out')]"));
				signoutBtn.click();
			
			
				
			}
			}
			
	
//	if (invaidUserName.isDisplayed()) {
//		WebElement alertOkBtn = driver.findElement(By.xpath("//button[@type='button' and text()='OK']"));
//		
//		System.out.println("The Admin Login Page has unable to login with invalid password");
//		alertOkBtn.click();
//		
//		WebElement signoutBtn = driver.findElement(By.xpath("//span[contains(text(),'Sign out')]")));
//		signoutBtn.click();
//	
//	
//		
//	}
//	
	
	
	
	
	
	
	
//			
	public void SignIn() throws InterruptedException {	
			//input[@id='username']

//	Actions actions = new Actions(driver);
//	actions.moveToElement(loginPage.userName).click().perform();

//
//		WebElement check= driver.findElement(By.xpath("//label[@class='form-label']"));
//		
//		check.getText();
//		System.out.println(check);
		
	//fluentWait(driver,loginPage.userName);
//	
//	
//	
//
//	
//	
//		Thread.sleep(5000);
//    fluentWait(driver,loginPage.userName);
//	click(driver, loginPage.userName);
//	implicitWait(driver, loginPage.userName, 5);
//	sendKeys(driver,loginPage.userName, "admin");
//	
//	
		

			

//	implicitWait(driver, loginPage.password, 10);
	
	}
	
	


	
	



  
}

	


    
    

