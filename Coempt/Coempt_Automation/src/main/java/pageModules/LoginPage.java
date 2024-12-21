package pageModules;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.Basic_Functions;
import pageObjMod.pom;
import webElement.LoginPageXPaths;
 // Import the factory class

public class LoginPage extends Basic_Functions {


    public void DirectSignIn() throws InterruptedException {
      
    	LoginPageXPaths loginPage = new LoginPageXPaths(driver);
    	
    	try {
    	
    	fluentWait(driver,pom.getInstanceLoginXP().userpass,50);
    	 click(driver,pom.getInstanceLoginXP().userpass);
    	 SENDKEYS(pom.getInstanceLoginXP().userpass,"check");
    	 System.out.println("check");
    	}
    	
    	catch(Exception e){
        
   		implicitWait(driver,30);	
   		explicitWait(driver,loginPage.signinBtn,30);
       	click(driver,loginPage.signinBtn);
      	 
       	if (loginPage.invaidUserName.isDisplayed()) {
			
			System.out.println("User is unable to enter with direct signin button");
			loginPage.alertOkBtn.click();
			
	}}
    		
    	
       	
   	 
    		
    	}

	

	public void DirectPassEntry() throws InterruptedException {
		LoginPageXPaths loginPage = new LoginPageXPaths(driver);

      	 implicitWait(driver,30);
		 explicitWait(driver,loginPage.userpass,30);
       	 click(driver,loginPage.userpass);
       	 implicitWait(driver,30);
       	 
       	 SENDKEYS(loginPage.userpass,"Coempt@bpu");
			    
       	implicitWait(driver,30);	
   		explicitWait(driver,loginPage.signinBtn,30);
       	click(driver,loginPage.signinBtn);
    	implicitWait(driver,30);	
       	
		if (loginPage.invaidUserName.isDisplayed()) {
			
			System.out.println("User is unable to enter with direct userpass");
			implicitWait(driver,30);	
	   		explicitWait(driver,loginPage.alertOkBtn,30);
			loginPage.alertOkBtn.click();
			implicitWait(driver,30);	
			loginPage.userpass.clear();
			
	}}
	
	public void DirectUserEntry() throws InterruptedException {
		LoginPageXPaths loginPage = new LoginPageXPaths(driver);

     	 implicitWait(driver,30);
		
     	 explicitWait(driver,loginPage.userName,30);
      	
     	 click(driver,loginPage.userName);
      	
      	 implicitWait(driver,30);
      	 
      	 SENDKEYS(loginPage.userName,"admin");
			    
      	implicitWait(driver,30);	
  		explicitWait(driver,loginPage.signinBtn,30);
      	click(driver,loginPage.signinBtn);
      	
		if (loginPage.invaidPassword.isDisplayed()) {
			
			System.out.println("User is unable to enter with direct username");
			implicitWait(driver,30);	
	   		explicitWait(driver,loginPage.alertOkBtn,30);
			loginPage.alertOkBtn.click();
			implicitWait(driver,30);	
			loginPage.userName.clear();
			
	}}
	
	public void LoginInFail() throws InterruptedException {
		LoginPageXPaths loginPage = new LoginPageXPaths(driver);

    	 implicitWait(driver,30);
		
    	 explicitWait(driver,loginPage.userName,30);
     	
    	 click(driver,loginPage.userName);
     	
     	 implicitWait(driver,30);
     	 
     	 SENDKEYS(loginPage.userName,RandomStringUtils.randomAlphanumeric(8));
			    
     	 implicitWait(driver,30);
		 explicitWait(driver,loginPage.userpass,30);
       	 click(driver,loginPage.userpass);
       	 implicitWait(driver,30);
       	 
       	 SENDKEYS(loginPage.userpass,RandomStringUtils.randomAlphanumeric(8));
			    
       	implicitWait(driver,30);	
   		explicitWait(driver,loginPage.signinBtn,30);
       	click(driver,loginPage.signinBtn);
    	implicitWait(driver,30);	
     	
		if (loginPage.loginFail.isDisplayed()) {
			
			System.out.println("User is unable to enter with direct username");
			implicitWait(driver,30);	
	   		explicitWait(driver,loginPage.alertOkBtn,30);
			loginPage.alertOkBtn.click();
			implicitWait(driver,30);	
			loginPage.userName.clear();
			implicitWait(driver,30);
			loginPage.userpass.clear();
	}}
	

