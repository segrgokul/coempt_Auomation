package runner_Execution;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import browsers.BrowserManager;
import pageModules.LoginPage;
import pageModules.ReportCoursePage;
import pageModules.ReportEnrollmentPage;
import pageModules.SettingsAssingCoursePage;

public class Exceution extends BrowserManager {

public Object[][] data1;
public Object[][] data2;

	public static WebDriver driver;

	LoginPage login = new LoginPage();
	ReportEnrollmentPage Enrollment = new  ReportEnrollmentPage();
	ReportCoursePage Coursewise = new  ReportCoursePage();
	SettingsAssingCoursePage SetAssignCourse = new SettingsAssingCoursePage();
	
	
	@DataProvider(name ="excel")
	public Object[][]ReadExcelEnroll() throws IOException,InvalidFormatException {
		
//		Object[][] data = dataProcessing.ReadExcelFiles.readExcel("file1","file1");
	
		data1 = dataProcessing.ReadExcelFiles.readExcel("excel.file1", "excel.file1");

		
		
//	System.out.println("Data size: " + data.length);
for (Object[] row : data1) {
//    System.out.println(Arrays.toString(row));
}
return data1;
	} 
	
	
	@DataProvider(name ="course")
	public Object[][]ReadExcelCourse() throws IOException,InvalidFormatException {
		
//		Object[][] data = dataProcessing.ReadExcelFiles.readExcel("file1","file1");
	
	

		data2= dataProcessing.ReadExcelFiles.readExcel("excel.file2", "excel.file2");
		
//	System.out.println("Data size: " + data.length);
for (Object[] row : data2) {
//    System.out.println(Arrays.toString(row));
}
return data2;
	} 

	
//General login and logout
@Test(priority = 1, enabled = true)
public void testCase1() throws InterruptedException {
   System.out.println("This is a Normal Test Case1");

    // Perform Login Actions
	    login.DirectSignIn();
	    login.DirectPassEntry();
	    login.DirectUserEntry();

//	    // Validate Login Failures and Success
	   login.LoginInFail();
	    login.Login();

	    // Perform Logout and Re-login
	    login.Logout();

	}	
	
//for navigating to the report card to avoid the loop for the dataproviders
@Test(priority = 2, enabled = true)
public void testCase2() throws InterruptedException {
   System.out.println("This is a Normal Test Case2");

	login.Login();

    // Navigate to Course Report Card
    Coursewise.ReportCardNavigation();

   
}
	

@Test(priority = 3, enabled = true, dataProvider = "course")
public void testCase3(Object clgCode,Object examdate, Object awardName,Object regulation,Object semester , Object examType,Object programcourse) throws IOException, InterruptedException {

    System.out.println("Starting testCase3 execution for: " + examdate);
	

    Coursewise.ReportCardCourseNavigation();

    // Handle College Code
    Coursewise.handleCollegeCode(clgCode);

    // Process other details dynamically

	Coursewise.handleOtherParameters(examdate, awardName,regulation,semester,examType);
    System.out.println("Reached end of testCase3 execution for: " + examType);
	Coursewise.handleProgramCourse(programcourse);

	Enrollment.submitButton();

}
	
	
	
	
@Test(priority = 4, enabled = true, dataProvider = "excel")
public void testCase4(Object Regno, Object examdate, Object awardName, Object semester, 
                      Object regulation, Object examType, Object paper1, 
                      Object paper2, Object paper3, Object theroryExam, 
                      Object praticalExam, Object examTotal) 
                      throws InterruptedException, IOException {

    System.out.println("Starting testCase4 execution for: " + Regno);

    // Navigate to the Enrollment Page
    Enrollment.ReportCardEnrollNavigation();

// //Need to Create the separte methos in one class for the below ones exam,awardName,etcc
    // Process Registration Number
    Enrollment.EnrollmentRegNo(Regno);
	Enrollment.EnrollmentExamDate(examdate);
	Enrollment.EnrollmentAwardName(awardName);
	Enrollment.EnrollmentSemester(semester);
	Enrollment.EnrollmentRegulation(regulation);
	Enrollment.EnrollmentExamType(examType);
	Enrollment.submitButton();
	Enrollment.DownloadReport();
	Enrollment.Paper1(Regno, paper1);
	Enrollment.Paper2(Regno, paper2);
	Enrollment.Paper3(Regno, paper3);
	Enrollment.PraticalExam(Regno, praticalExam);
	Enrollment.TheoryExam(Regno, theroryExam);
	Enrollment.ExamTotalScore(Regno, examTotal);
//Need to Create the separte methos in one class for the below ones exam,awardName,etcc

    // Handle other details like exam date, award name, semester, etc.
 //   Enrollment.processOtherDetails(examdate, awardName, semester, regulation, examType);

    // Validate paper results and scores
 //  Enrollment.validatePaperResults(Regno, paper1, paper2, paper3, praticalExam, theroryExam, examTotal);

    System.out.println("Reached end of testCase2 execution for: " + Regno);
}




	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException {
		System.out.println("This will execute foruth before every Method and after the before class");
//		ReadExcelData.ExcelReader(C:\\Users\\User\\Downloads\\DumpScore.xlsx,"mds");
	//	ReadExcelData.getColumnData()
		
	
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
		if (driver == null) {  // Check if the driver is not already initialized
			Browser_Launch();
			System.setProperty("webdriver.chrome.logfile", "chromedriver.log");  // Launch browser only once
		}
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("This will execute after the Test");
		
			driver.quit();  // Ensure the browser is closed after the test
		
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This will execute first before the Test Suite");
//		report = new 
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("This will execute after the Test Suite");
		
	}
}
