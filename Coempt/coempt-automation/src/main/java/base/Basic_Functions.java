package base;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import browsers.BrowserManager;

public class Basic_Functions extends BrowserManager{
	
	

	
	
	//i wait until timeout sec but i will loop it for every seconds i menioned in durations of seconds
	public static WebElement fluentWait(WebDriver driver, final WebElement ele,int timeoutInSec) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeoutInSec))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementWaitedFor = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return ele;
			}
		});
		return elementWaitedFor;
	}
	
	//i wait until element gets display,clickable,visibe
	public static WebElement explicitWait(WebDriver driver, final WebElement ele, int timeoutInSec) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSec));
	    WebElement elementWaitedFor = wait.until(new ExpectedCondition<WebElement>() {
	        public WebElement apply(WebDriver driver) {
	            return ele.isDisplayed() ? ele : null;
	        }
	    });
	    return elementWaitedFor;
	}
	
	//i wait until the timeout sec
	public static void implicitWait(WebDriver driver, int timeoutInSec) {
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutInSec));
	}
	
	
	    public static void click(WebDriver driver, WebElement element) {
	        element.click();
	    }
	
	public void clear(WebDriver driver,WebElement ele) {

	
		    ele.clear();
		
	}


	public void CLICK1(WebDriver driver, final List<WebElement> ele) {

		((WebElement) ele).click();
	}

	
	public void SENDKEYS( final WebElement ele, String value) {

	
		ele.sendKeys(value);
	}


	public void jsScroll(WebDriver driver, final WebElement ele) {


		JavascriptExecutor js = (JavascriptExecutor) driver;	
		js.executeScript("arguments[0].scrollIntoView();", ele);

	}

	public void jsScrolltillend(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void jsScrolltilltop(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	}
	
	public void explicityWait(WebDriver driver,WebElement ele, int second) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(second));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	public String incrementPhoneNumber(String phoneNumber) {
	        long number = Long.parseLong(phoneNumber) + 1;
	        return String.valueOf(number);
	    }
	  public boolean isElementPresent(WebDriver driver, WebElement ele) {
	        try {
	        	
	        	return ele != null;
	        } catch (org.openqa.selenium.NoSuchElementException e) {
	            // Return false if element is not found
	            return false;
	        }
	    }


}