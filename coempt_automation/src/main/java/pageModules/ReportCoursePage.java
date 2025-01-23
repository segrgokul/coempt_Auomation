package pageModules;

import static pageModules.ReportEnrollmentPage.EnrollmentAwardName;
import static pageModules.ReportEnrollmentPage.EnrollmentExamDate;
import static pageModules.ReportEnrollmentPage.EnrollmentExamType;
import static pageModules.ReportEnrollmentPage.EnrollmentRegulation;
import static pageModules.ReportEnrollmentPage.EnrollmentSemester;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.BasicFunctions;
import pageObjMod.pom;

public class ReportCoursePage extends BasicFunctions {
	public Object[][] data1;
	public Object[][] data2;
	public static ExtentTest testCaseName;
//	static ExtentReports report;


	    // Constructor to initialize ExtentReports
	  // Set the test case name only once
	 
    
	   
   
	
	    	

	public void ReportCardNavigation() throws IOException {
	
//		ExtentReports     report = new ExtentReports("D:\\Coempt_Automation\\coempt_automation\\src\\test\\resources\\reports\\ReportCoursePage.html", true);
//        report.loadConfig(new File("path_to_config_file.xml"));
//    
//        ExtentTest	 test = report.startTest("ReportCardNavigation");
//		testCaseName = extentReport.createTest("Enrollment Page Actions");
//		
//		testCaseName.log(Status.INFO, "This is a pass message");

		
		implicitWait( 30);
		explicitWait( pom.getInstanceCourseXP().loginTags, 30);

		if (pom.getInstanceCourseXP().loginTags.isDisplayed()) {

			implicitWait( 30);
			explicitWait( pom.getInstanceCourseXP().loginTags, 30);

		//	testCaseName.log(Status.INFO, "Report Card Navigation");
			scroll( pom.getInstanceCourseXP().reportCardOption);

			implicitWait( 30);
			
			System.out.println("testCaseName: " + testCaseName);
			
			if(pom.getInstanceCourseXP().reportCardOption.isDisplayed()) {
			
			explicitWait( pom.getInstanceCourseXP().reportCardOption, 30);
			click( pom.getInstanceCourseXP().reportCardOption);
//			testCaseName.log(Status.PASS, "Report Card is Navigated sucessfully");
			

			
		//	testCaseName.log(Status.PASS, "This is a pass message");
}	}
			else {
	       
				
				/*
				 * testCaseName.log(Status.FAIL, "Login tag is not displayed",
				 * testCaseName.addScreenCaptureFromPath(BasicFunctions.capture(driver)));
				 */
	//			testCaseName.log(Status.FAIL, "Report Card page not navigating ", MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());
			
			}

	   
		}
	

	
	
	public void ReportCardCourseNavigation() {
	// // // 	// // // ExtentReports     report = new ExtentReports("D:\\Coempt_Automation\\coempt_automation\\src\\test\\resources\\reports\\ReportCoursePage.html");
    //    report.loadConfig(new File("path_to_config_file.xml"));
    

      //  ExtentTest	test = report.startTest("ReportCard Course Navigation");
	    
		implicitWait( 30);
		explicitWait( pom.getInstanceCourseXP().reportCardCourse, 30);

		scroll( pom.getInstanceCourseXP().reportCardCourse);

		implicitWait( 30);
		
		
		try {
		if(pom.getInstanceCourseXP().reportCardCourse.isDisplayed()) {
			implicitWait( 30);		
		
		explicitWait( pom.getInstanceCourseXP().reportCardCourse, 30);
		click( pom.getInstanceCourseXP().reportCardCourse);
//		testCaseName.log(Status.PASS, "Report Card is course navigation sucessfully");
	
		
		}
		}
		catch(Exception e) {
			testCaseName.log(Status.FAIL, "Report Card is course does not navigation sucessfully");
		}

	//	testCase.log(LogStatus.PASS, "ReportCard option is navigated perfectly ");
		

	}
	
