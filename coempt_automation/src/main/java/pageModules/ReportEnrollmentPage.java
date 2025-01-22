package pageModules;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
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

	long registrationNumber;
	double paper1Mark;
	double paper2Mark;
	double paper3Mark;

	double praticalMinMark;
	double praticalMaxMark;
	double theoryMinMark;
	double theoryMaxMark;
	double grandTotalMinMark;
	double grandTotalMaxMark;
	double theoryTotal;
	double praticalTotal;
	double grandTotal;

	public void ReportCardNavigation() {

		implicitWait(30);
		explicitWait(pom.getInstanceEnrollXP().loginTags, 30);

		if (pom.getInstanceEnrollXP().loginTags.isDisplayed()) {

			implicitWait(30);
			explicitWait(pom.getInstanceEnrollXP().loginTags, 30);

			scroll(pom.getInstanceEnrollXP().reportCardOption);

			implicitWait(30);
			explicitWait(pom.getInstanceEnrollXP().reportCardOption, 30);
			click(pom.getInstanceEnrollXP().reportCardOption);
		}
	}

	public void ReportCardEnrollNavigation() {

		implicitWait(30);
		explicitWait(pom.getInstanceEnrollXP().reportCardEnroll, 30);

		scroll(pom.getInstanceEnrollXP().reportCardEnroll);

		implicitWait(30);
		explicitWait(pom.getInstanceEnrollXP().reportCardEnroll, 30);
		click(pom.getInstanceEnrollXP().reportCardEnroll);

	}

	public void EnrollmentRegNo(Object regno) throws IOException {

		implicitWait(30);
		explicitWait(pom.getInstanceEnrollXP().enrollNo, 30);
		click(pom.getInstanceEnrollXP().enrollNo);

		implicitWait(30);
		explicitWait(pom.getInstanceEnrollXP().enrollNo, 30);
		sendKeys(pom.getInstanceEnrollXP().enrollNo, String.valueOf(regno));
	}

	public static void EnrollmentExamDate(Object examDate) throws IOException {

		implicitWait(30);

		explicitWait(pom.getInstanceEnrollXP().examSeries, 30);
		click(pom.getInstanceEnrollXP().examSeries);

		implicitWait(30);
		explicitWait(pom.getInstanceEnrollXP().examSeries, 30);
		click(pom.getInstanceEnrollXP().examSeries);

		implicitWait(30);
		explicitWait(pom.getInstanceEnrollXP().examSeries, 30);
		click(pom.getInstanceEnrollXP().examSeries);
		WebElement examDateOption = driver.findElement(By.xpath("//li[@role='option' and text()='" + examDate + "']"));
		explicitWait(examDateOption, 30);

		if (examDateOption.isDisplayed()) {
			explicitWait(examDateOption, 30);
			implicitWait(30);
			click(examDateOption);

		}

		else {
			implicitWait(30);
			explicitWait(pom.getInstanceEnrollXP().examSeries, 30);
			click(pom.getInstanceEnrollXP().examSeries);
			implicitWait(30);
			explicitWait(pom.getInstanceEnrollXP().examSeries, 30);
			click(examDateOption);
		}
		// // dropDownClick(pom.getInstanceEnrollXP().examSeriesOption,examdate);

	}

	public static void EnrollmentAwardName(Object awardName) throws IOException {

		implicitWait(30);
		explicitWait(pom.getInstanceEnrollXP().awardName, 30);
		click(pom.getInstanceEnrollXP().awardName);
//
//		   	//li[contains(@class,'select2-results__option') and text()!='Select']
//		   	// Construct XPath with the dynamic text
		WebElement awardOption = driver.findElement(By.xpath("//li[@role='option' and text()='" + awardName + "']"));

//
		if (awardOption.isDisplayed()) {
			explicitWait(awardOption, 30);
			implicitWait(30);
			click(awardOption);

		}

		else {
			implicitWait(30);
			explicitWait(pom.getInstanceEnrollXP().awardName, 30);
			click(pom.getInstanceEnrollXP().awardName);
			implicitWait(30);
			explicitWait(pom.getInstanceEnrollXP().awardName, 30);
			click(awardOption);
		}

	}

	public static void EnrollmentSemester(Object semester) throws IOException {

		implicitWait(30);
		explicitWait(pom.getInstanceEnrollXP().yearSession, 30);
//		System.out.println(pom.getInstanceEnrollXP().yearSession.isDisplayed());

		click(pom.getInstanceEnrollXP().yearSession);
//		   		
		implicitWait(30);
//		   		
//		   	//li[contains(@class,'select2-results__option')
		WebElement yearSessionOption = driver
				.findElement(By.xpath("//li[@role='option' and text()='" + semester + "']"));
		explicitWait(yearSessionOption, 30);
//		click(yearSessionOption);
//		    	
		// System.out.println(yearSessionOption.isDisplayed());
		if (yearSessionOption.isDisplayed()) {
			explicitWait(yearSessionOption, 30);
			implicitWait(30);
			click(yearSessionOption);

		}

		else {
			implicitWait(30);
			explicitWait(pom.getInstanceEnrollXP().yearSession, 30);
			click(pom.getInstanceEnrollXP().yearSession);
			implicitWait(30);
			explicitWait(pom.getInstanceEnrollXP().yearSession, 30);
			click(yearSessionOption);
		}

	}

	public static void EnrollmentRegulation(Object regulation) {

		implicitWait(30);
		explicitWait(pom.getInstanceEnrollXP().regulation, 30);
//		System.out.println(pom.getInstanceEnrollXP().regulation.isDisplayed());

		click(pom.getInstanceEnrollXP().regulation);
		implicitWait(30);

		// System.out.println(regulation);
		WebElement regulationOption = driver
				.findElement(By.xpath("//li[@role='option' and text()='" + regulation + "']"));

		if (regulationOption.isDisplayed()) {
			explicitWait(regulationOption, 30);
			implicitWait(30);
			click(regulationOption);

		}

		else {
			implicitWait(30);
			explicitWait(pom.getInstanceEnrollXP().regulation, 30);
			click(pom.getInstanceEnrollXP().regulation);
			implicitWait(30);
			explicitWait(pom.getInstanceEnrollXP().regulation, 30);
			click(regulationOption);
		}
	}

	public static void EnrollmentExamType(Object examType) throws InterruptedException {

//		System.out.println("To check" + examType);

		implicitWait(30);
		explicitWait(pom.getInstanceEnrollXP().examType, 30);

		click(pom.getInstanceEnrollXP().examType);
		implicitWait(30);

		WebElement examTypesOption = driver.findElement(By.xpath("//li[@role='option' and text()='" + examType + "']"));
		implicitWait(60);
		// System.out.println(examTypesOption.isDisplayed());
		if (examTypesOption.isDisplayed()) {
			explicitWait(examTypesOption, 30);
			implicitWait(30);
			click(examTypesOption);

		}

		else {
			implicitWait(30);
			explicitWait(pom.getInstanceEnrollXP().examType, 30);
			click(pom.getInstanceEnrollXP().examType);
			implicitWait(30);
			explicitWait(examTypesOption, 30);
			click(examTypesOption);
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

	public void submitButton() throws InterruptedException {

		implicitWait(30);
		explicitWait(pom.getInstanceEnrollXP().submitBtn, 30);
		click(pom.getInstanceEnrollXP().submitBtn);

		explicitWait(pom.getInstanceEnrollXP().loadingScreen, 30);
		implicitWait(30);

		fluentWait(pom.getInstanceEnrollXP().loadingScreen, 30);

		Thread.sleep(5000);

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

	public void DownloadReportValidation() throws InterruptedException, IOException {

		try {

			Actions action = new Actions(driver);

			Thread.sleep(5000);

			implicitWait(30);

//					action.moveToElement(pom.getInstanceEnrollXP().reportCardExportTo).perform();

			action.moveToElement(pom.getInstanceEnrollXP().reportCardExportTo).click().perform();

			implicitWait(30);

//					action.moveToElement(pom.getInstanceEnrollXP().reportCardExportToPdf).perform();

			action.moveToElement(pom.getInstanceEnrollXP().reportCardExportToPdf).click().perform();

			implicitWait(30);

			Thread.sleep(15000);

			// Get the parent window handle and store it in a list
			ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

			// Switch to the second window (index 1 in the list)
			driver.switchTo().window(windowHandles.get(1));

			// Perform actions in the new window/tab
			// ...
			implicitWait(60);

			if (driver.getCurrentUrl().endsWith(".pdf")) {
				System.out.println("PDF opened successfully: " + driver.getCurrentUrl());
				System.out.println("=========================");
			} else {
				System.out.println(driver.getCurrentUrl());
				System.out.println("Failed to open the PDF.");
			}

			String downloadDir = System.getProperty("user.home") + "/Downloads"; // Set path to your Downloads folder

			// Wait for the file to finish downloading
			File dir = new File(downloadDir);
			File[] files = null;
			long lastModifiedTime = System.currentTimeMillis();
			boolean fileDownloaded = false;
			File latestFile = null;
			long startTime = System.currentTimeMillis(); // Record the start time

			// Wait until the file is downloaded
			while (!fileDownloaded) {

				files = dir.listFiles((d, name) -> name.endsWith(".pdf"));

				if (files != null && files.length > 0) {
					// Sort the files by lastModified time in descending order
					Arrays.sort(files, (f1, f2) -> Long.compare(f2.lastModified(), f1.lastModified()));

					// The first file in the sorted array is the most recently modified
					latestFile = files[0];

					// Check if the latest file was created/modified after the start time
					// if (latestFile.lastModified() > startTime) {
					fileDownloaded = true;
					// }
				}

				Thread.sleep(1000); // Check every second
			}

			files = dir.listFiles((d, name) -> name.endsWith(".pdf"));
			for (File file : files) {
				if (file.lastModified() > lastModifiedTime) {
					// Check if the file has been updated (download complete)
					lastModifiedTime = file.lastModified();
					fileDownloaded = true;

					break;
				}
			}
			Thread.sleep(1000); // Check every second

			// After the file is downloaded, parse the PDF
			// File downloadedPdf = files[0]; // Assuming the first file is the downloaded
			// PDF
			// PDDocument document = PDDocument.load(downloadedPdf);

			// System.out.println(document.getDocumentInformation().getMetadataKeys());
			if (latestFile != null) {
				// After the file is downloaded, parse the PDF
				PDDocument document = PDDocument.load(latestFile);

				// Extract text from the PDF
				PDFTextStripper stripper = new PDFTextStripper();
				String text = stripper.getText(document);

				// Normalize text: remove extra spaces, newlines, etc.
				String normalizedText = text.replaceAll("[\r\n]+", "\n");

				// Print the normalized extracted text
				System.out.println("=== Extracted PDF Text ===");
				// System.out.println(normalizedText);

				Pattern registrationPattern = Pattern.compile("Registration No:\\s*(\\d+)");

				Matcher regMatcher = registrationPattern.matcher(normalizedText);
				if (regMatcher.find()) {

					// String regNoText =regMatcher.group(1)

					// registrationNumber =Integer.parseInt(regMatcher.group(1));

					// Split the string by ": "
					String[] parts = regMatcher.group(1).split(":");

					// Get the number part (second part after the split)
					// String regnumber = parts[1];

					// Debug: Print the result of the split
					// System.out.println("Split parts:");
					for (int i = 0; i < parts.length; i++) {
						registrationNumber = Long.parseLong(parts[i]);

						// System.out.println("parts[" + i + "]: '" + parts[i] + "'");

						System.out.println("Registration No: " + registrationNumber);

					}

					/*
					 * // Check if the array has at least two parts if (parts.length > 1) { // Trim
					 * the second part to remove any extra spaces String number = parts[1].trim();
					 * System.out.println("Extracted number: " + number); } else { System.out.
					 * println("Error: The input string does not contain the expected delimiter ':'"
					 * ); }
					 */

				}
				try {
//       	  // Regular expression to find the marks for "Paper I"
//          
//        	  
//         Pattern pattern = Pattern.compile("(\\d+)\\s(\\d+)\\s(Pass|Fail)"); // Capture two numbers followed by either "Pass" or "Fail"
//
//        
					boolean isTheory = true; // Initially, assume the first pair is Theory
					boolean isPractical = false; // Initially, assume we haven't encountered Practical marks

//         // 2. Extract Paper Max/Min Marks
					Pattern paperPattern = Pattern.compile(
							"(Paper\\s[IVX]+)\\s+Max\\.Marks:(\\d+)|Total\\s+Max\\.Marks:(\\d+)\\s+Min\\.Marks:(\\d+)|Max\\.Marks:(\\d+)\\s+Min\\.Marks:(\\d+)");
					Matcher paperMatcher = paperPattern.matcher(normalizedText);
					System.out.println("==============");
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
								}

								i += 2; // Move to the next pair of Max/Min marks
							}
						}
					}

					// 3. Extract Marks and Result
					// Pattern marksPattern =
					// Pattern.compile("(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(Pass|Fail)");

					// Pattern marksPattern =
					// Pattern.compile("(\\d+)(?:\\s+\\(F\\))?\\s+(\\d+)(?:\\s+\\(F\\))?\\s+(\\d+)(?:\\s+\\(F\\))?\\s+(\\d+)(?:\\s+\\(F\\))?\\s+(\\d+)(?:\\s+\\(F\\))?\\s+(\\d+)(?:\\s+\\(F\\))?\\s+(Pass|Fail)");
					Pattern marksPattern = Pattern.compile("(\\d+)(?:\\s+\\(F\\))?\\s+" + // First mark with optional
																							// (F)
							"(\\d+)(?:\\s+\\(F\\))?\\s+" + // Second mark with optional (F)
							"(\\d+)(?:\\s+\\(F\\))?\\s+" + // Third mark with optional (F)
							"(\\d+)(?:\\s+\\(F\\))?\\s+" + // Fourth mark with optional (F)
							"(\\d+)(?:\\s+\\(F\\))?\\s+" + // Fifth mark with optional (F)
							"(\\d+)(?:\\s+\\(F\\))?\\s+" + // Sixth mark with optional (F)
							"(Pass|Fail)" // Final result (Pass or Fail)
					);

					Matcher marksMatcher = marksPattern.matcher(normalizedText);
					System.out.println("\n=== Marks and Results ===");
					if (marksMatcher.find()) {

						paper1Mark = Integer.parseInt(marksMatcher.group(1));
						paper2Mark = Integer.parseInt(marksMatcher.group(2));
						paper3Mark = Integer.parseInt(marksMatcher.group(3));

						System.out.println("Paper I: " + marksMatcher.group(1));
						System.out.println("Paper II: " + marksMatcher.group(2));
						System.out.println("Paper III: " + marksMatcher.group(3));
						System.out.println("Theory Max Mark:" + theoryMaxMark);
						System.out.println("Theory Min Mark:" + theoryMinMark);

						System.out.println("Theory Total: " + marksMatcher.group(4));
						theoryTotal = Integer.parseInt(marksMatcher.group(4));
						System.out.println("==============");

						System.out.println("Practical Max Mark:" + praticalMaxMark);
						System.out.println("Pratical Min Mark:" + praticalMinMark);
						System.out.println("Practical Total: " + marksMatcher.group(5));
						praticalTotal = Integer.parseInt(marksMatcher.group(5));
						System.out.println("===============");

						System.out.println("Grand Total Max Mark:" + grandTotalMaxMark);
						System.out.println("Grand Total Min Mark:" + grandTotalMinMark);
						System.out.println("Grand Total: " + marksMatcher.group(6));
						grandTotal = Integer.parseInt(marksMatcher.group(6));
						System.out.println(grandTotal);

						System.out.println("Result: " + marksMatcher.group(7));
					} else {
						System.out.println("Marks and result not found.");
					}
					document.close();
				}

				catch (Exception e) {
					e.printStackTrace();
				}

			}

			System.out.println("===========================");

			implicitWait(60);

			driver.close();

			// Switch back to the parent window (index 0 in the list)
			driver.switchTo().window(windowHandles.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method to check if a student passed or failed in Paper 1
	public void checkPaper1Result(Object regno, Object paper1) {
		try {
			Paper1 = objectToDataType(paper1);
			System.out.println(Paper1);
			try {
				if (paper1Mark == Paper1) {
					System.out.println(
							"Both Excel " + Paper1 + " and Pdf " + paper1Mark + " data are same for paper 1 mark");
				}

				else {
					System.out.println("Both Excel " + Paper1 + " and Pdf " + paper1Mark
							+ " data are not same please check Excel file or Pdf file for paper 1 mark");
				}

			} catch (Exception e) {
				e.printStackTrace();

			}

			if (paper1Mark < 50 && Paper1 < 50) {
				System.out.println("The following Registration number " + registrationNumber
						+ " is failed in Paper1 exam with marks: " + paper1Mark);
			} else if (paper1Mark >= 50 && Paper1 >= 50) {
				System.out.println("The following Registration number " + registrationNumber
						+ " is passed in Paper1 exam with marks: " + paper1Mark);
			} else {
				System.out.println("Pdf mark is " + paper1Mark + " Excel mark is " + Paper1);

			}

		} catch (Exception e) {
			System.out.println("Paper 1 row in the excel sheet is empty for the following " + registrationNumber
					+ " number please check the excel sheet" + e.getMessage());

		}
	}

	// Method to check if a student passed or failed in Paper 2
	public void checkPaper2Result(Object regno, Object paper2) {
		try {
			Paper2 = objectToDataType(paper2);

			try {
				if (paper2Mark == Paper2) {
					System.out.println(
							"Both Excel " + Paper2 + " and Pdf " + paper2Mark + " data are same for paper 2 mark");
				}

				else {
					System.out.println("Both Excel " + Paper2 + " and Pdf " + paper2Mark
							+ " data are not same please check Excel file or Pdf file for paper 2 mark");
				}

			} catch (Exception e) {
				e.printStackTrace();

			}

			if (paper2Mark == Paper2 && paper2Mark < 50 && Paper2 < 50) {
				System.out.println("The following Registration number " + registrationNumber
						+ " is failed in Paper2 exam with marks: " + paper2Mark);
			} else if (paper2Mark == Paper2 && paper2Mark >= 50 && Paper2 >= 50) {
				System.out.println("The following Registration number " + registrationNumber
						+ " is passed in Paper2 exam with marks: " + paper2Mark);
			} else {
				System.out.println("Pdf mark is " + paper2Mark + " Excel mark is" + Paper2);

			}

		} catch (Exception e) {
			System.out.println("Paper 2 row in the excel sheet is empty for the following " + registrationNumber
					+ " number please check the excel sheet" + e.getMessage());
		}
	}

	// Method to check if a student passed or failed in Paper 3
	public void checkPaper3Result(Object regno, Object paper3) {
		try {
			Paper3 = objectToDataType(paper3);

			try {
				if (paper3Mark == Paper3) {
					System.out.println(
							"Both Excel " + Paper3 + " and Pdf " + paper3Mark + " data are same for paper 3 mark");
				}

				else {
					System.out.println("Both Excel " + Paper3 + " and Pdf " + paper3Mark
							+ " data are not same please check Excel file or Pdf file for paper 3 mark");
				}

			} catch (Exception e) {
				e.printStackTrace();

			}

			if (paper3Mark < 50 && Paper3 < 50) {
				System.out.println("The following Registration number " + registrationNumber
						+ " is failed in Paper3 exam with marks: " + paper3Mark);
			} else if (paper3Mark >= 50 && Paper3 >= 50) {
				System.out.println("The following Registration number " + registrationNumber
						+ " is passed in Paper3 exam with marks: " + paper3Mark);
			} else {
				System.out.println("Pdf mark is " + paper3Mark + " Excel mark is" + Paper3);

			}
		} catch (Exception e) {
			System.out.println("Paper 3 row in the excel sheet is empty for the following " + registrationNumber
					+ " number please check the excel sheet" + e.getMessage());
		}
	}

	// Method to check if a student passed or failed in the Theory Exam (Paper1 +
	// Paper2 + Paper3)
	public void checkTheoryExamResult(Object regno, Object theoryExam) {
		try {

			TheroryExamTotal = Paper1 + Paper2 + Paper3;
			//

			theoryTotal = paper1Mark + paper2Mark + paper3Mark;

			Double theroryExamTotal = objectToDataType(theoryExam);

			System.out.println(theoryTotal);

			try {
				if (theoryTotal == theroryExamTotal && theoryTotal == TheroryExamTotal) {
					System.out.println("Both Excel " + theroryExamTotal + " and Pdf " + theoryTotal
							+ " data are same for theory total mark");
				}

				else {
					System.out.println("Both Excel " + theroryExamTotal + " and Pdf " + theoryTotal
							+ " data are not same please check Excel file or Pdf file for theory total mark");
				}

			} catch (Exception e) {
				System.out.println("Pdf mark is " + theoryTotal + " Excel mark is" + theroryExamTotal + e.getMessage());

			}

			if (paper1Mark < 50 || paper2Mark < 50 || paper3Mark < 50 || Paper1 < 50 || Paper2 < 50 || Paper3 < 50) {
				System.out.println("The following Registration number " + registrationNumber
						+ " has failed in one or more papers and is therefore failed in the Theory exam:"
						+ theoryTotal);
			}

			else if (theoryTotal < theoryMinMark && TheroryExamTotal < theoryMinMark) {
				System.out.println("The following Registration number " + registrationNumber
						+ " is failed in Theory Exam with total marks: " + theoryTotal);
			} else if (theoryTotal >= theoryMinMark && TheroryExamTotal >= theoryMinMark) {
				System.out.println("The following Registration number " + registrationNumber
						+ " is passed in Theory Exam with total marks: " + theoryTotal);
			}
		} catch (Exception e) {
			System.out.println("Therory Exam row in the excel sheet is empty for the following " + registrationNumber
					+ " number please check the excel sheet" + e.getMessage());
		}
	}

	// Method to check if a student passed or failed in the Practical Exam
	public void checkPracticalExamResult(Object regno, Object praticalExam) {
		try {
			PraticalExamTotal = objectToDataType(praticalExam);

			try {
				if (praticalTotal == PraticalExamTotal) {
					System.out.println("Both Excel " + PraticalExamTotal +" and Pdf "+ praticalTotal +" data are same for pratical total mark");
				}
	
				else {
					System.out.println("Both Excel " + PraticalExamTotal +" and Pdf "+ praticalTotal +" data are not same please check Excel file or Pdf file for pratical total mark");	
				}

			} catch (Exception e) {
				e.printStackTrace();

			}

			if (praticalTotal < praticalMinMark && PraticalExamTotal < praticalMinMark) {
				System.out.println("The following Registration number " + registrationNumber
						+ " is failed in Practical Exam with marks: " + praticalTotal);
			} else if (praticalTotal >= praticalMinMark && PraticalExamTotal >= praticalMinMark) {
				System.out.println("The following Registration number " + registrationNumber
						+ " is passed in Practical Exam with marks: " + praticalTotal);
			}
		} catch (Exception e) {

			System.out.println("Pratical Exam row in the excel sheet is empty for the following " + registrationNumber
					+ " number please check the excel sheet" + e.getMessage());

		}
	}

	// Method to check the final result (Theory Exam + Practical Exam)
	public void checkFinalExamResult(Object regno, Object examTotal) {
		try {

			// Calculate total score (Theory + Practical)
			ExamTotalScore = TheroryExamTotal + PraticalExamTotal;

			grandTotal = theoryTotal + praticalTotal;

			double grandTotalScore = objectToDataType(examTotal);

			try {
				if (grandTotal == grandTotalScore) {
				
						System.out.println("Both Excel " + grandTotalScore +" and Pdf "+ grandTotal +" data are same for pratical grand total mark");
					}
		
					else {
						System.out.println("Both Excel " + grandTotalScore +" and Pdf "+ grandTotal +" data are not same please check Excel file or Pdf file for grand total mark");	
					}

			} catch (Exception e) {
				e.printStackTrace();

			}

			if (paper1Mark < 50 || paper2Mark < 50 || paper3Mark < 50 || Paper1 < 50 || Paper2 < 50 || Paper3 < 50
					|| PraticalExamTotal < praticalMinMark || praticalTotal < praticalMinMark
					|| grandTotal < grandTotalMinMark || grandTotal < grandTotalMinMark) {
				System.out.println("The following Registration number " + registrationNumber
						+ " has failed in one or more papers and is therefore failed in the final exam:" + grandTotal);
			}
			// If total marks are above 300 but failed in individual papers, still fail
			else if (grandTotal < grandTotalMinMark && ExamTotalScore < grandTotalMinMark) {
				System.out.println("The following Registration number " + registrationNumber
						+ " is failed with total score: " + grandTotal);
			} else {
				System.out.println("The following Registration number " + registrationNumber
						+ " is passed with total score: " + grandTotal);
			}
		} catch (Exception e) {

			System.out.println("GrandTotal(EP)row in the excel sheet is empty for the following " + registrationNumber
					+ " number please check the excel sheet" + e.getMessage());
		}
	}

//if the above code does work use this	

//		public void Paper1(Object regno,Object paper1){
//		try {
//
//		
//
//			
//			Paper1 = objectToDataType(paper1);
//			
//			double 	Paper1Percentage = ((double) Paper1 / 100) * 100;
//
//			if (Paper1 < 50) {
//
//				System.out.println("The following Registration number"  + " is failed in Paper1 exam");
//				// test.log(Status.PASS, regno +" is Passed" ,test.add);
//				System.out.println(Paper1);
//			}
//
//			else if (Paper1 >= 50) {
//				System.out.println("The following Registration number"  + " is passed in Paper1 exam");
//				System.out.println(Paper1);
//			}
//
//		}
//
//		catch (Exception e) {
//		
//				System.out.println("Paper 1 row in the excel sheet is empty for the following " +" number please check the excel sheet");
//				
//			}
//		}
//		
//
//
//		public void Paper2(Object regno,Object paper2){
//		
//			try {
//			
//			
//			
//				Paper2 = objectToDataType(paper2);
//	
//				if (Paper2 < 50) {
//	
//					System.out.println("The following Registration number "  + " is failed in Paper2 exam");
//					System.out.println(Paper2);
//				}
//	
//				else if (Paper2 >= 50) {
//					System.out.println("The following Registration number "  + " is passed in Paper2 exam");
//					System.out.println(Paper2);
//				}
//				
//				else if (Paper2 >= 50) {
//					System.out.println("The following Registration number "  + " is passed in Paper2 exam");
//					System.out.println(Paper2);
//				}
//	
//			}
//	
//			catch (Exception e) {
//			
//		
//					System.out.println("Paper 2 row in the excel sheet is empty for the following " +" number please check the excel sheet");
//					
//			}
//	
//		}
//
//		public void Paper3(Object regno,Object paper3){
//
//			try {
//				Paper3 = objectToDataType(paper3);
//	
//				if (Paper3 < 50) {
//	
//					System.out.println("The following Registration number "  + " is failed in Paper3 exam");
//					System.out.println(Paper3);
//				}
//	
//				else if (Paper3 >= 50) {
//					System.out.println("The following Registration number "  + " is passed in Paper3 exam");
//					System.out.println(Paper3);
//				}
//	
//			}
//	
//			catch (Exception e) {
//			
//					System.out.println("Paper 3 row in the excel sheet is empty for the following " +" number please check the excel sheet");
//					
//			}
//	
//		}
//
//		public void PraticalExam(Object regno,Object praticalExam){
//			try {
//
//				PraticalExamTotal = objectToDataType(praticalExam);
//	
//				if (PraticalExamTotal < 150) {
//					System.out.println("The following Registration number "  + " is Failed in Pratical Exam");
//					System.out.println(PraticalExamTotal);
//				}
//	
//				else if (PraticalExamTotal >= 150) {
//					System.out.println("The following Registration number "  + " is Passed in Practical Exam");
//					System.out.println(PraticalExamTotal);
//				}
//	
//			}
//	
//			catch (Exception e) {
//			
//					System.out.println("Pratical Exam row in the excel sheet is empty for the following " +" number please check the excel sheet");
//					
//			
//			}
//		}
//
//		public void TheoryExam(Object regno,Object theoryExam){
//			try {
//
//				TheroryExamTotal = Paper1 + Paper2 + Paper3;
//	
//				TheroryExamTotal = objectToDataType(theoryExam);
//	
//				if (TheroryExamTotal < 150) {
//					System.out.println("The following Registration number "  + " is Failed in Therory Exam");
//					System.out.println(TheroryExamTotal);
//				}
//	
//				else if (TheroryExamTotal >= 150) {
//					System.out.println("The following Registration number "  + " is Passed in Therory Exam");
//					System.out.println(TheroryExamTotal);
//				}
//			}
//	
//			catch (Exception e) {
//		
//					System.out.println("Therory Exam row in the excel sheet is empty for the following " +" number please check the excel sheet");
//					
//			
//			}
//
//			}
//
//
//			public void ExamTotalScore(Object regno,Object examTotal) {
//				
//					
//		try {
//
//			ExamTotalScore = TheroryExamTotal + PraticalExamTotal;
//
//			ExamTotalScore = objectToDataType(examTotal);
//
//			if (ExamTotalScore < 300) {
//				System.out.println("The following Registration number "  + " is Failed ");
//				System.out.println(ExamTotalScore);
//			}
//
//			else if (ExamTotalScore >= 300) {
//				System.out.println("The following Registration number "  + " is Passed ");
//				System.out.println(ExamTotalScore);
//			}
//		}
//
//		catch (Exception e) {
//	
//				System.out.println("Exam Total row in the excel sheet is empty for the following " +" number please check the excel sheet");
//				
//		}

	// public void validatePaperResults(Object regno, Object paper1, Object paper2,
	// Object paper3,Object praticalExam, Object theoryExam, Object examTotal)
	// throws InterruptedException{
	// // double Total = (regno+regulation);

	// try {

	// Paper1 = objectToDataType(paper1);

	// if (Paper1 < 50) {

	// System.out.println("The following Registration number" + " is failed
	// in Paper1 exam");
	// // test.log(Status.PASS, regno +" is Passed" ,test.add);
	// System.out.println(Paper1);
	// }

	// else if (Paper1 >= 50) {
	// System.out.println("The following Registration number" + " is passed
	// in Paper1 exam");
	// System.out.println(Paper1);
	// }

	// }

	// catch (Exception e) {
	// if(paper1 == null) {
	// System.out.println("Paper 1 row in the excel sheet is empty for the following
	// " +" number please check the excel sheet");

	// }
	// }

	// try {

	// Paper2 = objectToDataType(paper2);

	// if (Paper2 < 50) {

	// System.out.println("The following Registration number " + " is failed
	// in Paper2 exam");
	// System.out.println(Paper2);
	// }

	// else if (Paper2 >= 50) {
	// System.out.println("The following Registration number " + " is passed
	// in Paper2 exam");
	// System.out.println(Paper2);
	// }

	// else if (Paper2 >= 50) {
	// System.out.println("The following Registration number " + " is passed
	// in Paper2 exam");
	// System.out.println(Paper2);
	// }

	// }

	// catch (Exception e) {

	// System.out.println("Paper 2 row in the excel sheet is empty for the following
	// " +" number please check the excel sheet");

	// }

	// try {
	// Paper3 = objectToDataType(paper3);

	// if (Paper3 < 50) {

	// System.out.println("The following Registration number " + " is failed
	// in Paper3 exam");
	// System.out.println(Paper3);
	// }

	// else if (Paper3 >= 50) {
	// System.out.println("The following Registration number " + " is passed
	// in Paper3 exam");
	// System.out.println(Paper3);
	// }

	// }

	// catch (Exception e) {

	// System.out.println("Paper 3 row in the excel sheet is empty for the following
	// " +" number please check the excel sheet");

	// }

	// try {

	// PraticalExamTotal = objectToDataType(praticalExam);

	// if (PraticalExamTotal < 150) {
	// System.out.println("The following Registration number " + " is Failed
	// in Pratical Exam");
	// System.out.println(PraticalExamTotal);
	// }

	// else if (PraticalExamTotal >= 150) {
	// System.out.println("The following Registration number " + " is Passed
	// in Practical Exam");
	// System.out.println(PraticalExamTotal);
	// }

	// }

	// catch (Exception e) {

	// System.out.println("Pratical Exam row in the excel sheet is empty for the
	// following " +" number please check the excel sheet");

	// }

	// try {

	// TheroryExamTotal = Paper1 + Paper2 + Paper3;

	// TheroryExamTotal = objectToDataType(examTotal);

	// if (TheroryExamTotal < 150) {
	// System.out.println("The following Registration number " + " is Failed
	// in Therory Exam");
	// System.out.println(TheroryExamTotal);
	// }

	// else if (TheroryExamTotal >= 150) {
	// System.out.println("The following Registration number " + " is Passed
	// in Therory Exam");
	// System.out.println(TheroryExamTotal);
	// }
	// }

	// catch (Exception e) {

	// System.out.println("Therory Exam row in the excel sheet is empty for the
	// following " +" number please check the excel sheet");

	// }

	// // System.out.println(studentData);
	// if (regno == null) {

	// System.out.println("No data in Excel file. Stopping execution.");

	// } else {

	// implicitWait( 5000);
	// Thread.sleep(5000);

	// }

	// try {

	// ExamTotalScore = TheroryExamTotal + PraticalExamTotal;

	// ExamTotalScore = objectToDataType(examTotal);

	// if (ExamTotalScore < 300) {
	// System.out.println("The following Registration number " + " is Failed
	// ");
	// System.out.println(ExamTotalScore);
	// }

	// else if (ExamTotalScore >= 300) {
	// System.out.println("The following Registration number " + " is Passed
	// ");
	// System.out.println(ExamTotalScore);
	// }
	// }

	// catch (Exception e) {

	// System.out.println("Exam Total row in the excel sheet is empty for the
	// following " +" number please check the excel sheet");

	// }

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
	}
}
