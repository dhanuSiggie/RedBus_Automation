//$Id$
package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	WebDriver driver=null;

	public HomePage(WebDriver driver) {
		this.driver=driver;
	}

	//From Destination
	public void selectFromDestination(String from) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys(from);
		WebElement fromData=driver.findElement(By.xpath("//ul[@class='autoFill homeSearch']"));
		List<WebElement> Cities=fromData.findElements(By.tagName("li"));
		for(WebElement city:Cities) {
			if(city.getText().equals(from)) {
				city.click();
				break;
			}
		}

	}

	//To Destination
	public void selectToDestination(String to) {
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys(to);
		WebElement fromData=driver.findElement(By.xpath("//ul[@class='autoFill homeSearch']"));
		List<WebElement> Cities=fromData.findElements(By.tagName("li"));
		for(WebElement city:Cities) {
			if(city.getText().equals(to)) {
				city.click();
				break;
			}
		}
	}

	//Selecting Date 
	public void selectDate(String journeyDate) {
		driver.findElement(By.id("onward_cal")).click();
		WebElement getCalElement=driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']"));	
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
	public WebElement getSearchButton() {
		return driver.findElement(By.id("search_btn"));
	}

	public void clickOnSearchButton() {
		driver.findElement(By.id("search_btn")).click();
	}
	public void navigateToRydeTab() {
		driver.findElement(By.xpath("//a[@title='rYde']")).click();
	}
	public void navigateTorPool() {
		driver.findElement(By.xpath("//a[text()='rPool']")).click();
	}

}
