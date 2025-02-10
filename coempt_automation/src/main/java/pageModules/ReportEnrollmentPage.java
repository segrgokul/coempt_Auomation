package pageModules;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.BasicFunctions;
import pageObjMod.pom;

public class ReportEnrollmentPage extends BasicFunctions {
	static ExtentTest test;

	double Paper1;
	double Paper2;
	double Paper3;
	double TheroryExamTotal;
	double PraticalExamTotal;
	public double ExamTotalScore;
	public Object[][] data1;
	public Object[][] data2;

	long registrationNumber;
	long securedMark;
	double paper1Mark;
	double paper2Mark;
	double paper3Mark;

	double praticalMinMark;

	double minMark;

	double theoryMinMark;
	double theoryMaxMark;
	double grandTotalMinMark;
	double grandTotalMaxMark;
	double theoryTotal;
	double praticalTotal;
	double grandTotal;
	String subject;
	// four pattern
	double theorySecMark;

	double praticalMaxMark;

	double praticalVivaMaxMark;
	double praticalTotalMaxMark;
	double praticalTotalSecMark;
	double grandTotalSecMark;

	String status;

	double theoryInternalMaxMark;
	double theoryInternalSecMark;

	private static boolean isTestCaseEnrollSet1 = false;

	public void ReportCardNavigation(ExtentTest testCaseName) throws IOException {

		ExtentTest testCaseScenario = testCaseName.createNode(" Report Card Navigation Test case has started running ");

		implicitWait(30);
		explicitWait(pom.getInstanceEnrollXP().loginTags, 30);

		if (pom.getInstanceEnrollXP().loginTags.isDisplayed()) {

//			testCaseName = extentReport.createTest("Login in Tag");

			implicitWait(30);
			explicitWait(pom.getInstanceEnrollXP().loginTags, 30);

			scroll(pom.getInstanceEnrollXP().reportCardOption);

			if (pom.getInstanceEnrollXP().reportCardOption.isDisplayed()) {

				implicitWait(30);
				explicitWait(pom.getInstanceEnrollXP().reportCardOption, 30);
				click(pom.getInstanceEnrollXP().reportCardOption);
				testCaseScenario.log(Status.PASS, "Report Card button has clicked sucessfully");
			}

			else {
				// testCaseScenario.log(Status.INFO, "Report Card is clicked sucessfully");
				testCaseScenario.log(Status.FAIL, "Report Card button has not click",
						MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());
			}

		}
	}

	public void ReportCardEnrollNavigation(ExtentTest testCaseName) throws IOException {
	    ExtentTest testCaseScenario = testCaseName
	            .createNode("Report Card Enrollment wise navigation Test case has started running");

	    implicitWait(30);

	    try {
	        explicitWait(pom.getInstanceEnrollXP().reportCardEnroll, 30);
	        scroll(pom.getInstanceEnrollXP().reportCardEnroll);

	        if (pom.getInstanceEnrollXP().reportCardEnroll.isDisplayed()) {
	            implicitWait(30);
	            explicitWait(pom.getInstanceEnrollXP().reportCardEnroll, 30);
	            click(pom.getInstanceEnrollXP().reportCardEnroll);
	            testCaseScenario.log(Status.PASS, "Report Card Enrollment wise has navigated successfully");

	        } else {
	            testCaseScenario.log(Status.FAIL, "Report Card Enrollment wise navigation failed",
	                    MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());
	        }

	    } catch (NoSuchElementException e) {
	        testCaseScenario.log(Status.FAIL, "Report Card Enrollment wise element not found",
	                MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());
	    } catch (Exception e) {
	        testCaseScenario.log(Status.FAIL, "Unexpected error: " + e.getMessage());
	    }
	}

	public void EnrollmentRegNo(Object regno, ExtentTest testCaseName) throws IOException {

	    ExtentTest testCaseScenario = testCaseName
	            .createNode("Report card Enrollment wise for the following register number: " + regno);

	    implicitWait(30);

	    try {
	        explicitWait(pom.getInstanceEnrollXP().enrollNo, 30);
	        click(pom.getInstanceEnrollXP().enrollNo);

	        if (pom.getInstanceEnrollXP().enrollNo.isDisplayed()) {
	            implicitWait(30);
	            explicitWait(pom.getInstanceEnrollXP().enrollNo, 30);
	            sendKeys(pom.getInstanceEnrollXP().enrollNo, String.valueOf(regno));
	            testCaseScenario.log(Status.PASS, "Enrollment wise " + regno + " Register number has entered successfully");

	        } else {
	            // If enrollNo is not displayed, try alternative action
	            try {
	                WebElement yearSessionOptionSelect = driver
	                        .findElement(By.xpath("//li[@role='option' and text()='Select']"));

	                if (yearSessionOptionSelect.isDisplayed()) {
	                    testCaseScenario.log(Status.FAIL, "Enrollment wise " + regno + " Register number has not entered",
	                            MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());
	                }
	            } catch (NoSuchElementException e) {
	                testCaseScenario.log(Status.FAIL, "Alternative year session option not found.");
	            }
	        }

	    } catch (Exception e) {
	        testCaseScenario.log(Status.FAIL, "Unexpected error: " + e.getMessage());
	    }
	}

	public static void EnrollmentExamDate(Object examDate, ExtentTest testCaseName) throws IOException {

	    ExtentTest testCaseScenario = testCaseName.createNode("Exam Date Test case has started running");

	    implicitWait(30);

	    try {
	        explicitWait(pom.getInstanceEnrollXP().examSeries, 30);
	        click(pom.getInstanceEnrollXP().examSeries);

	        implicitWait(30);
	        explicitWait(pom.getInstanceEnrollXP().examSeries, 30);
	        click(pom.getInstanceEnrollXP().examSeries);

	        implicitWait(30);
	        explicitWait(pom.getInstanceEnrollXP().examSeries, 30);

	        if (pom.getInstanceEnrollXP().examSeries.isDisplayed()) {
	            click(pom.getInstanceEnrollXP().examSeries);

	            implicitWait(50);

	            try {
	                // Try to find the exam date option
	                WebElement examDateOption = driver.findElement(By.xpath("//li[@role='option' and text()='" + examDate + "']"));
	                explicitWait(examDateOption, 30);

	                if (examDateOption.isDisplayed()) {
	                    explicitWait(examDateOption, 30);
	                    implicitWait(30);
	                    click(examDateOption);
	                    testCaseScenario.log(Status.PASS, "Exam date has entered successfully");
	                }

	            } catch (NoSuchElementException e) {
	                // If exam date option is not found, log failure
	                testCaseScenario.log(Status.FAIL, "Exam date selection failed: Element not found");
	            }

	        } else {
	            // If exam series dropdown is not displayed, try alternative action
	            try {
	                WebElement yearSessionOptionSelect = driver
	                        .findElement(By.xpath("//li[@role='option' and text()='Select']"));

	                if (yearSessionOptionSelect.isDisplayed()) {
	                    testCaseScenario.log(Status.FAIL, "Exam date has not entered",
	                            MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());
	                }
	            } catch (NoSuchElementException e) {
	                testCaseScenario.log(Status.FAIL, "Alternative year session option not found.");
	            }
	        }

	    } catch (Exception e) {
	        testCaseScenario.log(Status.FAIL, "Unexpected error: " + e.getMessage());
	    }
	}




	public static void EnrollmentAwardName(Object awardName, ExtentTest testCaseName) throws IOException {

	    ExtentTest testCaseScenario = testCaseName.createNode("Award Name Test case has started running");

	    implicitWait(30);
	    explicitWait(pom.getInstanceEnrollXP().awardName, 30);

	    try {
	        if (pom.getInstanceEnrollXP().awardName.isDisplayed()) {
	            click(pom.getInstanceEnrollXP().awardName);

	            try {
	                // Try to find the award option
	                WebElement awardOption = driver.findElement(By.xpath("//li[@role='option' and text()='" + awardName + "']"));

	                if (awardOption.isDisplayed()) {
	                    explicitWait(awardOption, 30);
	                    implicitWait(30);
	                    click(awardOption);
	                    testCaseScenario.log(Status.PASS, "Award name has entered successfully");
	                }

	            } catch (NoSuchElementException e) {
	                // If award option is not found, log failure
	                testCaseScenario.log(Status.FAIL, "Award name selection failed: Element not found");
	            }

	        } else {
	            // If award name dropdown is not displayed, try alternative action
	            try {
	                WebElement yearSessionOptionSelect = driver
	                        .findElement(By.xpath("//li[@role='option' and text()='Select']"));

	                if (yearSessionOptionSelect.isDisplayed()) {
	                    testCaseScenario.log(Status.FAIL, "Award name has not entered",
	                            MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());
	                }
	            } catch (NoSuchElementException e) {
	                testCaseScenario.log(Status.FAIL, "Alternative year session option not found.");
	            }
	        }

	    } catch (Exception e) {
	        testCaseScenario.log(Status.FAIL, "Unexpected error: " + e.getMessage());
	    }
	}


	public static void EnrollmentSemester(Object semester, ExtentTest testCaseName) throws IOException {

	    ExtentTest testCaseScenario = testCaseName.createNode("Semester Test case has started running");

	    implicitWait(30);
	    explicitWait(pom.getInstanceEnrollXP().yearSession, 30);

	    try {
	        if (pom.getInstanceEnrollXP().yearSession.isDisplayed()) {
	            click(pom.getInstanceEnrollXP().yearSession);
	            implicitWait(30);

	            try {
	                // Try to find the element
	                WebElement yearSessionOption = driver
	                        .findElement(By.xpath("//li[@role='option' and text()='" + semester + "']"));

	                explicitWait(yearSessionOption, 30);
	                implicitWait(30);
	                click(yearSessionOption);
	                testCaseScenario.log(Status.PASS, "Semester has entered successfully");

	            } catch (NoSuchElementException e) {
	                // If element not found, log the failure
	                testCaseScenario.log(Status.FAIL, "Semester selection failed: Element not found");
	            }

	        } else {
	            testCaseScenario.log(Status.FAIL, "Year session dropdown is not displayed");
	        }
	    } catch (Exception e) {
	        testCaseScenario.log(Status.FAIL, "Unexpected error: " + e.getMessage());
	    }
	}


	public static void EnrollmentRegulation(Object regulation, ExtentTest testCaseName) throws IOException {

	    ExtentTest testCaseScenario = testCaseName.createNode("Regulation Test case has started running");

	    implicitWait(30);
	    explicitWait(pom.getInstanceEnrollXP().regulation, 30);

	    try {
	        if (pom.getInstanceEnrollXP().regulation.isDisplayed()) {
	            click(pom.getInstanceEnrollXP().regulation);
	            implicitWait(30);

	            try {
	                // Try to find the regulation option
	                WebElement regulationOption = driver
	                        .findElement(By.xpath("//li[@role='option' and text()='" + regulation + "']"));

	                if (regulationOption.isDisplayed()) {
	                    explicitWait(regulationOption, 30);
	                    implicitWait(30);
	                    click(regulationOption);
	                    testCaseScenario.log(Status.PASS, "Regulation has entered successfully");
	                }

	            } catch (NoSuchElementException e) {
	                // If regulation option is not found, log failure
	                testCaseScenario.log(Status.FAIL, "Regulation selection failed: Element not found");
	            }

	        } else {
	            // If regulation dropdown is not displayed, try alternative action
	            try {
	                WebElement yearSessionOptionSelect = driver
	                        .findElement(By.xpath("//li[@role='option' and text()='Select']"));

	                if (yearSessionOptionSelect.isDisplayed()) {
	                    testCaseScenario.log(Status.FAIL, "Regulation has not entered",
	                            MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());
	                }
	            } catch (NoSuchElementException e) {
	                testCaseScenario.log(Status.FAIL, "Alternative year session option not found.");
	            }
	        }

	    } catch (Exception e) {
	        testCaseScenario.log(Status.FAIL, "Unexpected error: " + e.getMessage());
	    }
	}
		

	public static void EnrollmentExamType(Object examType, ExtentTest testCaseName)
	        throws InterruptedException, IOException {

	    ExtentTest testCaseScenario = testCaseName.createNode("Exam Type Test case has started running");

	    implicitWait(30);
	    explicitWait(pom.getInstanceEnrollXP().examType, 30);

	    try {
	        if (pom.getInstanceEnrollXP().examType.isDisplayed()) {
	            click(pom.getInstanceEnrollXP().examType);
	            implicitWait(30);

	            try {
	                // Try to find the exam type option
	                WebElement examTypesOption = driver.findElement(By.xpath("//li[@role='option' and text()='" + examType + "']"));

	                if (examTypesOption.isDisplayed()) {
	                    explicitWait(examTypesOption, 30);
	                    implicitWait(30);
	                    click(examTypesOption);
	                    testCaseScenario.log(Status.PASS, "Exam Type has entered successfully");
	                }

	            } catch (NoSuchElementException e) {
	                // If exam type option is not found, log failure
	                testCaseScenario.log(Status.FAIL, "Exam Type selection failed: Element not found");
	            }

	        } else {
	            // If exam type dropdown is not displayed, try alternative action
	            try {
	                WebElement yearSessionOptionSelect = driver
	                        .findElement(By.xpath("//li[@role='option' and text()='Select']"));

	                if (yearSessionOptionSelect.isDisplayed()) {
	                    testCaseScenario.log(Status.FAIL, "Exam Type has not entered",
	                            MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());
	                }
	            } catch (NoSuchElementException e) {
	                testCaseScenario.log(Status.FAIL, "Alternative year session option not found.");
	            }
	        }

	    } catch (Exception e) {
	        testCaseScenario.log(Status.FAIL, "Unexpected error: " + e.getMessage());
	    }
	}

