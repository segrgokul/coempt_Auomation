package webElement;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportCoursePageXpaths {
	public static WebDriver driver;

	@FindBy(xpath = "//span[@class='nk-menu-text' and contains(text(),'(Admin)')]")
	public WebElement loginTags;


    @FindBy(xpath = "//span[@class='nk-menu-text' and text()='Report Card']")
    public WebElement reportCardOption;
  

	@FindBy(xpath = "//span[@class='nk-menu-text' and text()='Course-wise']")
	 public WebElement reportCardCourse;
		
	 
	  @FindBy(id = "select2-groupdrop-container")
	    public WebElement clgDropDown;  
	    
	  @FindBy(xpath = "//input[@class='select2-search__field']")
		 public WebElement clgTextBox;

		 @FindBy(xpath = "//span[@class='select2-selection select2-selection--single']/span[@id='select2-ddlCourse-container']")
		 public WebElement ProgramCourse;

		 
	  
	  @FindBy(id = "select2-groupdrop-results")
	    public List< WebElement>clgDropDownResults;  
	  


	    public ReportCoursePageXpaths(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this); // Initialize elements
	    }}