	public void Login() throws InterruptedException {
		LoginPageXPaths loginPage = new LoginPageXPaths(driver);

    	 implicitWait(driver,30);
		
    	 explicitWait(driver,loginPage.userName,30);
     	
    	 click(driver,loginPage.userName);
     	
     	 implicitWait(driver,30);
     	 
     	 SENDKEYS(loginPage.userName,"admin");
			    
     	 implicitWait(driver,30);
		 explicitWait(driver,loginPage.userpass,30);
       	 click(driver,loginPage.userpass);
       	 implicitWait(driver,30);
       	 
       	 SENDKEYS(loginPage.userpass,"Coempt@bpu");
			    
       	implicitWait(driver,30);	
   		explicitWait(driver,loginPage.signinBtn,30);
       	click(driver,loginPage.signinBtn);
    	implicitWait(driver,30);	
    	explicitWait(driver,loginPage.loginTags,30);
		if (loginPage.loginTags.isDisplayed()) {
			
			System.out.println("The Admin Login Page has login and the landing page of KNRUHS is displayed");
			implicitWait(driver,30);	
	   		
	}}
	
	
	
	public void Logout() {		
		LoginPageXPaths loginPage = new LoginPageXPaths(driver);

		implicitWait(driver,30);	
   		explicitWait(driver,loginPage.loginTags,30);		
		
			if (loginPage.loginTags.isDisplayed()) {
				
				implicitWait(driver,30);	
		   		explicitWait(driver,loginPage.loginTags,30);
				
				click(driver,loginPage.loginTags);
				
				implicitWait(driver,30);	
		   		explicitWait(driver,loginPage.signOutBtn,30);
		   		click(driver,loginPage.signOutBtn);
			
			
				
			}
			}
			
	
//	if (invaidUserName.isDisplayed()) {
//		WebElement alertOkBtn = driver.findElement(By.xpath("//button[@type='button' and text()='OK']"));
//		
//		System.out.println("The Admin Login Page has unable to login with invalid userpass");
//		alertOkBtn.click();
//		
//		WebElement signoutBtn = driver.findElement(By.xpath("//span[contains(text(),'Sign out')]")));
//		signoutBtn.click();
//	
//	
//		
//	}
//	
	
	
	public void ReportCardCheck(String studentregno) {		
		LoginPageXPaths loginPage = new LoginPageXPaths(driver);

		implicitWait(driver,30);	
   		explicitWait(driver,loginPage.loginTags,30);		
		
			if (loginPage.loginTags.isDisplayed()) {
				
				implicitWait(driver,30);	
		   		explicitWait(driver,loginPage.loginTags,30);
				
		   		jsScroll(driver,loginPage.reportCardOption);
				
				implicitWait(driver,30);	
		   		explicitWait(driver,loginPage.reportCardOption,30);
		   		click(driver,loginPage.reportCardOption);
			
		   		implicitWait(driver,30);	
		   		explicitWait(driver,loginPage.reportCardEnroll,30);
				
		   		jsScroll(driver,loginPage.reportCardEnroll);
				
				implicitWait(driver,30);	
		   		explicitWait(driver,loginPage.reportCardEnroll,30);
		   		click(driver,loginPage.reportCardEnroll);
			
		   		implicitWait(driver,30);	
		   		explicitWait(driver,loginPage.Enrollno,30);
		   		click(driver,loginPage.Enrollno);
		   		SENDKEYS(loginPage.Enrollno,studentregno);
			}
			}
			
	
	
	
	
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
		

			

//	implicitWait(driver, loginPage.userpass, 10);
	
	}
	
	


	
	



  
}

	


    
    