	public void handleCollegeCode(Object clgCode) throws InterruptedException, IOException {
		 
		  
		
		// Wait for the dropdown and textbox elements
		implicitWait( 50);
		
		pom.getInstanceCourseXP().clgDropDown.isDisplayed();
		
		explicitWait( pom.getInstanceCourseXP().clgDropDown, 30);
	
		// Click the college dropdown
		click( pom.getInstanceCourseXP().clgDropDown);
		
		// Wait for the textbox to become clickable
		implicitWait( 30);
		explicitWait( pom.getInstanceCourseXP().clgTextBox, 30);
		
		// Enter the college code in the textbox
		click( pom.getInstanceCourseXP().clgTextBox);
		Thread.sleep(1000);  // Sleep to ensure the textbox is fully active
		implicitWait( 30);
		sendKeys(pom.getInstanceCourseXP().clgTextBox, String.valueOf(clgCode));
		
		// Wait for the dropdown results to load
		implicitWait( 30);
		explicitWait( pom.getInstanceCourseXP().clgDropDownResults.get(0), 30);
	
		// Click the first result in the dropdown
		if (pom.getInstanceCourseXP().clgDropDownResults.get(0).isDisplayed()) {
			click( pom.getInstanceCourseXP().clgDropDownResults.get(0));
//			testCaseName.log(Status.PASS, "College code has entered sucessfully");
			
			

		} else {
//			System.out.println("College code not found.");
			
			testCaseName.log(Status.FAIL, "College code has not entered ", MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

			
	//		testCase.log(LogStatus.FAIL, "Click action performed", testCase.addScreenCapture(BasicFunctions.capture(driver)));
		}
//		 report.endTest(test); // End the test after all logs are added
//	        report.flush();
	}
	
			
	public void handleOtherParameters(Object examdate, Object awardName,Object regulation,Object semester, Object examType) throws IOException, InterruptedException {
		
	
		// Log the received parameters for debugging purposes
    System.out.println("Handling parameters:");
    System.out.println("Exam Date: " + examdate);
    System.out.println("Award Name: " + awardName);
    System.out.println("Regulation: " + regulation);
	System.out.println("ExamType:: " + examType);

	System.out.println("Semester: " + semester);
	


   

	EnrollmentExamDate(examdate);
	implicitWait( 30);

	EnrollmentAwardName(awardName);
	implicitWait( 30);

//	reportEnrollmentPage.EnrollmentAwardName(programcourse);
	implicitWait( 30);
	EnrollmentRegulation(regulation);
	implicitWait( 30);
	EnrollmentExamType(examType);

	implicitWait( 30);
	EnrollmentSemester(semester);	
	}









	public void handleProgramCourse(Object programcourse) throws InterruptedException {
	
		
		// Wait for the dropdown and textbox elements
		implicitWait( 30);
		explicitWait( pom.getInstanceCourseXP().ProgramCourse, 30);
	
		// Click the college dropdown
		click( pom.getInstanceCourseXP().ProgramCourse);
		
		Thread.sleep(1000);  // Sleep to ensure the textbox is fully active
	   		implicitWait(30);	
//		   		
//		   	//li[contains(@class,'select2-results__option')
		WebElement ProgramCourseOption = driver.findElement(By.xpath("//li[@role='option' and text()='" + programcourse + "']"));
				explicitWait( ProgramCourseOption, 30);
//		click(yearSessionOption);
//		    	
	// System.out.println(yearSessionOption.isDisplayed());
		if (ProgramCourseOption.isDisplayed()) {
			explicitWait( ProgramCourseOption, 30);
			implicitWait( 30);		
		click( ProgramCourseOption);

		}
		
		else {
			implicitWait( 30);
			explicitWait(  pom.getInstanceCourseXP().ProgramCourse, 30);
			click(  pom.getInstanceCourseXP().ProgramCourse);
			implicitWait( 30);
			explicitWait( pom.getInstanceCourseXP().ProgramCourse, 30);
			click( ProgramCourseOption);
		}
		
		

	//reportEnrollmentPage.processOtherDetails(examdate,awardName,semester, regulation, examType);
    // Assuming the ReportCardCheckData method requires all these parameters
	
       

	}

	 
		
		
		public double objectToDataType(Object obj) {
		if (obj == null) {
			throw new IllegalArgumentException("Object cannot be null");
		}

		if (obj instanceof Double) {
			return (Double) obj;
		} else if (obj instanceof Integer) {
			return ((Integer) obj).doubleValue();
		} else if (obj instanceof Float) {
			return ((Float) obj).doubleValue();
		} else if (obj instanceof Long) {
			return ((Long) obj).doubleValue();
		} else if (obj instanceof String) {
			String str = (String) obj;
			try {
				return Double.parseDouble(str);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("String value cannot be converted to double: " + str);
			}
		} else {
			throw new IllegalArgumentException("Unsupported object type: " + obj.getClass().getSimpleName());
		}
	}
}
