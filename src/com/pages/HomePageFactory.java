//$Id$
package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {

	WebDriver driver;
	JavascriptExecutor js;

	
	@FindBy(xpath="//input[@id='src']")
	WebElement fromDestination;
	
	@FindBy(xpath="//div[@id='hmb']//ul[@class='config-list']")
	WebElement manageBookingDropDown;

	@FindBy(xpath="//input[@id='dest']")
	WebElement toDestination;

	@FindBy(id="search_btn")
	WebElement searchButton;
	
	@FindBy(xpath="//div[@class='manageHeaderLbl']")
	WebElement manageBookingButton ;
	
	@FindBy(xpath="//a[@title='rYde']")
	WebElement ryde;
	
	@FindBy(xpath="//a[@title='redRail']")
	WebElement redRail;
	
	@FindBy(xpath="//a[text()='Help']")
	WebElement helpLink;

	@FindBy(xpath="//ul[@class='autoFill homeSearch']")
	WebElement allDestinations;
	
	@FindBy(id="onward_cal")
	WebElement datePicker;

	@FindBy(xpath="//div[@id='rb-calendar_onward_cal']")
	WebElement getAllDates;
	
	
	public HomePageFactory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		js=(JavascriptExecutor) driver;
	}
	
	public WebElement getRydeElement() {
		return ryde;
	}
	public WebElement getHelpElement() {
		return helpLink;
	}
	public String getRydeElementHREF() {
		return ryde.getAttribute("href");
	}
	
	public WebElement getRedRailElement() {
		return redRail;
	}
	public String getHREFAttribute(WebElement ele) {
		return ele.getAttribute("href");
	}
	public void selectFromDestination(String from) throws InterruptedException {
		fromDestination.sendKeys(from);
		WebElement fromData=allDestinations;
		List<WebElement> Cities=fromData.findElements(By.tagName("li"));
		for(WebElement city:Cities) {
			if(city.getText().equals(from)) {
				city.click();
				break;
			}
		}

	}
//	public void clickManageBookingButton() {
//		manageBookingButton.click();
//	}
	public void clickManageBookingButton() {
		js.executeScript("arguments[0].click()",manageBookingButton);
	}
	public void selectDate(String journeyDate) {
		datePicker.click();
		WebElement getCalElement=getAllDates;	
		List <WebElement> validDates=getCalElement.findElements(By.tagName("td"));
		for(WebElement date:validDates) {
			if(date.getText().equals(journeyDate)) {
				if(date.isDisplayed() && date.isEnabled()) {
					date.click();
					System.out.println("Date is Selected >>"+date.getText());
					break;
				} else {
					System.out.println("Date is Not visible or Enabled");
				}
			}
		}
	}
	public void selectToDestination(String to) {
		toDestination.sendKeys(to);
		WebElement fromData=allDestinations;
		List<WebElement> Cities=fromData.findElements(By.tagName("li"));
		for(WebElement city:Cities) {
			if(city.getText().equals(to)) {
				city.click();
				break;
			}
		}

	}
	public List<String> getManagedBookingDropDownElementsList() {
		List<WebElement> values=manageBookingDropDown.findElements(By.tagName("li"));
		List<String> ddValues=new ArrayList<String>();
		for(WebElement s:values) {
			ddValues.add(s.getText());
		}
		return ddValues;
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

}
