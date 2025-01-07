package pageObjMod;

	import org.openqa.selenium.WebDriver;

import browsers.BrowserManager;
import webElement.LoginPageXPaths;
import webElement.ReportCoursePageXpaths;
import webElement.ReportEnrollmentPageXpaths;


	public class pom  extends BrowserManager{

				private static pom instance; // Singleton instance
				public static LoginPageXPaths loginXP ;
				private static ReportCoursePageXpaths CourseXP;
				private static ReportEnrollmentPageXpaths EnrollmentXP;

					// Use a different name for the static instance
		
					// Constructor
   public pom(WebDriver driver) {
						// Initialize the driver when the class is instantiated
						this.driver = driver;
		    }

	    // Method to get the instance of LoginPageXPath
	    public static LoginPageXPaths getInstanceLoginXP() {
	        // If the instance is null, create a new instance
	    	if (loginXP == null) {
	        	loginXP = new LoginPageXPaths(driver);
	        	return loginXP;
	        }
	        
	        return loginXP; // Return the instance
	    }

		public static ReportCoursePageXpaths getInstanceCourseXP() {
		
			if (CourseXP == null) {
				CourseXP = new ReportCoursePageXpaths(driver);
				return CourseXP;
			}	
		return CourseXP;
		}
		public static ReportEnrollmentPageXpaths getInstanceEnrollXP() {
		
					if (EnrollmentXP == null) {
						EnrollmentXP = new ReportEnrollmentPageXpaths(driver);
						return EnrollmentXP;

					}	
			return EnrollmentXP;
		}
	}
