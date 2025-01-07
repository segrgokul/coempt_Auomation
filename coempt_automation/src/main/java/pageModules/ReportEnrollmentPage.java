package pageModules;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BasicFunctions;
import pageObjMod.pom;

public class ReportEnrollmentPage extends BasicFunctions {
	static ExtentTest test;
	static ExtentReports report;
	double Paper1;
	double Paper2;
	double Paper3;
	double TheroryExamTotal;
	double PraticalExamTotal;
	double ExamTotalScore;
	public Object[][] data1;
public Object[][] data2;
	

	public void ReportCardNavigation() {
		

		
		implicitWait( 30);
		explicitWait(pom.getInstanceEnrollXP().loginTags, 30);

		if (pom.getInstanceEnrollXP().loginTags.isDisplayed()) {

			implicitWait( 30);
			explicitWait( pom.getInstanceEnrollXP().loginTags, 30);

			jsScroll( pom.getInstanceEnrollXP().reportCardOption);

			implicitWait( 30);
			explicitWait( pom.getInstanceEnrollXP().reportCardOption, 30);
			click( pom.getInstanceEnrollXP().reportCardOption);
		}
	}

	public void ReportCardEnrollNavigation() {
		
		implicitWait( 30);
		explicitWait( pom.getInstanceEnrollXP().reportCardEnroll, 30);

		jsScroll( pom.getInstanceEnrollXP().reportCardEnroll);

		implicitWait( 30);
		explicitWait( pom.getInstanceEnrollXP().reportCardEnroll, 30);
		click( pom.getInstanceEnrollXP().reportCardEnroll);

	}

	public void EnrollmentRegNo(Object regno) throws IOException {
        
     
        implicitWait( 30);
        explicitWait( pom.getInstanceEnrollXP().enrollNo, 30);
        click( pom.getInstanceEnrollXP().enrollNo);

        implicitWait( 30);
        explicitWait( pom.getInstanceEnrollXP().enrollNo, 30);
        sendKeys(pom.getInstanceEnrollXP().enrollNo, String.valueOf(regno));
    }

	public static void EnrollmentExamDate(Object examDate) throws IOException {
        

		implicitWait( 30);
		
			
    		explicitWait( pom.getInstanceEnrollXP().examSeries, 30);
		 		click( pom.getInstanceEnrollXP().examSeries);
		
		 		implicitWait( 30);
		 		explicitWait( pom.getInstanceEnrollXP().examSeries, 30);
		 		click( pom.getInstanceEnrollXP().examSeries);
				   		
		 		implicitWait( 30);
		 		explicitWait( pom.getInstanceEnrollXP().examSeries, 30);
				 click( pom.getInstanceEnrollXP().examSeries);
		 		WebElement examDateOption = driver.findElement(By.xpath("//li[@role='option' and text()='" + examDate + "']"));
		 		explicitWait( examDateOption, 30);
		
		 		if (examDateOption.isDisplayed()) {
		 			explicitWait( examDateOption, 30);
		 			implicitWait( 30);		
		 		click( examDateOption);
		
		 		}
				
		 		else {
		 			implicitWait( 30);
		 			explicitWait( pom.getInstanceEnrollXP().examSeries, 30);
		 			click( pom.getInstanceEnrollXP().examSeries);
		 			implicitWait( 30);
		 			explicitWait( pom.getInstanceEnrollXP().examSeries, 30);
		 			click( examDateOption);
		 		}
		// //		   		dropDownClick(pom.getInstanceEnrollXP().examSeriesOption,examdate);
    
			}

	public static void EnrollmentAwardName(Object awardName) throws IOException {
		

		
		
		implicitWait( 30);
		explicitWait( pom.getInstanceEnrollXP().awardName, 30);
		click( pom.getInstanceEnrollXP().awardName);
//
//		   	//li[contains(@class,'select2-results__option') and text()!='Select']
//		   	// Construct XPath with the dynamic text
		WebElement awardOption = driver.findElement(By.xpath("//li[@role='option' and text()='" + awardName + "']"));
	
//
		if (awardOption.isDisplayed()) {
			explicitWait( awardOption, 30);
			implicitWait( 30);		
		click( awardOption);

		}
		
		else {
			implicitWait( 30);
			explicitWait( pom.getInstanceEnrollXP().awardName, 30);
			click( pom.getInstanceEnrollXP().awardName);
			implicitWait( 30);
			explicitWait( pom.getInstanceEnrollXP().awardName, 30);
			click( awardOption);
		}
		
	}