	public void submitButton(ExtentTest testCaseName) throws InterruptedException, IOException {

		ExtentTest testCaseScenario = testCaseName.createNode(" Submit Button Test case has started running ");

		try {
		implicitWait(30);
		explicitWait(pom.getInstanceEnrollXP().submitBtn, 30);
		if (pom.getInstanceEnrollXP().submitBtn.isDisplayed()) {

			click(pom.getInstanceEnrollXP().submitBtn);
			
			try {
			explicitWait(pom.getInstanceEnrollXP().loadingScreen, 30);
			implicitWait(30);

			fluentWait(pom.getInstanceEnrollXP().loadingScreen, 30);

			testCaseScenario.log(Status.PASS, "Submit button has clicked sucessfully");
			Thread.sleep(5000);
		

			}	catch(Exception e) {
		

			testCaseScenario.log(Status.FAIL, "Submit has not clicked",
					MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

			}}
			
			else {
	            testCaseScenario.log(Status.FAIL, "Submit button not found or not clickable",
	                    MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());
	        }
			
		}
		
		
		 catch (Exception e) {
		        testCaseScenario.log(Status.FAIL, "Unexpected error: " + e.getMessage());
		    }
		}




	public void DownloadReport() {

		try {

			Actions action = new Actions(driver);

			Thread.sleep(5000);

			implicitWait(30);

//			action.moveToElement(pom.getInstanceEnrollXP().reportCardExportTo).perform();

			action.moveToElement(pom.getInstanceEnrollXP().reportCardExportTo).click().perform();

			implicitWait(30);

//			action.moveToElement(pom.getInstanceEnrollXP().reportCardExportToPdf).perform();

			action.moveToElement(pom.getInstanceEnrollXP().reportCardExportToPdf).click().perform();

			implicitWait(30);

			Thread.sleep(10000);

			// Get the parent window handle and store it in a list
			ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

			// Switch to the second window (index 1 in the list)
			driver.switchTo().window(windowHandles.get(1));

			// Perform actions in the new window/tab
			// ...
			implicitWait(60);

			driver.close();

			// Switch back to the parent window (index 0 in the list)
			driver.switchTo().window(windowHandles.get(0));

		}

		catch (Exception e) {

		}

	}

	public void downloadPdfReportValidation(ExtentTest testCaseName, Object Regno, Object paper1, Object paper2,
			Object paper3, Object theoryExam, Object praticalExam, Object examTotal, String subjectToFind)
			throws InterruptedException, IOException {

		try {

			ExtentTest testCaseScenario = testCaseName
					.createNode(" Pdf Report Validation Test case has started running");

			Actions action = new Actions(driver);

			Thread.sleep(5000);
			implicitWait(30);

			// Click on "Export To" and then "Export to PDF"
			action.moveToElement(pom.getInstanceEnrollXP().reportCardExportTo).click().perform();
			implicitWait(30);
			action.moveToElement(pom.getInstanceEnrollXP().reportCardExportToPdf).click().perform();
			implicitWait(30);

			Thread.sleep(15000);

			// Switch to the second window (new tab)
			ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(windowHandles.get(1));

			// Validate PDF URL
			implicitWait(60);
			if (driver.getCurrentUrl().endsWith(".pdf")) {
				System.out.println("PDF opened successfully: " + driver.getCurrentUrl());
				System.out.println("=========================");
				testCaseScenario.log(Status.PASS, "PDF opened successfully sucessfully" + driver.getCurrentUrl());

			} else {
				System.out.println(driver.getCurrentUrl());
				System.out.println("Failed to open the PDF.");
				testCaseScenario.log(Status.FAIL, "Failed to open the PDF.");

			}

			// Wait for the PDF file to download
			String downloadDir = System.getProperty("user.home") + "/Downloads"; // Downloads folder
			File dir = new File(downloadDir);
			File latestFile = null;
			long startTime = System.currentTimeMillis();

			// Wait for the file to download
			while (true) {
				File[] files = dir.listFiles((d, name) -> name.endsWith(".pdf"));
				if (files != null && files.length > 0) {
					Arrays.sort(files, (f1, f2) -> Long.compare(f2.lastModified(), f1.lastModified()));
					latestFile = files[0];

					break; // File is downloaded

				}

				else {
					System.out.println("Facing error");

					testCaseScenario.log(Status.FAIL, "Facing error",
							MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

				}

				Thread.sleep(1000); // Check every second
			}

			// Method to match the paterns
			processPdfBasedOnSubjectPattern(latestFile, Regno, paper1, paper2, paper3, theoryExam, praticalExam,
					examTotal, subjectToFind, testCaseName);

			// Switch back to the parent window
			driver.close();
			driver.switchTo().window(windowHandles.get(0));
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void processEightSubjectPatternPdf(Object Regno, File latestFile, Object paper1, Object paper2,
			Object paper3, Object praticalExam, Object theoryExam, Object examTotal, String subjectToFind,
			ExtentTest testCaseName) throws IOException {
		if (latestFile != null) {
			try (PDDocument document = PDDocument.load(latestFile)) {
				PDFTextStripper stripper = new PDFTextStripper();
				int totalPages = document.getNumberOfPages();
				System.out.println("Total Pages: " + totalPages);
				System.out.println("---------------------------------------------------");

				// Iterate through all pages and extract text
				for (int page = 1; page <= totalPages; page++) {
					stripper.setStartPage(page);
					stripper.setEndPage(page);

					String text = stripper.getText(document).replaceAll("[\r\n]+", "\n");
			//	System.out.println(text);
					
					System.out.println("Page " + page + ":");
					System.out.println("---------------------------------------------------");
					// Extract registration number

					Pattern registrationPattern = Pattern.compile("Registration No :\\s*(\\d+)");
					Pattern securedMarksPattern = Pattern.compile("Secured Marks\\s*:\\s*(\\d+)");

					Matcher regMatcher = registrationPattern.matcher(text);
					Matcher securedMatcher = securedMarksPattern.matcher(text);

					if (regMatcher.find()) {
						// Capture the matched number
						String extractedNumber1 = regMatcher.group(1);
						registrationNumber = Long.parseLong(extractedNumber1);

						System.out.println("Registration No: " + registrationNumber);
					}

					if (securedMatcher.find()) {
						String securedMarks = securedMatcher.group(1); // Extract the number
						securedMark = Long.parseLong(securedMarks);

						System.out.println("Secured Marks: " + securedMark);

					} else {
						System.out.println("No match found!");
					}

					List<String> subjects = new ArrayList<>();
			        List<String> marksLines = new ArrayList<>();
			        
			        StringBuilder subjectBuilder = new StringBuilder();
			        boolean isSubjectSection = false; // Flag to detect subjects

			        for (String line : text.split("\n")) {
			            line = line.trim();
			            if (line.isEmpty()) continue; // Skip empty lines

			            // If a line starts with "Theory" or "Note", stop adding subjects
			            if (line.startsWith("Theory") || line.startsWith("Note") || line.startsWith("❖")) {
			                isSubjectSection = false;
			                continue;
			            }

			            // If the line has NO numbers and is not a header, it's a subject
			            if (!line.matches(".*\\d+.*") && !line.contains(":")) {
			                isSubjectSection = true;
			                subjectBuilder.append(line).append(" ");
			            } else {
			                if (isSubjectSection && subjectBuilder.length() > 0) {
			                    subjects.add(subjectBuilder.toString().trim());
			                    subjectBuilder.setLength(0); // Reset for next subject
			                    isSubjectSection = false;
			                }
			            }
			        }

			        // Print Extracted Subjects
			        for (String subject : subjects) {
			            System.out.println(subject);
			        }
			    

					
					Pattern marksPattern = Pattern.compile("^(.*?)\\s+" + // Subject
					        "(\\d+|---|NA|AB|NE|NR|NE\\s*\\(AT\\))(?:\\s+\\(F\\))?\\s+" + // Theory Internal Max Marks
					        "(\\d+|---|NA|AB|NE|NR|NE\\s*\\(AT\\))(?:\\s+\\(F\\))?\\s+" + // Theory Internal Sec Marks
					        "(\\d+|---|NA|AB|NE|NR|NE\\s*\\(AT\\))(?:\\s+\\(F\\))?\\s+" + // Theory Univ Max Marks
					        "(\\d+|---|NA|AB|NE|NR|NE\\s*\\(AT\\))(?:\\s+\\(F\\))?\\s+" + // Theory Univ Sec Marks
					        "(\\d+|---|NA|AB|NE|NR|NE\\s*\\(AT\\))(?:\\s+\\(F\\))?\\s+" + // Practical Internal Max Marks
					        "(\\d+|---|NA|AB|NE|NR|NE\\s*\\(AT\\))(?:\\s+\\(F\\))?\\s+" + // Practical Internal Sec Marks
					        "(\\d+|---|NA|AB|NE|NR|NE\\s*\\(AT\\))(?:\\s+\\(F\\))?\\s+" + // Practical Univ Max Marks
					        "(\\d+|---|NA|AB|NE|NR|NE\\s*\\(AT\\))(?:\\s+\\(F\\))?\\s+" + // Practical Univ Sec Marks
					        "(\\d+|---|NA|AB|NE|NR|NE\\s*\\(AT\\))(?:\\s+\\(F\\))?\\s+" + // Theory + Practical Max Marks
					        "(\\d+|---|NA|AB|NE|NR|NE\\s*\\(AT\\))(?:\\s+\\(F\\))?\\s+" + // Theory + Practical Sec Marks
					        "(AP|Pass|Fail|AB|NE|NR|NE\\s*\\(AT\\)|---)$", // Status
					        Pattern.MULTILINE);

					Matcher matcher = marksPattern.matcher(text);

					
					// Extract and print each row
					while (matcher.find()) {

						System.out.println("==============");
						subject = matcher.group(1).trim();

						String theoryInternalMaxMarks = matcher.group(2);
						String theoryInternalSecMarks = matcher.group(3);
						String theoryUnivMaxMarks = matcher.group(4);
						String theoryUnivSecMarks = matcher.group(5);
						String practicalInternalMaxMarks = matcher.group(6);
						String practicalInternalSecMarks = matcher.group(7);
						String practicalUnivMaxMarks = matcher.group(8);
						String practicalUnivSecMarks = matcher.group(9);
						String theoryPracticalMaxMarks = matcher.group(10);
						String theoryPracticalSecMarks = matcher.group(11);
						status = matcher.group(12);

						System.out.println("subject: " + matcher.group(1).trim());

						// Printing the required format
						System.out.println("Theory Internal Max. Marks: " + theoryInternalMaxMarks);

						System.out.println("Theory Internal Sec. Marks: " + theoryInternalSecMarks);

						System.out.println("Theory (Univ) Max. Marks: " + theoryUnivMaxMarks);

						System.out.println("Theory (Univ) Sec. Marks: " + theoryUnivSecMarks);

						System.out.println("Practical Internal Max. Marks: " + practicalInternalMaxMarks);

						System.out.println("Practical Internal Sec. Marks: " + practicalInternalSecMarks);

						System.out.println("Practical (Univ) Max. Marks: " + practicalUnivMaxMarks);
						System.out.println("Practical (Univ) Sec. Marks: " + practicalUnivSecMarks);
						System.out.println("Theory + Practical Max. Marks: " + theoryPracticalMaxMarks);
						System.out.println("Theory + Practical Sec. Marks: " + theoryPracticalSecMarks);
						System.out.println("Status: " + status);

						paper1Mark =0.0;
						paper2Mark=0.0;
						paper3Mark =0.0;
						praticalTotalSecMark =0.0;
						ExamTotalScore =0.0;
						Paper1  =0.0;
						Paper2=0.0;
						Paper3 =0.0;
						PraticalExamTotal =0.0;
						
						
						if ((status.equals("Pass") || status.equals("Fail") || status.equals("AP"))& subject.equals(subjectToFind)) {

							try {
								
								if (!theoryInternalSecMarks.equals("NA")||!practicalUnivSecMarks.equals("AB")||!practicalUnivSecMarks.equals("NE") ||!  practicalUnivSecMarks.equals("NE (AT)")) {
								theoryInternalMaxMark = Double.parseDouble(theoryInternalMaxMarks);
								paper1Mark = Double.parseDouble(theoryInternalSecMarks);
								}
								checkMarks(Regno, "Theory Internal Sec. Marks", paper1, paper2, paper3, praticalExam,
										theoryExam, subjectToFind, examTotal, theoryInternalSecMarks,
										theoryInternalMaxMark, testCaseName);
								// Use the value
							} catch (NumberFormatException e) {

								if (theoryInternalSecMarks.equals("AB") || 
										theoryInternalSecMarks.equals("NE") || 
										theoryInternalSecMarks.equals("NE(AT)") || 
										theoryInternalSecMarks.equals("NE (AT)")) {
									paper1Mark = 0.0;
									Paper1 = 0.0;
									System.out.println(paper1Mark);

								ExtentTest testCaseScenario = testCaseName.createNode("Theory internal sec. marks validation for the subject " + subject +" Test case has started running");
								
								testCaseScenario.log(Status.PASS,"The following Register number " + Regno +" for the subject "+ subject +" theory internal sec marks is: " + theoryInternalSecMarks);
								
								System.out.println("The following Register number " + Regno +" for the subject "+ subject +" theory internal sec marks is: " + theoryInternalSecMarks);
									
							
								
								}}

							try {
								if (!theoryUnivSecMarks.equals("NA")) {
								theoryMaxMark = Double.parseDouble(theoryUnivMaxMarks);
								paper2Mark = Double.parseDouble(theoryUnivSecMarks);
								
								}
								// Check Theory (Univ) Sec. Marks
								checkMarks(Regno, "Theory (Univ) Sec. Marks", paper1, paper2, paper3, praticalExam,
										theoryExam, subjectToFind, examTotal, theoryUnivSecMarks, theoryMaxMark,
										testCaseName);

								// Use the value
							} catch (NumberFormatException e) {

								if (theoryUnivSecMarks.equals("AB") || 
										theoryUnivSecMarks.equals("NE") || 
									    theoryUnivSecMarks.equals("NE(AT)") || 
									    theoryUnivSecMarks.equals("NE (AT)")) {
									paper2Mark = 0.0;
									Paper2 =0.0;
									System.out.println(paper2Mark);
								
							
									 ExtentTest testCaseScenario = testCaseName.createNode("Theory Univ Sec. Marks Validation for the Subject "+ subject + " Test case has started running");
									
									
									 testCaseScenario.log(Status.PASS,"\n The Following Registration number " + Regno +" for the Subject "+ subject 
											 + " Therory Univ Sec. Marks is: " + theoryUnivSecMarks);
									
									 System.out.println("\nThe Following Registration number " + Regno
												+ " Therory Univ Sec. Marks is: " + theoryUnivSecMarks);
											 
								}

								}
								// Handle gracefully, e.g., assign default value or log an error

							

							try {
								if (!practicalInternalSecMarks.equals("NA")) {

								praticalMaxMark = Double.parseDouble(practicalInternalMaxMarks);
								paper3Mark = Double.parseDouble(practicalInternalSecMarks);
								Paper3 = Double.parseDouble(practicalInternalSecMarks);
								
//								System.out.println("paper 3 mark in check marks :" + paper3Mark);
//
//								System.out.println("paper 3 mark in check marks :" + Paper3);
//
//								System.out.println(Paper3);
								}
								// Use the value
								// Check pratical internal Sec. Marks
								checkMarks(Regno, "Pratical Internal Sec. Marks", paper1, paper2, paper3, praticalExam,
										theoryExam, subjectToFind, examTotal, practicalInternalSecMarks, praticalMaxMark,
										testCaseName);

							} catch (NumberFormatException e) {
							
								//if the any of the marks is this data need to convert to 0 or else it will thow error
								
								if (practicalInternalSecMarks.equals("AB") || 
										practicalInternalSecMarks.equals("NE") || 
										practicalInternalSecMarks.equals("NE(AT)") || 
										practicalInternalSecMarks.equals("NE (AT)")) {
									paper3Mark = 0.0;
									Paper3 =0.0;
									
									System.out.println(paper3Mark);
									 ExtentTest testCaseScenario = testCaseName.createNode("Pratical internal Sec. Marks Validation for the Subject "+ subject + " Test case has started running");
										
										
									 testCaseScenario.log(Status.PASS,"\n The Following Registration number " + Regno +" for the Subject "+ subject 
											 + " Practical Internal Sec. Marks is: " + practicalInternalSecMarks);
									
									 System.out.println("\nThe Following Registration number " + Regno
												+ " Practical Internal Sec. Marks is:" + practicalInternalSecMarks);
											 
								}
							}

							try {
								
								if (!practicalUnivSecMarks.equals("NA")) {
								praticalTotalMaxMark = Double.parseDouble(practicalUnivMaxMarks);
								praticalTotalSecMark = Double.parseDouble(practicalUnivSecMarks);
								}	// Use the value
								// Check pratical internal Sec. Marks
								checkMarks(Regno, "Pratical Univ Sec. Marks", paper1, paper2, paper3, praticalExam,
										theoryExam, subjectToFind, examTotal, practicalUnivSecMarks,
										praticalTotalMaxMark, testCaseName);

							} catch (NumberFormatException e) {

								if (practicalUnivSecMarks.equals("AB") || 
										practicalUnivSecMarks.equals("NE") || 
									    practicalUnivSecMarks.equals("NE(AT)") || 
									    practicalUnivSecMarks.equals("NE (AT)")) {
									praticalTotalSecMark = 0.0;
									System.out.println(praticalTotalSecMark);
								

								 ExtentTest testCaseScenario = testCaseName.createNode("Pratical Univ Sec. Marks Validation for the Subject "+ subject + " Test case has started running");
									
									
								 testCaseScenario.log(Status.PASS,"\n The Following Registration number " + Regno +" for the Subject "+ subject 
										 + " Practical Univ Sec. Marks is:" + practicalUnivSecMarks);
								
								 System.out.println("\nThe Following Registration number " + Regno
											+ " Practical Univ Sec. Marks is:" + practicalUnivSecMarks);
									
								// Handle gracefully, e.g., assign default value or log an error

							}}

							try {
								if (!theoryPracticalSecMarks.equals("NA")) {
								grandTotalMaxMark = Double.parseDouble(theoryPracticalMaxMarks);
								ExamTotalScore = Double.parseDouble(theoryPracticalSecMarks);
								}
								// Check Grand Total Sec. Marks (assumed max marks as 200)
								checkMarks(Regno, "\n Theory plus pratical Sec. Marks", paper1, paper2, paper3,
										praticalExam, theoryExam, subjectToFind, examTotal, theoryPracticalSecMarks,
										theoryInternalMaxMark, testCaseName);

								// Use the value
							} catch (NumberFormatException e) {
								if (theoryPracticalSecMarks.equals("AB") || 
										theoryPracticalSecMarks.equals("NE") || 
										theoryPracticalSecMarks.equals("NE(AT)") || 
										theoryPracticalSecMarks.equals("NE (AT)")) {
									ExamTotalScore = 0.0;
									System.out.println(ExamTotalScore);
								

									 ExtentTest testCaseScenario = testCaseName.createNode("Theory plus pratical Sec. Marks Validation for the Subject "+ subject + " Test case has started running");
										
										
									 testCaseScenario.log(Status.PASS,"\n The Following Registration number " + Regno +" for the Subject "+ subject 
											 + " Theory plus Pratical Sec. Marks is: " + practicalUnivSecMarks);
									
									 System.out.println("\nThe Following Registration number " + Regno
												+ " Theory plus Pratical Sec. Marks is:" + practicalUnivSecMarks);
										

							}}

							// Check Theory Internal Sec. Marks

							// Stop after printing one subject
						}

					}

				}

				// Check for invalid marks before parsing
			}
		}
	    System.out.println("==============");
     	securedMarks(Regno,examTotal,testCaseName);
        System.out.println("==============");
	}
	public void processFourSubjectPatternPdf(Object Regno, File latestFile, Object paper1, Object paper2, Object paper3,
			Object praticalExam, Object theoryExam, Object examTotal, String subjectToFind, ExtentTest testCaseName)
			throws IOException {
		if (latestFile != null) {
			try (PDDocument document = PDDocument.load(latestFile)) {
				PDFTextStripper stripper = new PDFTextStripper();
				int totalPages = document.getNumberOfPages();
				System.out.println("Total Pages: " + totalPages);
				System.out.println("---------------------------------------------------");

				// Iterate through all pages and extract text
				for (int page = 1; page <= totalPages; page++) {
					stripper.setStartPage(page);
					stripper.setEndPage(page);

					String text = stripper.getText(document).replaceAll("[\r\n]+", "\n");
					System.out.println("Page " + page + ":");
					System.out.println("---------------------------------------------------");
					// Extract registration number

					Pattern registrationPattern = Pattern.compile("Registration No :\\s*(\\d+)");
					Pattern securedMarksPattern = Pattern.compile("Secured Marks\\s*:\\s*(\\d+)");

					Matcher regMatcher = registrationPattern.matcher(text);
					Matcher securedMatcher = securedMarksPattern.matcher(text);

					if (regMatcher.find()) {
						// Capture the matched number
						String extractedNumber1 = regMatcher.group(1);
						registrationNumber = Long.parseLong(extractedNumber1);

						System.out.println("Registration No: " + registrationNumber);
					}

					if (securedMatcher.find()) {
						String securedMarks = securedMatcher.group(1); // Extract the number
						securedMark = Long.parseLong(securedMarks);

						System.out.println("Secured Marks: " + securedMark);

					} else {
						System.out.println("No match found!");
					}

					Pattern fourPattern = Pattern.compile("^(.*?)\\s+" + // Subject name (Group 1)
							"(\\d+)\\s+(\\d+|NA)\\s+" + // Theory Max Marks (Group 2) | Theory Sec Marks (Group 3)
							"(NA|\\d+)\\s+(NA|\\d+)\\s+" + // Practical Max Marks (Group 4) | Practical Sec Marks (Group
															// 5)
							"(NA|\\d+)\\s+(NA|\\d+)\\s+" + // Practical+Viva Max Marks (Group 6) | Practical+Viva Sec
															// Marks (Group
															// 7)
							"(\\d+)\\s+(\\d+)\\s+" + // Grand Total Max Marks (Group 8) | Grand Total Sec Marks (Group
														// 9)
							"(Pass|Fail|AP|NE|AB)", // Status
							Pattern.DOTALL);

					// Extract and print each row

					Matcher fourPatternMatcher = fourPattern.matcher(text);

					while (fourPatternMatcher.find()) {

						subject = fourPatternMatcher.group(1);

						String theoryMaxMarks = fourPatternMatcher.group(2); // Take the last part

						String theorySecMarks = fourPatternMatcher.group(3);
						String praticalMaxMarks = fourPatternMatcher.group(4);
						String praticalVivaMaxMarks = fourPatternMatcher.group(5);
						String praticalTotalMaxMarks = fourPatternMatcher.group(6);
						String praticalTotalSecMarks = fourPatternMatcher.group(7);
						String grandTotalMaxMarks = fourPatternMatcher.group(8);
						String grandTotalSecMarks = fourPatternMatcher.group(9);
						status = fourPatternMatcher.group(10);

						// Check if this is the subject we are looking for

						System.out.println("==============");

						System.out.println("Subject: " + subject); // Subject name + Theory Max Marks
						System.out.println("Theory Max Marks: " + theoryMaxMarks);

						System.out.println("Theory Sec Marks: " + theorySecMarks);
						System.out.println("Practical Max Marks: " + praticalMaxMarks);

						// Check if group(6) exists (to avoid IndexOutOfBoundsException)
						if (fourPatternMatcher.groupCount() >= 6) {
							System.out.println("Practical Viva Max Marks: " + praticalVivaMaxMarks);
						} else {
							System.out.println("Practical Viva Max Marks: NA"); // Handle cases where it's missing
						}

						// Practical Total Marks
						System.out.println("Practical Total Max Marks: " + praticalTotalMaxMarks);
						System.out.println("Practical Total Sec Marks: " + praticalTotalSecMarks);

						// Grand Total
						System.out.println("Grand Total Max Marks: " + grandTotalMaxMarks);
						System.out.println("Grand Total Sec Marks: " + grandTotalSecMarks);

						// Status
						System.out.println("Status: " + status);
						System.out.println("==============");

						if (status.equals("Pass") || status.equals("Fail") || status.equals("AP")) {

							try {
								theoryInternalMaxMark = Double.parseDouble(theoryMaxMarks);

								System.out.println(theoryInternalMaxMark);

								paper1Mark = Double.parseDouble(theorySecMarks);

								System.out.println(paper1Mark);

								checkMarks(Regno, "Theory Internal Sec Marks", paper1, paper2, paper3, praticalExam,
										theoryExam, subjectToFind, examTotal, theorySecMarks, theoryInternalMaxMark,
										testCaseName);
								// Use the value

							} catch (NumberFormatException e) {

								System.out.println("\nThe Following Registration number " + Regno
										+ " Pratical Internal Sec. Marks: " + theorySecMarks);
							}
							/*
							 * try { theoryMaxMark = Double.parseDouble(theoryUnivMaxMarks); paper2Mark =
							 * Double.parseDouble(theoryUnivSecMarks);
							 * 
							 * // Check Theory (Univ) Sec. Marks checkMarks(Regno,
							 * "Theory (Univ) Sec. Marks", paper1, paper2, paper3, praticalExam, theoryExam,
							 * subjectToFind, examTotal, theoryInternalSecMarks, theoryInternalMaxMark,
							 * testCaseName);
							 * 
							 * // Use the value } catch (NumberFormatException e) {
							 * 
							 * System.out.println("\nThe Following Registration number " + Regno +
							 * " Therory Univ Sec. Marks:" + theoryUnivSecMarks); // Handle gracefully,
							 * e.g., assign default value or log an error
							 * 
							 * }
							 * 
							 * try { praticalMaxMark = Double.parseDouble(practicalInternalMaxMarks);
							 * paper3Mark = Double.parseDouble(practicalInternalSecMarks); // Use the value
							 * // Check pratical internal Sec. Marks checkMarks(Regno,
							 * "Pratical Internal Sec. Marks", paper1, paper2, paper3, praticalExam,
							 * theoryExam, subjectToFind, examTotal, theoryInternalSecMarks,
							 * theoryInternalMaxMark, testCaseName);
							 * 
							 * } catch (NumberFormatException e) {
							 * System.out.println("\nThe Following Registration number " + Regno +
							 * " Pratical Internal Sec. Marks: " + practicalInternalSecMarks); // Handle
							 * gracefully, e.g., assign default value or log an error
							 * 
							 * }
							 * 
							 * try { praticalTotalMaxMark = Double.parseDouble(practicalUnivMaxMarks);
							 * praticalTotalSecMark = Double.parseDouble(practicalUnivSecMarks); // Use the
							 * value // Check pratical internal Sec. Marks checkMarks(Regno,
							 * "Pratical (Univ)Sec. Marks", paper1, paper2, paper3, praticalExam,
							 * theoryExam, subjectToFind, examTotal, practicalUnivSecMarks,
							 * theoryInternalMaxMark, testCaseName);
							 * 
							 * } catch (NumberFormatException e) {
							 * System.out.println("\nThe Following a Registration number " + Regno +
							 * " Pratical (Univ)Sec. Marks is: " + practicalUnivSecMarks);
							 * 
							 * // Handle gracefully, e.g., assign default value or log an error
							 * 
							 * }
							 * 
							 * try { grandTotalMaxMark = Double.parseDouble(theoryPracticalMaxMarks);
							 * ExamTotalScore = Double.parseDouble(theoryPracticalSecMarks);
							 * 
							 * // Check Grand Total Sec. Marks (assumed max marks as 200) checkMarks(Regno,
							 * "\n Theory plus pratical Sec. Marks", paper1, paper2, paper3, praticalExam,
							 * theoryExam, subjectToFind, examTotal, theoryInternalSecMarks,
							 * theoryInternalMaxMark, testCaseName);
							 * 
							 * // Use the value } catch (NumberFormatException e) {
							 * 
							 * // Handle gracefully, e.g., assign default value or log an error
							 * System.out.println("\nThe Following a Registration number " + Regno +
							 * " Theory plus Pratical Sec. Marks is: " + theoryPracticalSecMarks);
							 * 
							 */ }

						// Check Theory Internal Sec. Marks

						// Stop after printing one subject
					}
				}

			}

		}

		// Check for invalid marks before parsing

//	    System.out.println("==============");
//     	securedMarks(Regno,examTotal,testCaseName);
//        System.out.println("==============");
	}

	private boolean extractAndPrintSingleSubject(String text, String subjectToFind) {
		Pattern fourPattern = Pattern.compile("^(.*?)\\s+" + // Subject name (Group 1)
				"(\\d+)\\s+(\\d+|NA)\\s+" + // Theory Max Marks (Group 2) | Theory Sec Marks (Group 3)
				"(NA|\\d+)\\s+(NA|\\d+)\\s+" + // Practical Max Marks (Group 4) | Practical Sec Marks (Group 5)
				"(NA|\\d+)\\s+(NA|\\d+)\\s+" + // Practical+Viva Max Marks (Group 6) | Practical+Viva Sec Marks (Group
												// 7)
				"(\\d+)\\s+(\\d+)\\s+" + // Grand Total Max Marks (Group 8) | Grand Total Sec Marks (Group 9)
				"(Pass|Fail|AP|NE|AB)", // Status
				Pattern.DOTALL);
		Matcher fourPatternMatcher = fourPattern.matcher(text);

		while (fourPatternMatcher.find()) {

			String subject = fourPatternMatcher.group(1);

			String theoryMaxMarks = fourPatternMatcher.group(2); // Take the last part

			String theorySecMarks = fourPatternMatcher.group(3);
			String praticalMaxMarks = fourPatternMatcher.group(4);
			String praticalVivaMaxMarks = fourPatternMatcher.group(5);
			String praticalTotalMaxMarks = fourPatternMatcher.group(6);
			String praticalTotalSecMarks = fourPatternMatcher.group(7);
			String grandTotalMaxMarks = fourPatternMatcher.group(8);
			String grandTotalSecMarks = fourPatternMatcher.group(9);
			status = fourPatternMatcher.group(10);

			// Check if this is the subject we are looking for

			System.out.println("==============");

			System.out.println("Subject: " + fourPatternMatcher.group(1)); // Subject name + Theory Max Marks
			System.out.println("Theory Max Marks: " + theoryMaxMarks);
			System.out.println("Theory Sec Marks: " + fourPatternMatcher.group(3));
			System.out.println("Practical Max Marks: " + praticalMaxMarks);

			// Check if group(6) exists (to avoid IndexOutOfBoundsException)
			if (fourPatternMatcher.groupCount() >= 6) {
				System.out.println("Practical Viva Max Marks: " + praticalVivaMaxMarks);
			} else {
				System.out.println("Practical Viva Max Marks: NA"); // Handle cases where it's missing
			}

			// Practical Total Marks
			System.out.println("Practical Total Max Marks: " + praticalTotalMaxMarks);
			System.out.println("Practical Total Sec Marks: " + praticalTotalSecMarks);

			// Grand Total
			System.out.println("Grand Total Max Marks: " + grandTotalMaxMarks);
			System.out.println("Grand Total Sec Marks: " + grandTotalSecMarks);

			// Status
			System.out.println("Status: " + status);
			System.out.println("==============");

			// Stop after printing one subject

		}

		return false; // If the subject was not found
	}

	public void processOneSubjectPaternPdf(File latestFile) {
		if (latestFile != null) {
			try (PDDocument document = PDDocument.load(latestFile)) {
				PDFTextStripper stripper = new PDFTextStripper();
				int totalPages = document.getNumberOfPages();
				System.out.println("Total Pages: " + totalPages);
				System.out.println("---------------------------------------------------");

				// Iterate through all pages and extract text
				for (int page = 1; page <= totalPages; page++) {
					stripper.setStartPage(page);
					stripper.setEndPage(page);

					String text = stripper.getText(document).replaceAll("[\r\n]+", "\n");
					System.out.println("Page " + page + ":");
					System.out.println("---------------------------------------------------");

					// Extract registration number
					Pattern registrationPattern = Pattern.compile("Registration No:\\s*(\\d+)");

					Matcher regMatcher = registrationPattern.matcher(text);

					Pattern subjectPattern = Pattern.compile("Subject\\s*Name:\\s*(.+)", Pattern.CASE_INSENSITIVE);
					Matcher subjectMatcher = subjectPattern.matcher(text);

					if (regMatcher.find()) {
						registrationNumber = Long.parseLong(regMatcher.group(1));
						System.out.println("Registration No: " + registrationNumber);
					}

					if (subjectMatcher.find()) {
						subject = subjectMatcher.group(1);
						System.out.println("Subject: " + subject);
					}

					boolean isTheory = true; // Initially, assume the first pair is Theory
					boolean isPractical = false; // Initially, assume we haven't encountered Practical marks

					// Extract max/min marks

					Pattern paperPattern = Pattern.compile(
							"(Paper\\s[IVX]+)\\s+Max\\.Marks:(\\d+)|Total\\s+Max\\.Marks:(\\d+)\\s+Min\\.Marks:(\\d+)|Max\\.Marks:(\\d+)\\s+Min\\.Marks:(\\d+)");
					Matcher paperMatcher = paperPattern.matcher(text);

					System.out.println("\n=== Paper and Total Max/Min Marks ===");
					while (paperMatcher.find()) {
						// Check if the first group is not null (Paper group)
						if (paperMatcher.group(1) != null) {
							System.out.println(paperMatcher.group(1) + " Max Marks: " + paperMatcher.group(2));
						}
						// Check if the second group is not null (Theory Max Marks and Min Marks group)
						else if (paperMatcher.group(3) != null) {
							System.out.println("Theory Max Marks: " + paperMatcher.group(3) + ", Min Marks: "
									+ paperMatcher.group(4));
							theoryMaxMark = Integer.parseInt(paperMatcher.group(3));
							theoryMinMark = Integer.parseInt(paperMatcher.group(4));

							boolean theoryMinMarkText = (!paperMatcher.group(4).isEmpty());

							// System.out.println("djfhjkhdskdfskjhfkdfjh" +theoryMinMarkText);
						}
						// Loop over the remaining groups dynamically to detect Practical Marks or Grand
						// Total
						else if (paperMatcher.group(5) != null) {
							int i = 5; // Start from group 5
							while (i < paperMatcher.groupCount()) {
								String maxMarks = paperMatcher.group(i); // Max Marks
								String minMarks = paperMatcher.group(i + 1); // Min Marks

								if (maxMarks != null && minMarks != null) {
									// Depending on the current flag, print the appropriate message
									if (isTheory) {
										System.out.println(
												"Practical Max Marks: " + maxMarks + ", Min Marks: " + minMarks);

										praticalMinMark = Integer.parseInt(minMarks);
										praticalMaxMark = Integer.parseInt(maxMarks);

										isTheory = false; // Next set will be for Practical or Grand Total
									} else if (!isTheory && !isPractical) {
										System.out.println(
												"Grand Total Max Marks " + maxMarks + ", Min Marks: " + minMarks);
										grandTotalMinMark = Integer.parseInt(minMarks);
										grandTotalMaxMark = Integer.parseInt(maxMarks);

									} else {
										System.out.println("Total Max Marks: " + maxMarks + ", Min Marks: " + minMarks);
										System.out.println(grandTotalMinMark + grandTotalMaxMark);
										System.out.println("==============");
									}
									// checkPaper1Result(registrationNumber,paper1Mark);
								}

								i += 2; // Move to the next pair of Max/Min marks
							}

						}
					}

					// Extract marks and result
					System.out.println("\n=== Marks and Results ===");
					Pattern marksPattern = Pattern.compile("(\\d+)(?:\\s+\\(F\\))?\\s+" + "(\\d+)(?:\\s+\\(F\\))?\\s+"
							+ "(\\d+)(?:\\s+\\(F\\))?\\s+" + "(\\d+)(?:\\s+\\(F\\))?\\s+" + "(\\d+)(?:\\s+\\(F\\))?\\s+"
							+ "(\\d+)(?:\\s+\\(F\\))?\\s+" + "(Pass|Fail)");
					Matcher marksMatcher = marksPattern.matcher(text);
					while (marksMatcher.find()) {
						paper1Mark = Integer.parseInt(marksMatcher.group(1));
						paper2Mark = Integer.parseInt(marksMatcher.group(2));
						paper3Mark = Integer.parseInt(marksMatcher.group(3));
						theoryTotal = Integer.parseInt(marksMatcher.group(4));
						praticalTotal = Integer.parseInt(marksMatcher.group(5));
						grandTotal = Integer.parseInt(marksMatcher.group(6));

						System.out.println("Paper I: " + paper1Mark);
						System.out.println("Paper II: " + paper2Mark);
						System.out.println("Paper III: " + paper3Mark);
						System.out.println("Theory Max Mark:" + theoryMaxMark);
						System.out.println("Theory Min Mark:" + theoryMinMark);

						System.out.println("Theory Total: " + theoryTotal);

						System.out.println("==============");

						System.out.println("Practical Max Mark:" + praticalMaxMark);
						System.out.println("Pratical Min Mark:" + praticalMinMark);
						System.out.println("Practical Total: " + praticalTotal);

						System.out.println("===============");

						System.out.println("Grand Total Max Mark:" + grandTotalMaxMark);
						System.out.println("Grand Total Min Mark:" + grandTotalMinMark);
						System.out.println("Grand Total: " + grandTotal);

						System.out.println("Result: " + marksMatcher.group(7));
					}

					System.out.println("---------------------------------------------------");

					if (page == totalPages) {
						break;
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("No PDF file found.");
		}

	}

	public void processTwoPatternPdf(File latestFile) {
		if (latestFile != null) {
			try (PDDocument document = PDDocument.load(latestFile)) {
				PDFTextStripper stripper = new PDFTextStripper();
				int totalPages = document.getNumberOfPages();
				System.out.println("Total Pages: " + totalPages);
				System.out.println("---------------------------------------------------");

				// Iterate through all pages and extract text
				for (int page = 1; page <= totalPages; page++) {
					stripper.setStartPage(page);
					stripper.setEndPage(page);

					String normalizedText = stripper.getText(document).replaceAll("[\r\n]+", "\n");
					System.out.println("Page " + page + ":");
					System.out.println("---------------------------------------------------");

					// Extract registration number
					Pattern registrationPattern = Pattern.compile("Registration No:\\s*(\\d+)");
					Matcher regMatcher = registrationPattern.matcher(normalizedText);
					if (regMatcher.find()) {
						String[] parts = regMatcher.group(1).split(":");
						for (int i = 0; i < parts.length; i++) {
							registrationNumber = Long.parseLong(parts[i]);

							// System.out.println("parts[" + i + "]: '" + parts[i] + "'");

							System.out.println("Registration No: " + registrationNumber);

						}

					}

					// Extract max/min marks
					System.out.println("\n=== Paper and Total Max/Min Marks ===");

					Pattern paperPattern = Pattern.compile(
							"(Paper\\s[IVX]+)\\s+Max\\.Marks:(\\d+)|Total\\s+Max\\.Marks:(\\d+)\\s+Min\\.Marks:(\\d+)|Max\\.Marks:(\\d+)\\s+Min\\.Marks:(\\d+)");

					Matcher paperMatcher = paperPattern.matcher(normalizedText);
					while (paperMatcher.find()) {
						if (paperMatcher.group(1) != null) {
							System.out.println(paperMatcher.group(1) + " Max Marks: " + paperMatcher.group(2));
						} else if (paperMatcher.group(3) != null) {
							System.out.println("Theory Max Marks: " + paperMatcher.group(3) + ", Min Marks: "
									+ paperMatcher.group(4));
						} else if (paperMatcher.group(5) != null) {
							System.out.println("Grand Total Max Marks: " + paperMatcher.group(5) + ", Min Marks: "
									+ paperMatcher.group(6));
						}
					}

					// Extract marks and result based on the new pattern
					System.out.println("\n=== Marks and Results ===");
					Pattern marksPattern = Pattern.compile("(\\d+)\\s+(\\d+)\\s+(Pass)");
					Matcher marksMatcher = marksPattern.matcher(normalizedText);
					if (marksMatcher.find()) {

						paper1Mark = Integer.parseInt(marksMatcher.group(1));
						grandTotal = Integer.parseInt(marksMatcher.group(2));

						System.out.println("First Number: " + paper1Mark);
						System.out.println("Grand Total: " + grandTotal);
						System.out.println("Result: " + marksMatcher.group(3));
					} else {
						System.out.println("Marks Result not found.");
					}

					System.out.println("---------------------------------------------------");

					if (page == totalPages) {
						break;
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("No PDF file found.");
		}
	}

	// Method to check if a student passed or failed in Paper 1
	public void checkPaper1Result(Object regno, Object paper1, ExtentTest testCaseName, String subjectToFind)
			throws IOException {

		try {
			if (subject.equalsIgnoreCase(subjectToFind)) {
				ExtentTest testCaseScenario = testCaseName
						.createNode(" Paper1 Validation Test case has started running");

				Paper1 = objectToDataType(paper1);
				System.out.println(Paper1);

				try {
					if (paper1Mark == Paper1) {
						System.out.println("Both Excel " + Paper1 + " and Pdf " + paper1Mark
								+ " for the following Register " + regno + " number data are same for paper 1 mark");
						testCaseScenario.log(Status.PASS, "Both Excel " + Paper1 + " and Pdf " + paper1Mark
								+ " for the following Register " + regno + " number data are same for paper 1 mark");

					}

					else {
						System.out.println("Both Excel " + Paper1 + " and Pdf " + paper1Mark + " for the following "
								+ regno + " data are not same please check Excel file or Pdf file for paper 1 mark");
						testCaseScenario.log(Status.FAIL,
								"Both Excel " + Paper1 + " and Pdf " + paper1Mark + " for the following " + regno
										+ " number data are not same for paper 1 mark",
								MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

					}

				} catch (Exception e) {
					System.out.println("Check the files for the following " + registrationNumber
							+ " registration number " + e.getMessage());
					testCaseScenario.log(Status.FAIL,
							"Check the files for the following " + registrationNumber + " registration number "
									+ e.getMessage(),
							MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

				}

				try {

					if (paper1Mark < 50 && Paper1 < 50) {
						System.out.println("The following Registration number " + registrationNumber
								+ " is failed in Paper1 exam with marks: " + paper1Mark);

						testCaseScenario.log(Status.PASS, "The following Registration number " + registrationNumber
								+ " is failed in Paper1 exam with marks: " + paper1Mark);

					} else if (paper1Mark >= 50 && Paper1 >= 50) {
						System.out.println("The following Registration number " + registrationNumber
								+ " is passed in Paper1 exam with marks: " + paper1Mark);
						testCaseScenario.log(Status.PASS, "The following Registration number " + registrationNumber
								+ " is passed in Paper1 exam with marks: " + paper1Mark);

					} else {
						System.out.println("Pdf mark is " + paper1Mark + " Excel mark is " + Paper1);
						testCaseScenario.log(Status.FAIL, "Pdf mark is " + paper1Mark + " Excel mark is " + Paper1
								+ " for the following " + regno + " number");

					}

				} catch (Exception e) {
					System.out.println("Check the files for the following " + registrationNumber
							+ " registration number " + e.getMessage());
					testCaseScenario.log(Status.FAIL,
							"Check the files for the following " + registrationNumber + " registration number "
									+ e.getMessage(),
							MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());
				}
			} else {

				System.out.println("Check the files for the following " + regno + " registration number and subject"
						+ subjectToFind);

			}
		}

		catch (Exception e) {
			e.printStackTrace();

		}
	}

	// Method to check if a student passed or failed in Paper 2
	public void checkPaper2Result(Object regno, Object paper2, ExtentTest testCaseName, String subjectToFind)
			throws IOException {

		try {

			if (subject.equalsIgnoreCase(subjectToFind)) {
				ExtentTest testCaseScenario = testCaseName
						.createNode("Paper2 Validation Test case has started running");

				Paper2 = objectToDataType(paper2);

				try {
					if (paper2Mark == Paper2) {
						System.out.println("Both Excel " + Paper2 + " and Pdf " + paper2Mark
								+ " for the following Register " + regno + " number data are same for paper 2 mark");
						testCaseScenario.log(Status.PASS, "Both Excel " + Paper2 + " and Pdf " + paper2Mark
								+ " for the following Register " + regno + " number data are same for paper 2 mark");

					}

					else {
						System.out.println("Both Excel " + Paper2 + " and Pdf " + paper2Mark + " for the following "
								+ regno + " data are not same please check Excel file or Pdf file for paper 1 mark");
						testCaseScenario.log(Status.FAIL,
								"Both Excel " + Paper2 + " and Pdf " + paper2Mark + " for the following " + regno
										+ " number data are not same for paper 2 mark",
								MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

					}

				} catch (Exception e) {
					System.out.println("Check the files for the following " + registrationNumber
							+ " registration number " + e.getMessage());
					testCaseScenario.log(Status.FAIL,
							"Check the files for the following " + registrationNumber + " registration number "
									+ e.getMessage(),
							MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

				}

				try {

					if (paper2Mark == Paper2 && paper2Mark < 50 && Paper2 < 50) {
						System.out.println("The following Registration number " + registrationNumber
								+ " is failed in Paper2 exam with marks: " + paper2Mark);

						testCaseScenario.log(Status.PASS, "The following Registration number " + registrationNumber
								+ " is failed in Paper2 exam with marks: " + paper2Mark);

					} else if (paper2Mark == Paper2 && paper2Mark >= 50 && Paper2 >= 50) {
						System.out.println("The following Registration number " + registrationNumber
								+ " is passed in Paper2 exam with marks: " + paper2Mark);

						testCaseScenario.log(Status.PASS, "The following Registration number " + registrationNumber
								+ "is passed in Paper2 exam with marks:" + paper2Mark);

					} else {
						System.out.println("Pdf mark is " + paper2Mark + " Excel mark is" + Paper2);
						testCaseScenario.log(Status.FAIL, "Pdf mark is " + paper2Mark + " Excel mark is" + Paper2,
								MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

					}

				} catch (Exception e) {
					System.out.println("Check the files for the following " + registrationNumber
							+ " registration number " + e.getMessage());
					testCaseScenario.log(Status.FAIL,
							"Check the files for the following " + registrationNumber + " registration number "
									+ e.getMessage(),
							MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

				}
			} else {

				System.out.println("Check the files for the following " + regno + " registration number and subject"
						+ subjectToFind);

			}
		}

		catch (Exception e) {
			e.printStackTrace();

		}
	}

	// Method to check if a student passed or failed in Paper 3
	public void checkPaper3Result(Object regno, Object paper3, ExtentTest testCaseName, String subjectToFind)
			throws IOException {

		try {
			if (subject.equalsIgnoreCase(subjectToFind)) {
				ExtentTest testCaseScenario = testCaseName
						.createNode("Paper3 Validation Test case has started running");

				Paper3 = objectToDataType(paper3);

				try {
					if (paper3Mark == Paper3) {
						System.out.println("Both Excel " + Paper3 + " and Pdf " + paper3Mark
								+ " for the following Register " + regno + " number data are same for paper 3 mark");
						testCaseScenario.log(Status.PASS, "Both Excel " + Paper3 + " and Pdf " + paper3Mark
								+ " for the following Register " + regno + " number data are same for paper 3 mark");
					}

					else {
						System.out.println("Both Excel " + Paper3 + " and Pdf " + paper3Mark + " for the following "
								+ regno + " data are not same please check Excel file or Pdf file for paper 3 mark");
						testCaseScenario.log(Status.FAIL,
								"Both Excel " + Paper3 + " and Pdf " + paper3Mark + " for the following " + regno
										+ "number data are not same for paper 3 mark",
								MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

					}

				} catch (Exception e) {

					System.out.println("Check the files for the following " + registrationNumber
							+ " registration number " + e.getMessage());
					testCaseScenario.log(Status.FAIL, "Check the files for the following " + registrationNumber
							+ " registration number for paper 3 mark " + e.getMessage());

				}

				try {
					if (paper3Mark < 50 && Paper3 < 50) {
						System.out.println("The following Registration number " + registrationNumber
								+ " is failed in Paper3 exam with marks: " + paper3Mark);
						testCaseScenario.log(Status.PASS, "The following Registration number " + registrationNumber
								+ " is failed in Paper3 exam with marks: " + paper3Mark);

					} else if (paper3Mark >= 50 && Paper3 >= 50) {
						System.out.println("The following Registration number " + registrationNumber
								+ " is passed in Paper3 exam with marks: " + paper3Mark);
						testCaseScenario.log(Status.PASS, "The following Registration number " + registrationNumber
								+ " is passed in Paper3 exam with marks: " + paper3Mark);

					} else {
						System.out.println("Pdf mark is " + paper3Mark + " Excel mark is" + Paper3);
						testCaseScenario.log(Status.FAIL, "Pdf mark is " + paper3Mark + " Excel mark is" + Paper3,
								MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

					}
				} catch (Exception e) {
					System.out.println("Check the files for the following " + registrationNumber
							+ " registration number " + e.getMessage());
					testCaseScenario.log(Status.FAIL,
							"Check the files for the following " + registrationNumber + " registration number "
									+ e.getMessage(),
							MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

				}
			}

			else {

				System.out.println("Check the files for the following " + regno + " registration number and subject"
						+ subjectToFind);

			}

		}

		catch (Exception e) {
			e.printStackTrace();

		}
	}

	// Method to check if a student passed or failed in the Theory Exam (Paper1 +
	// Paper2 + Paper3)
	public void checkTheoryExamResult(Object regno, Object theoryExam, ExtentTest testCaseName, String subjectToFind)
			throws IOException {

		try {

			if (subject.equalsIgnoreCase(subjectToFind)) {
				ExtentTest testCaseScenario = testCaseName
						.createNode("Therory Exam Toal Result Validation Test case has started running");

				TheroryExamTotal = Paper1 + Paper2 + Paper3;
				//

				theoryTotal = paper1Mark + paper2Mark + paper3Mark;

				Double theroryExamTotal = objectToDataType(theoryExam);

				System.out.println(theoryTotal);

				try {
					if (theoryTotal == theroryExamTotal && theoryTotal == TheroryExamTotal) {

						System.out.println("Both Excel " + theroryExamTotal + " and Pdf " + theoryTotal
								+ " for the following Register " + regno
								+ " number data are same for theory total mark");
						testCaseScenario.log(Status.PASS,
								"Both Excel " + theroryExamTotal + " and Pdf " + theoryTotal
										+ " for the following Register " + regno
										+ " number data are same for theory total mark");

					}

					else {

						System.out.println("Both Excel " + TheroryExamTotal + " and Pdf " + theoryTotal
								+ " for the following " + regno
								+ " data are not same please check Excel file or Pdf file for theory total mark");
						testCaseScenario.log(Status.FAIL,
								"Both Excel " + TheroryExamTotal + " and Pdf " + theoryTotal + " for the following "
										+ regno + " number data are not same for theory total mark",
								MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

					}

				} catch (Exception e) {
					System.out.println(
							"Check the files for the following " + regno + " registration number " + e.getMessage());
					testCaseScenario.log(Status.FAIL,
							"Check the files for the following " + regno + " registration number " + e.getMessage(),
							MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());
				}

				try {

					if (paper1Mark < 50 || paper2Mark < 50 || paper3Mark < 50 || Paper1 < 50 || Paper2 < 50
							|| Paper3 < 50) {
						System.out.println("The following Registration number " + regno
								+ " has failed in one or more papers and is therefore failed in the Theory exam:"
								+ theoryTotal);
						testCaseScenario.log(Status.PASS, "The following Registration number " + regno
								+ " has failed in one or more papers and is therefore failed in the Theory exam:"
								+ theoryTotal);

					}

					else if (theoryTotal < minMark && TheroryExamTotal < minMark) {
						System.out.println("The following Registration number " + regno
								+ " is failed in Theory Exam with total marks: " + theoryTotal);

						testCaseScenario.log(Status.PASS, "The following Registration number " + regno
								+ " is failed in Theory Exam with total marks: " + theoryTotal);

					} else if (theoryTotal >= minMark && TheroryExamTotal >= minMark) {
						System.out.println("The following Registration number " + regno
								+ " is passed in Theory Exam with total marks: " + theoryTotal);

						testCaseScenario.log(Status.PASS, "The following Registration number " + regno
								+ " is passed in Theory Exam with total marks: " + theoryTotal);
					}
				} catch (Exception e) {
					System.out.println(
							"Check the files for the following " + regno + " registration number " + e.getMessage());
					testCaseScenario.log(Status.FAIL,
							"Check the files for the following " + regno + " registration number " + e.getMessage(),
							MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

				}

			} else {

				System.out.println("Check the files for the following " + regno + " registration number and subject"
						+ subjectToFind);

			}
		}

		catch (Exception e) {
			e.printStackTrace();

		}
	}

	// Method to check if a student passed or failed in the Practical Exam
	public void checkPraticalExamResult(Object regno, Object praticalExam, ExtentTest testCaseName,
			String subjectToFind) throws IOException {

		try {

			if (subject.equalsIgnoreCase(subjectToFind)) {
				ExtentTest testCaseScenario = testCaseName
						.createNode("Pratical Exam Total Result Validation Test case has started running");

				PraticalExamTotal = objectToDataType(praticalExam);

				try {
					if (praticalTotal == PraticalExamTotal) {

						System.out.println("Both Excel " + PraticalExamTotal + " and Pdf " + praticalTotal
								+ " for the following Register " + regno
								+ " number data are same for pratical total mark");
						testCaseScenario.log(Status.PASS,
								"Both Excel " + PraticalExamTotal + " and Pdf " + praticalTotal
										+ " for the following Register " + regno
										+ " number data are same for pratical total mark");

					}

					else {

						System.out.println("Both Excel " + PraticalExamTotal + " and Pdf " + praticalTotal
								+ " for the following " + regno
								+ " data are not same please check Excel file or Pdf file for pratical total mark");
						testCaseScenario.log(Status.FAIL,
								"Both Excel " + PraticalExamTotal + " and Pdf " + praticalTotal + " for the following "
										+ regno + " number data are not same for pratical total mark",
								MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

					}

				} catch (Exception e) {

					System.out.println(
							"Check the files for the following " + regno + " registration number " + e.getMessage());
					testCaseScenario.log(Status.FAIL,
							"Check the files for the following " + regno + " registration number " + e.getMessage(),
							MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

				}

				try {

					if (praticalTotal < praticalMinMark && PraticalExamTotal < praticalMinMark) {
						System.out.println("The following Registration number " + regno
								+ " is failed in Practical Exam with marks: " + praticalTotal);

					} else if (praticalTotal >= praticalMinMark && PraticalExamTotal >= praticalMinMark) {
						System.out.println("The following Registration number " + regno
								+ " is passed in Practical Exam with marks: " + praticalTotal);

					}
				} catch (Exception e) {

					System.out.println(
							"Check the files for the following " + regno + " registration number " + e.getMessage());
					testCaseScenario.log(Status.FAIL,
							"Check the files for the following " + regno + " registration number " + e.getMessage(),
							MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());
				}

			}

			else {

				System.out.println("Check the files for the following " + regno + " registration number and subject"
						+ subjectToFind);

			}
		}

		catch (Exception e) {
			e.printStackTrace();

		}

	}

	// Method to check the final result (Theory Exam + Practical Exam)
	public void checkFinalExamResult(Object regno, Object examTotal, ExtentTest testCaseName, String subjectToFind)
			throws IOException {

		try {

			if (subject.equalsIgnoreCase(subjectToFind)) {
				ExtentTest testCaseScenario = testCaseName
						.createNode("Grand Total Exam Result Validation Test case has started running");
				// Calculate total score (Theory + Practical)
				ExamTotalScore = TheroryExamTotal + PraticalExamTotal;

				grandTotal = theoryTotal + praticalTotal;

				double grandTotalScore = objectToDataType(examTotal);

				try {
					if (grandTotal == ExamTotalScore) {

						System.out.println("Both Excel " + grandTotalScore + " and Pdf " + grandTotal
								+ " for the following Register " + regno
								+ " number data are same for grand total mark");
						testCaseScenario.log(Status.PASS,
								"Both Excel " + grandTotalScore + " and Pdf " + grandTotal
										+ " for the following Register " + regno
										+ " number data are same for grand total mark");
					}

					else {

						System.out.println("Both Excel " + ExamTotalScore + " and Pdf " + grandTotal
								+ " for the following " + regno
								+ " data are not same please check Excel file or Pdf file for grand total mark");
						testCaseScenario.log(Status.FAIL,
								"Both Excel " + ExamTotalScore + " and Pdf " + grandTotal + " for the following "
										+ regno + " number data are not same for grand total mark",
								MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

					}

				} catch (Exception e) {
					System.out.println(
							"Check the files for the following " + regno + " registration number " + e.getMessage());
					testCaseScenario.log(Status.FAIL,
							"Check the files for the following " + regno + " registration number " + e.getMessage(),
							MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

				}

				try {

					if (paper1Mark < 50 || paper2Mark < 50 || paper3Mark < 50 || Paper1 < 50 || Paper2 < 50
							|| Paper3 < 50 || PraticalExamTotal < praticalMinMark || praticalTotal < praticalMinMark
							|| grandTotal < grandTotalMinMark || grandTotal < grandTotalMinMark) {
						System.out.println("The following Registration number " + regno
								+ " has failed in one or more papers and is therefore failed in the final exam:"
								+ grandTotal);

						testCaseScenario.log(Status.PASS,
								"The following Registration number " + regno
										+ " has failed in one or more papers and is therefore failed in the final exam:"
										+ grandTotal);

					}
					// If total marks are above 300 but failed in individual papers, still fail
					else if (grandTotal < grandTotalMinMark && ExamTotalScore < grandTotalMinMark) {
						System.out.println("The following Registration number " + regno
								+ " is failed with total score: " + grandTotal);

						testCaseScenario.log(Status.PASS, "The following Registration number " + regno
								+ " is failed with total score: " + grandTotal);

					} else {

						System.out.println("The following Registration number " + regno
								+ " is passed with total score: " + grandTotal);

						testCaseScenario.log(Status.PASS, "The following Registration number " + regno
								+ " is passed with total score: " + grandTotal);

					}
				} catch (Exception e) {

					System.out.println(
							"Check the files for the following " + regno + " registration number " + e.getMessage());
					testCaseScenario.log(Status.FAIL,
							"Check the files for the following " + regno + " registration number " + e.getMessage(),
							MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

				}
			} else {

				System.out.println("Check the files for the following " + regno + " registration number and subject"
						+ subjectToFind);
			}
		}

		catch (Exception e) {
			e.printStackTrace();

		}

	}

	// Method to automatically detect which processing method to run based on
	// pattern
	public void processPdfBasedOnSubjectPattern(File latestFile, Object Regno, Object paper1, Object paper2,
			Object paper3, Object theoryExam, Object praticalExam, Object examTotal, String subjectToFind,
			ExtentTest testCaseName) {
		if (latestFile != null) {
			try (PDDocument document = PDDocument.load(latestFile)) {
				PDFTextStripper stripper = new PDFTextStripper();
				int totalPages = document.getNumberOfPages();

				// Iterate through all pages and extract text
				for (int page = 1; page <= totalPages; page++) {
					stripper.setStartPage(page);
					stripper.setEndPage(page);

					String pdfText = stripper.getText(document);

					// System.out.println(pdfText);

					String text = stripper.getText(document).replaceAll("[\r\n]+", "\n");

					Pattern eightSubjectPattern = Pattern.compile("^(.*?)\\s+" + // subject
							"(\\d+|---|NA|AB|NE|NR|NE\\(AT\\))(?:\\s+\\(F\\))?\\s+" + // Theory Internal Max Marks
							"(\\d+|---|NA|AB|NE|NR|NE\\(AT\\))(?:\\s+\\(F\\))?\\s+" + // Theory Internal Sec Marks
							"(\\d+|---|NA|AB|NE|NR|NE\\(AT\\))(?:\\s+\\(F\\))?\\s+" + // Theory Univ Max Marks
							"(\\d+|---|NA|AB|NE|NR|NE\\(AT\\))(?:\\s+\\(F\\))?\\s+" + // Theory Univ Sec Marks
							"(\\d+|---|NA|AB|NE|NR|NE\\(AT\\))(?:\\s+\\(F\\))?\\s+" + // Practical Internal Max Marks
							"(\\d+|---|NA|AB|NE|NR|NE\\(AT\\))(?:\\s+\\(F\\))?\\s+" + // Practical Internal Sec Marks
							"(\\d+|---|NA|AB|NE|NR|NE\\(AT\\))(?:\\s+\\(F\\))?\\s+" + // Practical Univ Max Marks
							"(\\d+|---|NA|AB|NE|NR|NE\\(AT\\))(?:\\s+\\(F\\))?\\s+" + // Practical Univ Sec Marks
							"(\\d+|---|NA|AB|NE|NR|NE\\(AT\\))(?:\\s+\\(F\\))?\\s+" + // Theory + Practical Max Marks
							"(\\d+|---|NA|AB|NE|NR|NE\\(AT\\))(?:\\s+\\(F\\))?\\s+" + // Theory + Practical Sec Marks
							"(AP|Pass|Fail|AB|NE|NR|NE\\(AT\\)|---)$", // Status
							Pattern.MULTILINE);

					Matcher eightSubjectPatternMatcher = eightSubjectPattern.matcher(text);

					Pattern fourPattern = Pattern.compile("^((?:.*?)\\s+)?" + // Optional subject (0 or 1 occurrence of
																				// subject name followed by space)
							"((?:\\d+|---|NA|AB|NE|NR|NE\\(AT\\))(?:\\s+\\(F\\))?\\s+){6,7}" + // Match 6 or 7 marks
																								// fields
							"(\\d+)?\\s+" + // Optional total marks field (e.g., 100 or 55)
							"(AP|Pass|Fail|AB|NE|NR|NE\\(AT\\)|---)$", // Status
							Pattern.MULTILINE);
					Matcher fourPatternMatcher = fourPattern.matcher(text);

					// Check for a match with the "three" pattern first
					Pattern oneSubjectPattern = Pattern.compile("(\\d+)(?:\\s+\\(F\\))?\\s+"
							+ "(\\d+)(?:\\s+\\(F\\))?\\s+" + "(\\d+)(?:\\s+\\(F\\))?\\s+" + "(\\d+)(?:\\s+\\(F\\))?\\s+"
							+ "(\\d+)(?:\\s+\\(F\\))?\\s+" + "(\\d+)(?:\\s+\\(F\\))?\\s+" + "(Pass|Fail)");
					Matcher oneSubjectPatternMatcher = oneSubjectPattern.matcher(text);

					Pattern twoPattern = Pattern.compile("(\\d+)\\s+(\\d+)\\s+(Pass)");
					Matcher twoPatternMatcher = twoPattern.matcher(text);

					if (eightSubjectPatternMatcher.find()) {

						System.out.println("Pattern matched: 8 subject pattern detected.");

						processEightSubjectPatternPdf(Regno, latestFile, paper1, paper2, paper3, praticalExam,
								theoryExam, examTotal, subjectToFind, testCaseName);
						// processFourPatternValidation(Regno,paper1,paper2,paper3,theroryExam,praticalExam,examTotal,testCaseName);
						// Exit once the matching method is called
						return;

					}

					else if (fourPatternMatcher.find()) {

						System.out.println("Pattern matched: Four patterns detected.");
						System.out.println("Matched by FourPattern: " + fourPatternMatcher.group());

						processFourSubjectPatternPdf(Regno, latestFile, paper1, paper2, paper3, praticalExam,
								theoryExam, examTotal, subjectToFind, testCaseName);
						// Exit once the matching method is called
						return;
					} else if (oneSubjectPatternMatcher.find()) {
						// If it matches, call the method for oneSubject patterns

						System.out.println("Pattern matched: 1 subject pattern detected.");

						processOneSubjectPaternPdf(latestFile);
						processOneSubjectPaternValiation(Regno, paper1, paper2, paper3, theoryExam, praticalExam,
								examTotal, testCaseName, subjectToFind);

						// Exit once the matching method is called
						return;
					}
					// Otherwise, check for the "two" pattern

					else if (twoPatternMatcher.find()) {
						// If it matches, call the method for two patterns
						System.out.println("Pattern matched: Two patterns detected.");
						processTwoPatternPdf(latestFile);
						// Exit once the matching method is called
						return;
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("No PDF file found.");
		}
	}

	public void processOneSubjectPaternValiation(Object Regno, Object paper1, Object paper2, Object paper3,
			Object theroryExam, Object praticalExam, Object examTotal, ExtentTest testCaseName, String subjectToFind)
			throws IOException {

		checkPaper1Result(Regno, paper1, testCaseName, subjectToFind);

		implicitWait(30);
		checkPaper2Result(Regno, paper2, testCaseName, subjectToFind);
		implicitWait(30);
		checkPaper3Result(Regno, paper3, testCaseName, subjectToFind);
		implicitWait(30);
		checkPraticalExamResult(Regno, praticalExam, testCaseName, subjectToFind);
		implicitWait(30);

		checkTheoryExamResult(Regno, theroryExam, testCaseName, subjectToFind);
		implicitWait(30);
		checkFinalExamResult(Regno, examTotal, testCaseName, subjectToFind);

	}

	public void processFourPatternValidation(Object Regno, Object paper1, Object paper2, Object paper3,
			Object theroryExam, Object praticalExam, Object examTotal, String subjectToFind, ExtentTest testCaseName)
			throws IOException {

		theorySecMarks(Regno, paper1, testCaseName);
		implicitWait(30);

	}

	public void processEightSubjectPatternValidation(Object Regno, Object paper1, Object paper2, Object paper3,
			Object theroryExam, Object praticalExam, Object examTotal, ExtentTest testCaseName) throws IOException {

	}

	public void theorySecMarks(Object Regno, Object paper1, ExtentTest testCaseName) throws IOException {

		ExtentTest testCaseScenario = testCaseName
				.createNode("Four Pattern Theory Sec Marks Validation Test case has started running");

		Paper1 = objectToDataType(paper1);
		System.out.println(Paper1);

		minMark = 0.5 * theoryMaxMark;

		System.out.println(minMark);
		try {
			if (theorySecMark == Paper1) {
				System.out.println("Both Excel " + Paper1 + " and Pdf " + theorySecMark + " for the following Register "
						+ Regno + " number data are same for paper 1 mark");
				testCaseScenario.log(Status.PASS, "Both Excel " + Paper1 + " and Pdf " + theorySecMark
						+ " for the following Register " + Regno + " number data are same for paper 1 mark");

			}

			else {
				System.out.println("Both Excel " + Paper1 + " and Pdf " + theorySecMark + " for the following " + Regno
						+ " data are not same please check Excel file or Pdf file for paper 1 mark");
				testCaseScenario.log(Status.FAIL,
						"Both Excel " + theorySecMark + " and Pdf " + paper1Mark + " for the following " + Regno
								+ " number data are not same for paper 1 mark",
						MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

			}

		} catch (Exception e) {
			System.out.println("Check the files for the following " + Regno + " registration number " + e.getMessage());
			testCaseScenario.log(Status.FAIL,
					"Check the files for the following " + Regno + " registration number " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

		}

		try {

			if ((theorySecMark < minMark) && (Paper1 < minMark)) {
				System.out.println("The following Registration number " + Regno
						+ " is failed in Paper1 exam with marks: " + theorySecMark);

				testCaseScenario.log(Status.PASS, "The following Registration number " + Regno
						+ " is failed in Paper1 exam with marks: " + theorySecMark);

			} else if ((theorySecMark >= minMark) && (Paper1 >= minMark)) {
				System.out.println("The following Registration number " + Regno
						+ " is passed in Paper1 exam with marks: " + theorySecMark);
				testCaseScenario.log(Status.PASS, "The following Registration number " + Regno
						+ " is passed in Paper1 exam with marks: " + theorySecMark);

			} else {
				System.out.println("Pdf mark is " + theorySecMark + " Excel mark is " + Paper1);
				testCaseScenario.log(Status.FAIL, "Pdf mark is " + theorySecMark + " Excel mark is " + Paper1
						+ " for the following " + Regno + " number");

			}

		} catch (Exception e) {
			System.out.println("Check the files for the following " + Regno + " registration number " + e.getMessage());
			testCaseScenario.log(Status.FAIL,
					"Check the files for the following " + Regno + " registration number " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());
		}
	}

	public void theoryInternalSecMarks(Object regno, String markName, Object paper1, String subjectToFind,
			ExtentTest testCaseName) throws IOException {

		try {
			if (subject.equalsIgnoreCase(subjectToFind)) {
				ExtentTest testCaseScenario = testCaseName.createNode(
						markName + " for the Subject " + subjectToFind + " Validation Test case has started running");

				Paper1 = objectToDataType(paper1);

				minMark = theoryInternalMaxMark * 0.5;

				try {
					if (paper1Mark == Paper1) {
						System.out.println(
								"Both Excel " + Paper1 + " and Pdf " + paper1Mark + " for the following Register "
										+ regno + " number data are same for Theory Internal Sec mark");
						testCaseScenario.log(Status.PASS,
								"Both Excel " + Paper1 + " and Pdf " + paper1Mark + " for the following Register "
										+ regno + " number data are same for Theory Internal Sec mark");

					}

					else {
						System.out.println("Both Excel " + Paper1 + " and Pdf " + paper1Mark + " for the following "
								+ regno
								+ " data are not same please check Excel file or Pdf file for Theory Internal Sec Marks");
						testCaseScenario.log(Status.FAIL,
								"Both Excel " + Paper1 + " and Pdf " + paper1Mark + " for the following " + regno
										+ " number data are not same for Theory Internal Sec mark",
								MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

					}

				} catch (Exception e) {
					System.out.println(
							"Check the files for the following " + regno + " registration number " + e.getMessage());
					testCaseScenario.log(Status.FAIL,
							"Check the files for the following " + regno + " registration number " + e.getMessage(),
							MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

				}

				try {

					if ((paper1Mark < minMark) && (Paper1 < minMark)) {
						System.out.println(" The following Registration number " + regno
								+ " is failed in Theory Internal Sec exam with marks in PDF: " + paper1Mark +" and in Excel: " +Paper1);

						testCaseScenario.log(Status.PASS, "The following Registration number " + regno
								+ " is failed in Theory Internal Sec exam with marks in PDF: " + paper1Mark +" and in Excel: " +Paper1);

					} else if ((paper1Mark >= minMark) && (Paper1 >= minMark)) {
						System.out.println("The following Registration number " + regno
								+ " is passed in Theory Internal Sec exam with marks in PDF: " + paper1Mark +" and in Excel: " +Paper1);
						testCaseScenario.log(Status.PASS, "The following Registration number " + regno
								+ " is passed in Theory Internal Sec exam with marks in PDF: " + paper1Mark +" and in Excel: " +Paper1);

					} else {
						System.out.println( "Check the files for the following " + regno + " registration number where Pdf mark is " + paper1Mark + " Excel mark is" + Paper1);
						testCaseScenario.log(Status.FAIL, "Check the files for the following " + regno + " registration number where Pdf mark is " + paper1Mark + " Excel mark is" + Paper1,
								MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

					}

				} catch (Exception e) {
					System.out.println(
							"Check the files for the following " + regno + " registration number " + e.getMessage());
					testCaseScenario.log(Status.FAIL,
							"Check the files for the following " + regno + " registration number " + e.getMessage(),
							MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());
				}
			}
		}

		catch (Exception e) {
			System.out.println(
					"Check the files for the following " + regno + " registration number and subject" + subjectToFind);

		}

	}

// Method to check if a student passed or failed in Paper 2
	public void theoryUnivSecMarks(Object regno, String markName, Object paper2, String subjectToFind,
			ExtentTest testCaseName) throws IOException {

		try {
			if (subject.equalsIgnoreCase(subjectToFind)) {

				ExtentTest testCaseScenario = testCaseName.createNode(
						markName + " Validation for the Subject " + subjectToFind + "Test case has started running");
				
				
				
				Paper2 = objectToDataType(paper2);

				minMark = theoryMaxMark * 0.5;

				try {
					if (paper2Mark == Paper2) {

						System.out.println(
								"Both Excel " + Paper2 + " and Pdf " + paper2Mark + " for the following Register "
										+ regno + " number data are same for Theory Univ Sec Marks");
						testCaseScenario.log(Status.PASS,
								"Both Excel " + Paper2 + " and Pdf " + paper2Mark + " for the following Register "
										+ regno + " number data are same for Theory Univ Sec mark");

					}

					else {
						System.out.println("Both Excel " + Paper2 + " and Pdf " + paper2Mark + " for the following "
								+ regno
								+ " data are not same please check Excel file or Pdf file for Theory Univ Sec mark");
						testCaseScenario.log(Status.FAIL,
								"Both Excel " + Paper2 + " and Pdf " + paper2Mark + " for the following " + regno
										+ " number data are not same for Theory Univ Sec mark",
								MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

					}

				} catch (Exception e) {
					System.out.println(
							"Check the files for the following " + regno + " registration number " + e.getMessage());
					testCaseScenario.log(Status.FAIL,
							"Check the files for the following " + regno + " registration number " + e.getMessage(),
							MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

				}

				try {

					if ((paper2Mark < minMark) && (Paper2 < minMark)) {
						System.out.println("The following Registration number " + regno
								+ " is failed in Theory Univ Sec mark exam with marks in PDF: " + paper2Mark +" and in Excel: " +Paper2);

						testCaseScenario.log(Status.PASS, "The following Registration number " + regno
								+ " is failed in Theory Univ Sec mark exam with marks in PDF: " + paper2Mark +" and in Excel: " +Paper2);

					} else if ((paper2Mark >= minMark) && (Paper2 >= minMark)) {
						System.out.println("The following Registration number " + regno
								+ " is passed in Theory Univ Sec mark exam with marks in PDF: " + paper2Mark +" and in Excel: " +Paper2);

						testCaseScenario.log(Status.PASS, "The following Registration number " + regno
								+ "is passed in Theory Univ Sec mark exam with marks in PDF: " + paper2Mark +" and in Excel: " +Paper2);

					} else {
						System.out.println( "Check the files for the following " + regno + " registration number where Pdf mark is " + paper2Mark + " Excel mark is" + Paper2);
						testCaseScenario.log(Status.FAIL, "Check the files for the following " + regno + " registration number where Pdf mark is " + paper2Mark + " Excel mark is" + Paper2,
								MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());
					}

				} catch (Exception e) {
					System.out.println(
							"Check the files for the following " + regno + " registration number " + e.getMessage());
					testCaseScenario.log(Status.FAIL,
							"Check the files for the following " + regno + " registration number " + e.getMessage(),
							MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

				}
			}

			else {

				System.out.println("Check the files for the following " + regno + " registration number and subject"
						+ subjectToFind);

			}
		}

		catch (Exception e) {
			e.printStackTrace();

		}
	}

	
	public void practicalInternalSecMarks(Object regno, String markName, Object paper3, String subjectToFind,
			ExtentTest testCaseName) throws IOException {

		try {
			if (subject.equalsIgnoreCase(subjectToFind)) {

				ExtentTest testCaseScenario = testCaseName.createNode(
						markName + " Validation for the Subject " + subjectToFind + "Test case has started running");
				
				
				
				Paper3 = objectToDataType(paper3);

				minMark = praticalMaxMark * 0.5;

				try {
					if (paper3Mark == Paper3) {

						System.out.println(
								"Both Excel " + Paper3 + " and Pdf " + paper3Mark + " for the following Register "
										+ regno + " number data are same for pratical internal Sec Marks");
						testCaseScenario.log(Status.PASS,
								"Both Excel " + Paper3 + " and Pdf " + paper3Mark + " for the following Register "
										+ regno + " number data are same for pratical internal Sec mark");

					}

					else {
						System.out.println("Both Excel " + Paper3 + " and Pdf " + paper3Mark + " for the following "
								+ regno
								+ " data are not same please check Excel file or Pdf file for pratical internal Sec mark");
						testCaseScenario.log(Status.FAIL,
								"Both Excel " + Paper3 + " and Pdf " + paper3Mark + " for the following " + regno
										+ " number data are not same for pratical internal Sec mark",
								MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

					}

				} catch (Exception e) {
					System.out.println(
							"Check the files for the following " + regno + " registration number " + e.getMessage());
					testCaseScenario.log(Status.FAIL,
							"Check the files for the following " + regno + " registration number " + e.getMessage(),
							MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

				}

				try {

					if ((paper3Mark < minMark) && (Paper3 < minMark)) {
						System.out.println("The following Registration number " + regno
								+ " is failed in pratical internal Sec mark exam with marks in PDF: " + paper3Mark +" and in Excel: " +Paper3);

						testCaseScenario.log(Status.PASS, "The following Registration number " + regno
								+ " is failed in pratical internal Sec mark exam with marks in PDF: " + paper3Mark +" and in Excel: " +Paper3);


					} else if ((paper3Mark >= minMark) && (Paper3 >= minMark)) {
						System.out.println("The following Registration number " + regno
								+ " is passed in pratical internal Sec mark exam with marks in PDF: " + paper3Mark +" and in Excel: " +Paper3);

						testCaseScenario.log(Status.PASS, "The following Registration number " + regno
								+ " is passed in pratical internal Sec mark exam with marks in PDF: " + paper3Mark +" and in Excel: " +Paper3);

						
					} else {
						System.out.println( "Check the files for the following " + regno + " registration number where Pdf mark is " + paper3Mark + " Excel mark is" + Paper3);
						testCaseScenario.log(Status.FAIL, "Check the files for the following " + regno + " registration number where Pdf mark is " + paper3Mark + " Excel mark is" + Paper3,
								MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

					}

				} catch (Exception e) {
					System.out.println(
							"Check the files for the following " + regno + " registration number " + e.getMessage());
					testCaseScenario.log(Status.FAIL,
							"Check the files for the following " + regno + " registration number " + e.getMessage(),
							MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

				}
			}

			else {

				System.out.println("Check the files for the following " + regno + " registration number and subject"
						+ subjectToFind);

			}
		}

		catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	
	
	
	
	
	
	
	
//Method to check if a student passed or failed in Paper 3
	public void praticalUnivSecMarks(Object regno, String markName, Object praticalExam, String subjectToFind,
			ExtentTest testCaseName) throws IOException {

		// Method to check if a student passed or failed in the Practical Exam

		try {
			if (subject.equals(subjectToFind)) {
				ExtentTest testCaseScenario = testCaseName.createNode(
						markName + " Validation  for the Subject " + subjectToFind + " Test case has started running");

				minMark = praticalTotalMaxMark * 0.5;

				
				
				PraticalExamTotal = objectToDataType(praticalExam);

				try {
					if (praticalTotalSecMark == PraticalExamTotal) {

						System.out.println("Both Excel " + praticalTotalSecMark + " and Pdf " + praticalTotalSecMark
								+ " for the following Register " + regno
								+ " number data are same for pratical univ sec mark");
						testCaseScenario.log(Status.PASS,
								"Both Excel " + PraticalExamTotal + " and Pdf " + praticalTotalSecMark
										+ " for the following Register " + regno
										+ " number data are same for pratical univ sec mark");

					}
					
					

					else {

						System.out.println("Both Excel " + praticalTotalSecMark + " and Pdf " + praticalTotalSecMark
								+ " for the following " + regno
								+ " data are not same please check Excel file or Pdf file for pratical univ sec mark");
						testCaseScenario.log(Status.FAIL,
								"Both Excel " + PraticalExamTotal + " and Pdf " + praticalTotalSecMark
										+ " for the following " + regno
										+ " number data are not same for pratical univ sec mark",
								MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

					}

				} catch (Exception e) {
					System.out.println( "Check the files for the following " + regno + " registration number where Pdf mark is " + praticalTotalSecMark + " Excel mark is" + PraticalExamTotal);
					testCaseScenario.log(Status.FAIL, "Check the files for the following " + regno + " registration number where Pdf mark is " + praticalTotalSecMark + " Excel mark is" + PraticalExamTotal,
							MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

				}

				try {

					if ((praticalTotalSecMark < minMark) && (PraticalExamTotal < minMark)) {
						System.out.println("The following Registration number " + regno
								+ " is failed in pratical univ sec Exam with marks in PDF: " + praticalTotalSecMark +" and in Excel: " +PraticalExamTotal);
						testCaseScenario.log(Status.PASS,
								"The following Registration number " + regno
								+ " is failed in pratical univ sec Exam with marks in PDF: " + praticalTotalSecMark +" and in Excel: " +PraticalExamTotal);
						
					} else if ((praticalTotalSecMark >= minMark) && (PraticalExamTotal >= minMark)) {
						System.out.println("The following Registration number " + regno
								+ " is passed in pratical univ sec Exam with marks in PDF: " + praticalTotalSecMark +"and in Excel: " +PraticalExamTotal);
						testCaseScenario.log(Status.PASS,
								"The following Registration number " + regno
								+ " is passed in pratical univ sec Exam with marks in PDF: " + praticalTotalSecMark +"and in Excel: " +PraticalExamTotal);
					}
					else {
						System.out.println( "Check the files for the following " + regno + " registration number where Pdf mark is " + praticalTotalSecMark + " Excel mark is" + PraticalExamTotal);
						testCaseScenario.log(Status.FAIL, "Check the files for the following " + regno + " registration number where Pdf mark is " + praticalTotalSecMark + " Excel mark is" + PraticalExamTotal,
								MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());
					}
					
				} catch (Exception e) {

					System.out.println(
							"Check the files for the following " + regno + " registration number " + e.getMessage());
					testCaseScenario.log(Status.FAIL,
							"Check the files for the following " + regno + " registration number " + e.getMessage(),
							MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

				}

			}

			else {

				System.out.println("Check the files for the following " + regno + " registration number and subject"
						+ subjectToFind);

			}
		}

		catch (Exception e) {
			e.printStackTrace();

		}
	}

//Method to check the final result (Theory Exam + Practical Exam)
	public void theoryPlusPracticalSecMarks(Object regno, String marksName, Object theroryExam, String subjectToFind,
			ExtentTest testCaseName) throws IOException {

		try {
			if (subject.equalsIgnoreCase(subjectToFind)) {

				ExtentTest testCaseScenario = testCaseName.createNode(
						marksName + " Validation for the Subject" + subjectToFind + "Test case has started running");

				minMark = grandTotalMaxMark * 0.5;

				System.out.println(minMark);
				
				
				theoryTotal = objectToDataType(theroryExam);

				System.out.println(theoryTotal);
				try {
					if (theoryTotal == ExamTotalScore) {

						System.out.println("Both Excel " + theoryTotal + " and Pdf " + ExamTotalScore
								+ " for the following Register " + regno
								+ " number data are same for Theory Plus Practical Sec Mark");
						testCaseScenario.log(Status.PASS,
								"Both Excel " + theoryTotal + " and Pdf " + ExamTotalScore
										+ " for the following Register " + regno
										+ " number data are same for  Theory Plus Practical Sec Mark");
					}

					else {

						System.out.println("Both Excel " + theoryTotal + " and Pdf " + ExamTotalScore
								+ " for the following " + regno
								+ " data are not same please check Excel file or Pdf file for Theory Plus Practical Sec Mark");
						testCaseScenario.log(Status.FAIL,
								"Both Excel " + theoryTotal + " and Pdf " + ExamTotalScore + " for the following "
										+ regno + " number data are not same for Theory Plus Practical Sec Mark",
								MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

					}

				} catch (Exception e) {
					System.out.println(
							"Check the files for the following " + regno + " registration number " + e.getMessage());
					testCaseScenario.log(Status.FAIL,
							"Check the files for the following " + regno + " registration number " + e.getMessage(),
							MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

				}

				try {

					/// Need to check this secoru

					double excelTotal = Paper1 + Paper2 + Paper3;
					double pdfTotal = paper1Mark + paper2Mark + paper2Mark;

					if (excelTotal <= minMark || excelTotal < minMark || pdfTotal <= minMark || pdfTotal < minMark) {
						System.out.println("The following Registration number " + regno
								+ " has failed in one or more papers and is therefore failed in the Theory exam marks in PDF: " + ExamTotalScore +" and in Excel: " + theoryTotal);
						testCaseScenario.log(Status.PASS, "The following Registration number " + regno
								+ " has failed in one or more papers and is therefore failed in the Theory exam marks in PDF: " + ExamTotalScore +" and in Excel: " +theoryTotal);

					}

					else if ((theoryTotal < minMark) && (ExamTotalScore < minMark)) {
						System.out.println("The following Registration number " + regno
								+ " is failed in Theory Exam with total marks in PDF: " + ExamTotalScore +" and in Excel: " +theoryTotal);

						testCaseScenario.log(Status.PASS, "The following Registration number " + regno
								+ " is failed in Theory Exam with total marks in PDF: " + ExamTotalScore +" and in Excel: " +theoryTotal);

					} else if ((theoryTotal >= minMark) && (ExamTotalScore >= minMark)) {
						System.out.println("The following Registration number " + regno
								+ " is passed in Theory Exam with total marks in PDF: " + ExamTotalScore +" and in Excel: " +theoryTotal);
						testCaseScenario.log(Status.PASS, "The following Registration number " + regno
								+ " is passed in Theory Exam with total marks in PDF: " + ExamTotalScore +" and in Excel: " +theoryTotal);
					}
					
					else {
						System.out.println( "Check the files for the following " + regno + " registration number where Pdf mark is " + ExamTotalScore + " Excel mark is" + theoryTotal);
						testCaseScenario.log(Status.FAIL, "Check the files for the following " + regno + " registration number where Pdf mark is " + ExamTotalScore + " Excel mark is" + theoryTotal,
								MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());
					}
					
				} catch (Exception e) {
					System.out.println(
							"Check the files for the following " + regno + " registration number " + e.getMessage());
					testCaseScenario.log(Status.FAIL,
							"Check the files for the following " + regno + " registration number " + e.getMessage(),
							MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

				}

				theoryPlusPracticalTotalMarks(regno, marksName, theroryExam, subjectToFind, testCaseName);

			}

			else {

				System.out.println("Check the files for the following " + regno + " registration number and subject"
						+ subjectToFind);

			}
		}

		catch (Exception e) {
			e.printStackTrace();

		}
	}

	// Method to check the final result (Theory Exam + Practical Exam)
	public void securedMarks(Object regno, Object examTotal, ExtentTest testCaseName) throws IOException {

		ExtentTest testCaseScenario = testCaseName
				.createNode("Secured Marks Result Validation Test case has started running");

		grandTotal = objectToDataType(examTotal);

		try {
			if (grandTotal == securedMark) {

				System.out
						.println("Both Excel " + grandTotal + " and Pdf " + securedMark + " for the following Register "
								+ regno + " number data are same for EP mark please check the files");
				testCaseScenario.log(Status.PASS,
						"Both Excel " + grandTotal + " and Pdf " + securedMark + " for the following Register " + regno
								+ " number data are same for EP total mark please check the files");
			}

			else {

				System.out.println("Both Excel " + grandTotal + " and Pdf " + securedMark + " for the following "
						+ regno
						+ " data are not same please check Excel file or Pdf file for EP total mark please check the files");
				testCaseScenario.log(Status.FAIL,
						"Both Excel " + grandTotal + " and Pdf " + securedMark + " for the following Register " + regno
								+ " number data are not same for EP total mark please check the files",
						MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

			}

		} catch (Exception e) {
			System.out.println( "Check the files for the following " + regno + " registration number where Pdf mark is " + securedMark + " Excel mark is" + grandTotal);
			testCaseScenario.log(Status.FAIL, "Check the files for the following " + regno + " registration number where Pdf mark is " + securedMark + " Excel mark is" + grandTotal,
					MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());
		}

	}

	// Method to check the final result (Theory Exam + Practical Exam)
	public void theoryPlusPracticalTotalMarks(Object regno, String marksName, Object theroryExam, String subjectToFind,
			ExtentTest testCaseName) throws IOException {

		try {
			if (subject.equalsIgnoreCase(subjectToFind)) {
				ExtentTest testCaseScenario = testCaseName.createNode(
						"Grand Total Validation for the Subject" + subjectToFind + " Test case has started running");

				minMark = grandTotalMaxMark * 0.5;

				grandTotal = paper1Mark + paper2Mark + paper3Mark + praticalTotalSecMark;
				
				TheroryExamTotal = Paper1+Paper2+Paper3+PraticalExamTotal;
				System.out.println("Paper1Mark:"+ paper1Mark);
				System.out.println("Paper2Mark:"+ paper2Mark);
				System.out.println("Paper3Mark:"+ paper3Mark);
				System.out.println("Pratical total mark:"+ praticalTotalSecMark);
				System.out.println("grandTotal:"+ grandTotal);
				
				System.out.println("Paper1:"+ Paper1);
				System.out.println("Paper2:"+ Paper2);
				System.out.println("Paper3:"+ Paper3);
				System.out.println("PraticalExamTotal"+PraticalExamTotal);
				System.out.println("TheoryExam:"+ TheroryExamTotal);
				
				
				theoryTotal = objectToDataType(theroryExam);

				try {
					if (theoryTotal == grandTotal) {

						System.out.println("\n Both PDF file total value " + grandTotal
								+ " and Excel file total value  " + theoryTotal + " for the following Register " + regno
								+ " number data are same for Theory plus practical total sec mark in PDF file");
						testCaseScenario.log(Status.PASS,
								"\n Both PDF file total value " + grandTotal + " and Excel file total value  "
										+ theoryTotal + " for the following Register " + regno
										+ " number data are same for Theory plus practical total sec mark in PDF file");
					}

					else {

						System.out.println("\n Both PDF file total value " + grandTotal
								+ " and Excel file total value  " + theoryTotal + " for the following Register " + regno
								+ " number data are not same for Theory plus practical total sec mark in PDF file");
						testCaseScenario.log(Status.FAIL, "\n Both PDF file total value " + grandTotal
								+ " and Excel file total value  " + theoryTotal + " for the following Register " + regno
								+ " number data are not same  for Theory plus practical total sec mark in PDF file",
								MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());
					}

				} catch (Exception e) {
					System.out.println(
							"Check the files for the following " + regno + " registration number " + e.getMessage());
					testCaseScenario.log(Status.FAIL,
							"Check the files for the following " + regno + " registration number " + e.getMessage(),
							MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)).build());

				}

				
				  try { 
					  
					  
					  if (theoryTotal == TheroryExamTotal) {
				  
				  System.out.println("Both Excel file total value " + TheroryExamTotal +
				  " and PDF file total value  " + grandTotal + " for the following Register " +
				  regno +
				  " number data are same for Theory plus practical total sec mark in Excel file"
				  ); testCaseScenario.log(Status.PASS, "Both Excel file total value " +
				  TheroryExamTotal + " and PDF file total value  " + grandTotal +
				  " for the following Register " + regno +
				  " number data are same for Theory plus practical total sec mark in Excel file"
				  ); }
				  
				  else {
				  
				  System.out.println("Both Excel total value " + TheroryExamTotal +
				 " and PDF file total value  " + grandTotal + " for the following Register " +
				  regno +
				  " number data are not same for Theory plus practical total sec mark in Excel file"
				  ); testCaseScenario.log(Status.FAIL, "Both Excel file total value " +
				  TheroryExamTotal + " and PDF file total value  " + grandTotal +
				  " for the following Register " + regno +
				  " number data are not same  for Theory plus practical total sec mark in Excel file"
				  ,
				  MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)
				  ).build()); }
				 
				  } catch (Exception e) { System.out.println(
				  "Check the files for the following " + regno + " registration number " +
				  e.getMessage()); testCaseScenario.log(Status.FAIL,
				 "Check the files for the following " + regno + " registration number " +
				  e.getMessage(),
				  MediaEntityBuilder.createScreenCaptureFromPath(BasicFunctions.capture(driver)
				  ).build());
				  
				  }
				 

			}

			else {

				System.out.println("Check the files for the following " + regno + " registration number and subject"
						+ subjectToFind);
			}
		}

		catch (Exception e) {
			e.printStackTrace();

		}
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

	// Helper function to check if the marks are greater than 50% of max marks
	public void checkMarks(Object regno, String markName, Object paper1, Object paper2, Object paper3,
			Object praticalExam, Object theoryExam, String subjectToFind, Object examTotal, String marks,
			double maxMarks, ExtentTest testCaseName) throws IOException {

		System.out.println(marks);



		if ((marks.equals("---") || marks.equals("NA")) || marks.equals("NE")) {
			System.out.println(markName + " Subject marks: Not available");

			// testCaseScenario.log(Status.PASS, "The following " + regno + markName +"
			// Subject marks is Not available "+ marks +" and status is "+ status);

		} else {
			double marksValue = Double.parseDouble(marks);

//            System.out.println("checking " + markName + " for the following "+ regno);

			if (marksValue > maxMarks * 0.5) {

//            	System.out.println("Marks: of following register number " + regno  +" student subject is " +markName +" (greater than 50% of max marks)");
//           	testCaseScenario.log(Status.PASS,"Marks: of following register number"+regno + " student subject is " + markName +"(greater than 50% of max marks)");
//            
			} else {
				// System.out.println("Marks: " + marksValue + " (not greater than 50% of max
				// marks)");
				// testCaseScenario.log(Status.PASS,"Marks: " + marksValue + " (not greater than
				// 50% of max marks)");
			}

			try {

				if ((status.equals("Pass") || status.equals("Fail")) && (markName.contains("Theory Internal Sec. Marks")
						|| markName.contains("Theory Internal Sec. Marks"))) {

					theoryInternalSecMarks(regno, markName, paper1, subjectToFind, testCaseName);
				} else if ((status.equals("Pass") || status.equals("Fail"))
						&& markName.contains("Theory (Univ) Sec. Marks")) {

					System.out.println(paper2);
					theoryUnivSecMarks(regno, markName, paper2, subjectToFind, testCaseName);

				}

				else if ((status.equals("Pass") || status.equals("Fail")) && markName.contains("Pratical Internal Sec. Marks")) {
					
				
					practicalInternalSecMarks(regno, markName, paper3, subjectToFind, testCaseName);
				}
				
				else if ((status.equals("Pass") || status.equals("Fail")) && markName.contains("Pratical Univ Sec. Marks")) {

					praticalUnivSecMarks(regno, markName, praticalExam, subjectToFind, testCaseName);
				}

				else if ((status.equals("Pass") || status.equals("Fail"))
						&& markName.contains("Theory plus pratical Sec. Marks")) {

					theoryPlusPracticalSecMarks(regno, markName, theoryExam, subjectToFind, testCaseName);

				}

				else {
					System.out.println("==============");
					securedMarks(regno, examTotal, testCaseName);
					System.out.println("==============");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
