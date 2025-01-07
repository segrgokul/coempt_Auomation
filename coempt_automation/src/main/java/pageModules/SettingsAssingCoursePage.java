package pageModules;

import base.BasicFunctions;
import webElement.SettingsAssignCoursePageXpaths;

public class SettingsAssingCoursePage extends BasicFunctions {

	
	
		public void check() {
			SettingsAssignCoursePageXpaths AssignCourse = new SettingsAssignCoursePageXpaths(driver);
			
			jsScroll(AssignCourse.settingsOption);
			
			implicitWait(30);	
			fluentWait(AssignCourse.loginTags,30);		
	
		if (AssignCourse.loginTags.isDisplayed()) {
			
			implicitWait(30);	
	   		explicitWait(AssignCourse.loginTags,30);
			
	   		jsScroll(AssignCourse.settingsOption);
		
		}
		
			implicitWait(30);	
	   		explicitWait(AssignCourse.settingsOption,30);
	   		click(AssignCourse.settingsOption);
	   		
	   		
		
	   		implicitWait(30);	
	   		explicitWait(AssignCourse.assignCourse,30);
			
    		jsScroll(AssignCourse.assignCourse);
    		implicitWait(30);	
    		fluentWait(AssignCourse.assignCourse,30);
	   		click(AssignCourse.assignCourse);
	   		
	   		if(AssignCourse.entriesDropDown.isDisplayed()||AssignCourse.assignCourseBtns.get(0).isDisplayed()) {
	   			
	   			for (int i=0;i<=4;i++) {
	   				
	   				implicitWait(30);	
	   				fluentWait(AssignCourse.assignCourseBtns.get(i),30);
	   				AssignCourse.assignCourseBtns.get(i).click();
	   			}
	   			
	   			for (int i=0;i<=3;i++) {
	   				
	   				implicitWait(30);	
		    		fluentWait(AssignCourse.nextPageNavigation,30);
			   		click(AssignCourse.nextPageNavigation);
	   			}
	   			
	   			
	   			
	   		}
}}
