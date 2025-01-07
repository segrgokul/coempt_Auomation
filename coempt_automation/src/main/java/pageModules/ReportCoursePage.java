package pageModules;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BasicFunctions;
import static pageModules.ReportEnrollmentPage.EnrollmentAwardName;
import static pageModules.ReportEnrollmentPage.EnrollmentExamDate;
import static pageModules.ReportEnrollmentPage.EnrollmentExamType;
import static pageModules.ReportEnrollmentPage.EnrollmentRegulation;
import static pageModules.ReportEnrollmentPage.EnrollmentSemester;
import pageObjMod.pom;

public class ReportCoursePage extends BasicFunctions {
	public Object[][] data1;
	public Object[][] data2;
	
	public void ReportCardNavigation() {
	
		implicitWait( 30);
		explicitWait( pom.getInstanceCourseXP().loginTags, 30);

		if (pom.getInstanceCourseXP().loginTags.isDisplayed()) {

			implicitWait( 30);
			explicitWait( pom.getInstanceCourseXP().loginTags, 30);

			jsScroll( pom.getInstanceCourseXP().reportCardOption);

			implicitWait( 30);
			explicitWait( pom.getInstanceCourseXP().reportCardOption, 30);
			click( pom.getInstanceCourseXP().reportCardOption);
		}
	}
	
	
	
	public void ReportCardCourseNavigation() {
	
		implicitWait( 30);
		explicitWait( pom.getInstanceCourseXP().reportCardCourse, 30);

		jsScroll( pom.getInstanceCourseXP().reportCardCourse);

		implicitWait( 30);
		explicitWait( pom.getInstanceCourseXP().reportCardCourse, 30);
		click( pom.getInstanceCourseXP().reportCardCourse);

	}
	
	public void handleCollegeCode(Object clgCode) throws InterruptedException {
	
		
		// Wait for the dropdown and textbox elements
		implicitWait( 30);
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
		} else {
			System.out.println("College code not found.");
		}
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
