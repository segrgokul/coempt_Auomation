package runner_Execution;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import browsers.BrowserManager;
import dataProcessing.ReadPdfData;
import pageModules.AttendanceTheoryPage;
import pageModules.DashboardPage;
import pageModules.LoginPage;
import pageModules.MasterPage;
import pageModules.ReportCoursePage;
import pageModules.ReportEnrollmentPage;
import pageModules.ResultTRDataPage;
import pageModules.SettingsAssingCoursePage;

public class Exceution extends BrowserManager {

public Object[][] data1;
public Object[][] data2;


	 private ExtentReports extent;
	 private ExtentReporter htmlReporter;



	LoginPage login = new LoginPage();
	DashboardPage Dashboard = new DashboardPage();
	MasterPage Master = new MasterPage();
	ReportEnrollmentPage Enrollment = new  ReportEnrollmentPage();
	ReportCoursePage Coursewise = new  ReportCoursePage();
	SettingsAssingCoursePage SetAssignCourse = new SettingsAssingCoursePage();
	ResultTRDataPage TRData = new ResultTRDataPage();
	AttendanceTheoryPage Therory = new AttendanceTheoryPage();
	ReadPdfData PDF = new ReadPdfData();
	
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
@Test(priority = 1, enabled = false)
public void testCase1() throws InterruptedException, IOException {
   System.out.println("This is a Normal Test Case1");

   ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentReport.html");
   ExtentReports extent = new ExtentReports();
   extent.attachReporter(sparkReporter);
   

   ExtentTest test = extent.createTest("Sample Test", "This is a test description");
   test.pass("Test passed successfully");
   
    // Perform LoginPage Actions
	    login.DirectSignIn();
	    login.DirectPassEntry();
	    login.DirectUserEntry();

 	    // Validate Login Failures and Success
	   login.LoginInFail();
       login.Login();

//	    SetAssignCourse.check();
	    // Perform Logout and Re-login
	
//	    
//	    Therory.AttendanceMarkNavigation();
//	    Therory.TheroryAttendanceNavigation();
//	    Therory.TheroryAttendanceBrowse();
//	    TRData.ResultDeliverablesNavigation();
//	    TRData.ResultDeliverablesTRDataClgWiseNavigation();

	    test.pass("Test passed successfully done");
	}	
	


//General login and logout
@Test(priority = 2, enabled = false)
public void testCase2() throws InterruptedException, IOException {
 System.out.println("This is a Normal Test Case1");

 ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentReport.html");
 ExtentReports extent = new ExtentReports();
 extent.attachReporter(sparkReporter);
 

 ExtentTest test = extent.createTest("Sample Test", "This is a test description");
 test.pass("Test passed successfully");
 
  // Perform DashBoardPage Actions

	    login.Login();
//	    Dashboard.EntriesPerPage();
//	    Dashboard.DashBoardColumn();
//	    Dashboard.DashBoardSearch();
//	    Dashboard.PageNavigation(); 
//	    Master.MasterNavigation();
//	    Master.CollegeMasterNavigation();
//	    Master.CollegeMasterEntriesPerPage();
//	    Master.CollegeMasterColumn();
//	    Master.CollegeMasterSearch();
//	    Master.CollegeMasterPageNavigation();
	    Master.MasterNavigation();
	    Master.CourseMasterNavigation();
	    Master.CourseMasterEntriesPerPage();
	    Master.CourseMasterColumn();
	    Master.CourseMasterSearch();
	    Master.CollegeMasterPageNavigation();

	    test.pass("Test passed successfully done");
	}	
	



//for navigating to the report card to avoid the loop for the dataproviders
@Test(priority = 3, enabled = true)
public void testCase3() throws InterruptedException, IOException {
   System.out.println("This is a Normal Test Case2");
   Browser_Launch();
	login.Login();

    // Navigate to Course Report Card
    Coursewise.ReportCardNavigation();

   
}
	

@Test(priority = 4, enabled = false, dataProvider = "course")
public void testCase4(Object clgCode,Object examdate, Object awardName,Object regulation,Object semester , Object examType,Object programcourse) throws IOException, InterruptedException, InvalidFormatException {

    System.out.println("Starting testCase4 execution for: " + examdate);
	

    Coursewise.ReportCardCourseNavigation();

    // Handle College Code
    Coursewise.handleCollegeCode(clgCode);

    // Process other details dynamically

	Coursewise.handleOtherParameters(examdate, awardName,regulation,semester,examType);
    System.out.println("Reached end of testCase3 execution for: " + examType);
	Coursewise.handleProgramCourse(programcourse);
	
	Enrollment.submitButton();
	Enrollment.DownloadReport();

//	PDF.validatePDF(null);
}
	
	
	
	
@Test(priority = 5, enabled = true, dataProvider = "excel")
public void testCase5(Object Regno, Object examdate, Object awardName, Object semester, 
                      Object regulation, Object examType, Object paper1, 
                      Object paper2, Object paper3, Object theroryExam, 
                      Object praticalExam, Object examTotal) 
                      throws InterruptedException, IOException {
	
	System.out.println("=========================");
	System.out.println("This is a Normal Test Case5");
    System.out.println("Starting testCase5 execution for: " + Regno);
    System.out.println("=========================");
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
	
	Enrollment.DownloadReportValidation();
	Enrollment.checkPaper1Result(Regno, paper1);
	Enrollment.checkPaper2Result(Regno, paper2);
	Enrollment.checkPaper3Result(Regno, paper3);
	Enrollment.checkPracticalExamResult(Regno, praticalExam);
	Enrollment.checkTheoryExamResult(Regno,theroryExam);
	Enrollment.checkFinalExamResult(Regno,examTotal);

//Need to Create the separte methos in one class for the below ones exam,awardName,etcc

    // Handle other details like exam date, award name, semester, etc.
 //   Enrollment.processOtherDetails(examdate, awardName, semester, regulation, examType);

    // Validate paper results and scores
 //  Enrollment.validatePaperResults(Regno, paper1, paper2, paper3, praticalExam, theroryExam, examTotal);

	System.out.println("=====================");
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
		  // Set up ExtentReports
     
	}

	@AfterClass
	public void afterClass() {
		System.out.println("This will execute after the Class");

	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("This will execute second before the Test and after the before test suite");
	  // Check if the driver is not already initialized
			
		
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("This will execute after the Test");
		
//			driver.quit();  // Ensure the browser is closed after the test
		
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