	public static void EnrollmentSemester(Object semester) throws IOException {
		

		implicitWait( 30);
		explicitWait( pom.getInstanceEnrollXP().yearSession, 30);
//		System.out.println(pom.getInstanceEnrollXP().yearSession.isDisplayed());

		click( pom.getInstanceEnrollXP().yearSession);
//		   		
		   		implicitWait(30);	
//		   		
//		   	//li[contains(@class,'select2-results__option')
		WebElement yearSessionOption = driver.findElement(By.xpath("//li[@role='option' and text()='" + semester + "']"));
				explicitWait( yearSessionOption, 30);
//		click(yearSessionOption);
//		    	
	// System.out.println(yearSessionOption.isDisplayed());
		if (yearSessionOption.isDisplayed()) {
			explicitWait( yearSessionOption, 30);
			implicitWait( 30);		
		click( yearSessionOption);

		}
		
		else {
			implicitWait( 30);
			explicitWait( pom.getInstanceEnrollXP().yearSession, 30);
			click( pom.getInstanceEnrollXP().yearSession);
			implicitWait( 30);
			explicitWait( pom.getInstanceEnrollXP().yearSession, 30);
			click( yearSessionOption);
		}
		
	}


	public static void EnrollmentRegulation(Object regulation){
		
		implicitWait( 30);
		explicitWait( pom.getInstanceEnrollXP().regulation, 30);
		System.out.println(pom.getInstanceEnrollXP().regulation.isDisplayed());

		click( pom.getInstanceEnrollXP().regulation);
		implicitWait( 30);

		


		// System.out.println(regulation);
		WebElement regulationOption = driver
				.findElement(By.xpath("//li[@role='option' and text()='" + regulation + "']"));
		
		if (regulationOption.isDisplayed()) {
			explicitWait( regulationOption, 30);
			implicitWait( 30);		
		click( regulationOption);

		}
		
		else {
			implicitWait( 30);
			explicitWait( pom.getInstanceEnrollXP().regulation, 30);
			click( pom.getInstanceEnrollXP().regulation);
			implicitWait( 30);
			explicitWait( pom.getInstanceEnrollXP().regulation, 30);
			click( regulationOption);
		}
	} 


