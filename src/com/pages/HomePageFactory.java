//$Id$
package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.CommonUtil;

public class HomePageFactory  extends CommonUtil {

	JavascriptExecutor js;
	Actions action;
	
	@FindBy(xpath="//input[@id='src']")
	private WebElement fromDestination;
	
	@FindBy(xpath="//a[text()='redbus']")
	private WebElement redBusLogo;
	
	@FindBy(xpath="//div[@id='hmb']//ul[@class='config-list']")
	private WebElement manageBookingDropDown;

	@FindBy(xpath="//input[@id='dest']")
	private WebElement toDestination;

	@FindBy(id="search_btn")
	private WebElement searchButton;
	
	@FindBy(xpath="//div[@class='manageHeaderLbl']")
	private WebElement manageBookingButton ;
	
	@FindBy(xpath="//a[@title='rYde']")
	private WebElement ryde;
	
	@FindBy(xpath="//a[@title='redRail']")
	private WebElement redRail;
	
	@FindBy(xpath="//a[text()='Help']")
	private WebElement helpLink;

	@FindBy(xpath="//ul[@class='autoFill homeSearch']")
	private WebElement allDestinations;
	
	@FindBy(id="onward_cal")
	private WebElement datePicker;

	@FindBy(xpath="//div[@id='rb-calendar_onward_cal']")
	private WebElement getAllDates;
	
	
	public HomePageFactory(WebDriver driver) {
		js=(JavascriptExecutor) driver;
		action=new Actions(driver); //Setting action in Constructor
		PageFactory.initElements(driver,this);
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
	
	//Scroll to Bottom of the Homepage.
	public void scrollToBottom() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)","");
	}
	//Scroll to Bottom of the Homepage.
	public void scrollToTop() {
			js.executeScript("window.scrollTo(0,0)","");
		}
	//Right Click
	public void rightClick() {
		action.contextClick().perform();
	}
	//Move Mouse
	public void moveMouseToHomePageRedBusLogo() {
		action.moveToElement(redBusLogo).perform();
	}
	public static HomePage getInstance(WebDriver driver) {
		return new HomePage(driver);
	}

}
