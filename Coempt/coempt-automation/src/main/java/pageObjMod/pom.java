package pageObjMod;

	import org.openqa.selenium.WebDriver;

import base.Basic_Functions;
import browsers.BrowserManager;
import webelement.LoginPageXPath;

	public class pom  {
		public static WebDriver driver;

		public static LoginPageXPath loginXP ;
		 private static pom instance; 


		    // Use a different name for the static instance

		    // Constructor
		    public pom(WebDriver driver) {
		        this.driver = driver;
		    }

		    // Static method to get the instance
		    public static pom getInstance(WebDriver driver) {
		        // If the instance is null, create a new instance
		        if (instance == null) {
		            instance = new pom(driver);
		        }
		        return instance;  // Return the instance
		    }
		

	    
	    // Method to get the instance of LoginPageXPath
	    public static LoginPageXPath getInstanceLoginXP() {
	        // If the instance is null, create a new instance
	        if (loginXP == null) {
	        	loginXP = new LoginPageXPath(driver);
	        }
	        return loginXP; // Return the instance
	    }
	}