	public static void EnrollmentExamType(Object examType) throws InterruptedException{
		

		System.out.println("To check" + examType);

		implicitWait( 30);
		explicitWait( pom.getInstanceEnrollXP().examType, 30);
	

		click( pom.getInstanceEnrollXP().examType);
		implicitWait( 30);

		WebElement examTypesOption = driver.findElement(By.xpath("//li[@role='option' and text()='" + examType + "']"));
		implicitWait( 60);
	//	System.out.println(examTypesOption.isDisplayed());
		if (examTypesOption.isDisplayed()) {
			explicitWait( examTypesOption, 30);
			implicitWait( 30);		
		click( examTypesOption);

		}
		
		else {
			implicitWait( 30);
			explicitWait( pom.getInstanceEnrollXP().examType, 30);
			click( pom.getInstanceEnrollXP().examType);
			implicitWait( 30);
			explicitWait( examTypesOption, 30);
			click( examTypesOption);
		}
	}
	


// 	public void processOtherDetails(Object examdate, Object awardName, Object semester, Object regulation, Object examType)  throws InterruptedException, IOException {
// 			
	
	
// 			Actions action = new Actions(driver);
	
// 		explicitWait( pom.getInstanceEnrollXP().examSeries, 30);
// 		click( pom.getInstanceEnrollXP().examSeries);

// 		implicitWait( 30);
// 		explicitWait( pom.getInstanceEnrollXP().examSeries, 30);
// 		click( pom.getInstanceEnrollXP().examSeries);
// //		   		
// //		   		if(pom.getInstanceEnrollXP().alertOk.isDisplayed()) {
// //			   		
// //			   		implicitWait(30);	
// //			   		explicitWait(pom.getInstanceEnrollXP().alertOk,30);
// //			   		click(pom.getInstanceEnrollXP().alertOk);
// //				}

// //				implicitWait(5000);	
// //		   		explicitWait(pom.getInstanceEnrollXP().enrollNo,30);
// //		   		pom.getInstanceEnrollXP().enrollNo.clear();
// //		   		implicitWait(30);	
// //		   		explicitWait(pom.getInstanceEnrollXP().enrollNo,30);
// //		   		sendKeys(pom.getInstanceEnrollXP().enrollNo, str);
// //			
// //			   		System.out.println(str);
// //			   		implicitWait(30);	
// //		   		
// //		   		}

// 		implicitWait( 30);
// 		explicitWait( pom.getInstanceEnrollXP().examSeries, 30);
// 		click( pom.getInstanceEnrollXP().examSeries);
// //		   		implicitWait(30);	
// //		   		
// //		   	//li[contains(@class,'select2-results__option')
// 		WebElement examDateOption = driver.findElement(By.xpath("//li[@role='option' and text()='" + examdate + "']"));
// 		explicitWait( examDateOption, 30);

// 		if (examDateOption.isDisplayed()) {
// 			explicitWait( examDateOption, 30);
// 			implicitWait( 30);		
// 		click( examDateOption);

// 		}
		
// 		else {
// 			implicitWait( 30);
// 			explicitWait( pom.getInstanceEnrollXP().examSeries, 30);
// 			click( pom.getInstanceEnrollXP().examSeries);
// 			implicitWait( 30);
// 			explicitWait( pom.getInstanceEnrollXP().examSeries, 30);
// 			click( examDateOption);
// 		}
// //		   		dropDownClick(pom.getInstanceEnrollXP().examSeriesOption,examdate);

// 		implicitWait( 30);
// 		explicitWait( pom.getInstanceEnrollXP().awardName, 30);
// 		click( pom.getInstanceEnrollXP().awardName);
// //
// //		   	//li[contains(@class,'select2-results__option') and text()!='Select']
// //		   	// Construct XPath with the dynamic text
// 		WebElement awardOption = driver.findElement(By.xpath("//li[@role='option' and text()='" + awardName + "']"));
	
// //
// 		if (awardOption.isDisplayed()) {
// 			explicitWait( awardOption, 30);
// 			implicitWait( 30);		
// 		click( awardOption);

// 		}
		
// 		else {
// 			implicitWait( 30);
// 			explicitWait( pom.getInstanceEnrollXP().awardName, 30);
// 			click( pom.getInstanceEnrollXP().awardName);
// 			implicitWait( 30);
// 			explicitWait( pom.getInstanceEnrollXP().awardName, 30);
// 			click( awardOption);
// 		}
		
		
		
// 		implicitWait( 30);
// 		explicitWait( pom.getInstanceEnrollXP().yearSession, 30);
// 		click( pom.getInstanceEnrollXP().yearSession);
// //		   		
// //		   		implicitWait(30);	
// //		   		
// //		   	//li[contains(@class,'select2-results__option')
// 		WebElement yearSessionOption = driver
// 				.findElement(By.xpath("//li[@role='option' and text()='" + semester + "']"));
// //		click( yearSessionOption);
// //		    	
// 		if (yearSessionOption.isDisplayed()) {
// 			explicitWait( yearSessionOption, 30);
// 			implicitWait( 30);		
// 		click( yearSessionOption);

// 		}
		
// 		else {
// 			implicitWait( 30);
// 			explicitWait( pom.getInstanceEnrollXP().yearSession, 30);
// 			click( pom.getInstanceEnrollXP().yearSession);
// 			implicitWait( 30);
// 			explicitWait( pom.getInstanceEnrollXP().yearSession, 30);
// 			click( yearSessionOption);
// 		}
		
// 		implicitWait( 30);
// 		explicitWait( pom.getInstanceEnrollXP().regulation, 30);
// 		click( pom.getInstanceEnrollXP().regulation);
// 		implicitWait( 30);

		


// 		// System.out.println(regulation);
// 		WebElement regulationOption = driver
// 				.findElement(By.xpath("//li[@role='option' and text()='" + regulation + "']"));
		
// 		if (regulationOption.isDisplayed()) {
// 			explicitWait( regulationOption, 30);
// 			implicitWait( 30);		
// 		click( regulationOption);

// 		}
		
// 		else {
// 			implicitWait( 30);
// 			explicitWait( pom.getInstanceEnrollXP().regulation, 30);
// 			click( pom.getInstanceEnrollXP().regulation);
// 			implicitWait( 30);
// 			explicitWait( pom.getInstanceEnrollXP().regulation, 30);
// 			click( regulationOption);
// 		}
		
// //		click( regulationOption);

// 		implicitWait( 30);
// 		explicitWait( pom.getInstanceEnrollXP().examType, 30);
// 		click( pom.getInstanceEnrollXP().examType);
// 		implicitWait( 30);

// 		WebElement examTypesOption = driver.findElement(By.xpath("//li[@role='option' and text()='" + examType + "']"));
	
// 		if (examTypesOption.isDisplayed()) {
// 			explicitWait( examTypesOption, 30);
// 			implicitWait( 30);		
// 		click( examTypesOption);

// 		}
		
// 		else {
// 			implicitWait( 30);
// 			explicitWait( pom.getInstanceEnrollXP().examType, 30);
// 			click( pom.getInstanceEnrollXP().examType);
// 			implicitWait( 30);
// 			explicitWait( examTypesOption, 30);
// 			click( examTypesOption);
// 		}
// //		click( examTypesOption);

