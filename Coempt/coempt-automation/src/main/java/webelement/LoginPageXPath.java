package webelement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageXPath {
	   public static WebDriver driver;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@id='btnLogin']]")
    public WebElement signinBtn;
    
    @FindBy(xpath = "//span[@class='nk-menu-text' and contains(text(),'(Admin)')]")
    public WebElement adminDropdown;
   
    @FindBy(xpath = "//span[contains(text(),'Sign out')]")
    private WebElement signOutButton;

    @FindBy(xpath = "//span[contains(text(),'Dashboard')]")
    private WebElement dashboard;

    @FindBy(xpath = "//tr[@role='row']//span[@class='dt-column-title']")
    private List<WebElement> dashboardResultOptions;

    @FindBy(xpath = "//li[@class='nk-menu-item has-sub current-page' or @class='nk-menu-item has-sub current-page active']")
    private WebElement masterButton;

    @FindBy(xpath = "(//ul[@class='nk-menu-sub'])[1]//span")
    private List<WebElement> subModuleList;

    @FindBy(xpath = "//span[text()='Master']")
    private WebElement master;

    @FindBy(xpath = "//tr[@role='row']//span[@class='dt-column-title']")
    private List<WebElement> masterResultOptions;
    
    @FindBy(xpath = "//a[@id='btnAddNew']/span")
    private WebElement addNewButton;

    @FindBy(xpath = "//input[@id='txtClgCode']")
    private WebElement clgCodeInput;

    @FindBy(xpath = "//input[@id='txtClgName']")
    private WebElement clgNameInput;

    @FindBy(id = "txtPrncplName")
    private WebElement principleNameInput;

    @FindBy(id = "txtOfcTelNo")
    private WebElement phoneNoInput;

    @FindBy(id = "txtMobileNo")
    private WebElement mobileNoInput;

    @FindBy(id = "txtEmail")
    private WebElement emailInput;

    @FindBy(id = "txtexamincharge")
    private WebElement examInchargeInput;

    @FindBy(id = "txtColAdd")
    private WebElement clgAddressInput;

    @FindBy(xpath = "//span[contains(@class,'select2-selection') and @aria-expanded='true' or @aria-expanded='false']")
    private WebElement selectDropdown;

    
    public LoginPageXPath(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize elements
    }}