	public  void submitButton() throws InterruptedException{
		
			
		

		implicitWait( 30);
		explicitWait( pom.getInstanceEnrollXP().submitBtn, 30);
		click( pom.getInstanceEnrollXP().submitBtn);
		
		Thread.sleep(5000);
		
		}


	public void DownloadReport(){

			
		try {

			
			Actions action = new Actions(driver);
			
		Thread.sleep(5000);

			implicitWait( 30);
			
//			action.moveToElement(pom.getInstanceEnrollXP().reportCardExportTo).perform();
			
			action.moveToElement(pom.getInstanceEnrollXP().reportCardExportTo).click().perform();
			
			implicitWait( 30);
			

//			action.moveToElement(pom.getInstanceEnrollXP().reportCardExportToPdf).perform();
			
			action.moveToElement(pom.getInstanceEnrollXP().reportCardExportToPdf).click().perform();
			
			implicitWait( 30);
			
			Thread.sleep(5000);
			
			
			// Get the parent window handle and store it in a list
			ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

			
			
			// Switch to the second window (index 1 in the list)
			driver.switchTo().window(windowHandles.get(1));

			// Perform actions in the new window/tab
			// ...
			implicitWait( 60);
			
			// Close the current window
			driver.close();

			// Switch back to the parent window (index 0 in the list)
    		driver.switchTo().window(windowHandles.get(0));

		}

		catch (Exception e) {
		
		}
	}



		public void Paper1(Object regno,Object paper1){
		try {

		
			
			Paper1 = objectToDataType(paper1);
			
		

			if (Paper1 < 50) {

				System.out.println("The following Registration number" + regno + " is failed in Paper1 exam");
				// test.log(Status.PASS, regno +" is Passed" ,test.add);
				System.out.println(Paper1);
			}

			else if (Paper1 >= 50) {
				System.out.println("The following Registration number" + regno + " is passed in Paper1 exam");
				System.out.println(Paper1);
			}

		}

		catch (Exception e) {
		
				System.out.println("Paper 1 row in the excel sheet is empty for the following "+ regno +" number please check the excel sheet");
				
			}
		}
		


		public void Paper2(Object regno,Object paper2){
		
			try {
			
			
			
				Paper2 = objectToDataType(paper2);
	
				if (Paper2 < 50) {
	
					System.out.println("The following Registration number " + regno + " is failed in Paper2 exam");
					System.out.println(Paper2);
				}
	
				else if (Paper2 >= 50) {
					System.out.println("The following Registration number " + regno + " is passed in Paper2 exam");
					System.out.println(Paper2);
				}
				
				else if (Paper2 >= 50) {
					System.out.println("The following Registration number " + regno + " is passed in Paper2 exam");
					System.out.println(Paper2);
				}
	
			}
	
			catch (Exception e) {
			
		
					System.out.println("Paper 2 row in the excel sheet is empty for the following "+ regno +" number please check the excel sheet");
					
			}
	
		}

		public void Paper3(Object regno,Object paper3){

			try {
				Paper3 = objectToDataType(paper3);
	
				if (Paper3 < 50) {
	
					System.out.println("The following Registration number " + regno + " is failed in Paper3 exam");
					System.out.println(Paper3);
				}
	
				else if (Paper3 >= 50) {
					System.out.println("The following Registration number " + regno + " is passed in Paper3 exam");
					System.out.println(Paper3);
				}
	
			}
	
			catch (Exception e) {
			
					System.out.println("Paper 3 row in the excel sheet is empty for the following "+ regno +" number please check the excel sheet");
					
			}
	
		}

		public void PraticalExam(Object regno,Object praticalExam){
			try {

				PraticalExamTotal = objectToDataType(praticalExam);
	
				if (PraticalExamTotal < 150) {
					System.out.println("The following Registration number " + regno + " is Failed in Pratical Exam");
					System.out.println(PraticalExamTotal);
				}
	
				else if (PraticalExamTotal >= 150) {
					System.out.println("The following Registration number " + regno + " is Passed in Practical Exam");
					System.out.println(PraticalExamTotal);
				}
	
			}
	
			catch (Exception e) {
			
					System.out.println("Pratical Exam row in the excel sheet is empty for the following "+ regno +" number please check the excel sheet");
					
			
			}
		}

		public void TheoryExam(Object regno,Object theoryExam){
			try {

				TheroryExamTotal = Paper1 + Paper2 + Paper3;
	
				TheroryExamTotal = objectToDataType(theoryExam);
	
				if (TheroryExamTotal < 150) {
					System.out.println("The following Registration number " + regno + " is Failed in Therory Exam");
					System.out.println(TheroryExamTotal);
				}
	
				else if (TheroryExamTotal >= 150) {
					System.out.println("The following Registration number " + regno + " is Passed in Therory Exam");
					System.out.println(TheroryExamTotal);
				}
			}
	
			catch (Exception e) {
		
					System.out.println("Therory Exam row in the excel sheet is empty for the following "+ regno +" number please check the excel sheet");
					
			
			}

			}


			public void ExamTotalScore(Object regno,Object examTotal) {
				
					
		try {

			ExamTotalScore = TheroryExamTotal + PraticalExamTotal;

			ExamTotalScore = objectToDataType(examTotal);

			if (ExamTotalScore < 300) {
				System.out.println("The following Registration number " + regno + " is Failed ");
				System.out.println(ExamTotalScore);
			}

			else if (ExamTotalScore >= 300) {
				System.out.println("The following Registration number " + regno + " is Passed ");
				System.out.println(ExamTotalScore);
			}
		}

		catch (Exception e) {
	
				System.out.println("Exam Total row in the excel sheet is empty for the following "+ regno +" number please check the excel sheet");
				
		}


			}


	// 	public void validatePaperResults(Object regno, Object paper1, Object paper2, Object paper3,Object praticalExam, Object theoryExam, Object examTotal) throws InterruptedException{
	// // double Total = (regno+regulation);

	// 	try {

		
			
	// 		Paper1 = objectToDataType(paper1);
			
		

	// 		if (Paper1 < 50) {

	// 			System.out.println("The following Registration number" + regno + " is failed in Paper1 exam");
	// 			// test.log(Status.PASS, regno +" is Passed" ,test.add);
	// 			System.out.println(Paper1);
	// 		}

	// 		else if (Paper1 >= 50) {
	// 			System.out.println("The following Registration number" + regno + " is passed in Paper1 exam");
	// 			System.out.println(Paper1);
	// 		}

	// 	}

	// 	catch (Exception e) {
	// 		if(paper1 == null) {
	// 			System.out.println("Paper 1 row in the excel sheet is empty for the following "+ regno +" number please check the excel sheet");
				
	// 		}
	// 	}

		
	// 	try {
			
			
			
	// 		Paper2 = objectToDataType(paper2);

	// 		if (Paper2 < 50) {

	// 			System.out.println("The following Registration number " + regno + " is failed in Paper2 exam");
	// 			System.out.println(Paper2);
	// 		}

	// 		else if (Paper2 >= 50) {
	// 			System.out.println("The following Registration number " + regno + " is passed in Paper2 exam");
	// 			System.out.println(Paper2);
	// 		}
			
	// 		else if (Paper2 >= 50) {
	// 			System.out.println("The following Registration number " + regno + " is passed in Paper2 exam");
	// 			System.out.println(Paper2);
	// 		}

	// 	}

	// 	catch (Exception e) {
		
	
	// 			System.out.println("Paper 2 row in the excel sheet is empty for the following "+ regno +" number please check the excel sheet");
				
	// 	}

	// 	try {
	// 		Paper3 = objectToDataType(paper3);

	// 		if (Paper3 < 50) {

	// 			System.out.println("The following Registration number " + regno + " is failed in Paper3 exam");
	// 			System.out.println(Paper3);
	// 		}

	// 		else if (Paper3 >= 50) {
	// 			System.out.println("The following Registration number " + regno + " is passed in Paper3 exam");
	// 			System.out.println(Paper3);
	// 		}

	// 	}

	// 	catch (Exception e) {
		
	// 			System.out.println("Paper 3 row in the excel sheet is empty for the following "+ regno +" number please check the excel sheet");
				
	// 	}

	// 	try {

	// 		PraticalExamTotal = objectToDataType(praticalExam);

	// 		if (PraticalExamTotal < 150) {
	// 			System.out.println("The following Registration number " + regno + " is Failed in Pratical Exam");
	// 			System.out.println(PraticalExamTotal);
	// 		}

	// 		else if (PraticalExamTotal >= 150) {
	// 			System.out.println("The following Registration number " + regno + " is Passed in Practical Exam");
	// 			System.out.println(PraticalExamTotal);
	// 		}

	// 	}

	// 	catch (Exception e) {
		
	// 			System.out.println("Pratical Exam row in the excel sheet is empty for the following "+ regno +" number please check the excel sheet");
				
		
	// 	}

	// 	try {

	// 		TheroryExamTotal = Paper1 + Paper2 + Paper3;

	// 		TheroryExamTotal = objectToDataType(examTotal);

	// 		if (TheroryExamTotal < 150) {
	// 			System.out.println("The following Registration number " + regno + " is Failed in Therory Exam");
	// 			System.out.println(TheroryExamTotal);
	// 		}

	// 		else if (TheroryExamTotal >= 150) {
	// 			System.out.println("The following Registration number " + regno + " is Passed in Therory Exam");
	// 			System.out.println(TheroryExamTotal);
	// 		}
	// 	}

	// 	catch (Exception e) {
	
	// 			System.out.println("Therory Exam row in the excel sheet is empty for the following "+ regno +" number please check the excel sheet");
				
		
	// 	}

	// 	// System.out.println(studentData);
	// 	if (regno == null) {

	// 		System.out.println("No data in Excel file. Stopping execution.");

	// 	} else {

	// 		implicitWait( 5000);
	// 		Thread.sleep(5000);

	// 	}
		
	// 	try {

	// 		ExamTotalScore = TheroryExamTotal + PraticalExamTotal;

	// 		ExamTotalScore = objectToDataType(examTotal);

	// 		if (ExamTotalScore < 300) {
	// 			System.out.println("The following Registration number " + regno + " is Failed ");
	// 			System.out.println(ExamTotalScore);
	// 		}

	// 		else if (ExamTotalScore >= 300) {
	// 			System.out.println("The following Registration number " + regno + " is Passed ");
	// 			System.out.println(ExamTotalScore);
	// 		}
	// 	}

	// 	catch (Exception e) {
	
	// 			System.out.println("Exam Total row in the excel sheet is empty for the following "+ regno +" number please check the excel sheet");
				
	// 	}

	// }	
	
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
	}}
