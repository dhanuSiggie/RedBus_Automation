//$Id$
package com.base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automationvo.CasesVO;
import com.automationvo.ExpectVO;
import com.automationvo.InputVO;
import com.dataproviders.RedBusDataProvider;
import com.pages.HomePageFactory;
import com.util.TestNGAnnotations;

public class RedBusDemo extends TestNGAnnotations {
	private static final String CLASSNAME=RedBusDemo.class.getName();
	private static Logger logger = LogManager.getLogger(CLASSNAME);
	
	WebDriver driver;
	String baseUrl;
	
	@BeforeClass
	public void setup() {
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(dataProviderClass =RedBusDataProvider.class,dataProvider = "data", priority =0)
	public void verifyPageTitle(CasesVO casesVO,InputVO inputVO,ExpectVO expectVO) throws InterruptedException {
		driver.get(inputVO.getBaseURL());
		Assert.assertTrue(driver.getTitle().equals(expectVO.getTitle()));	
		logger.info("Test Successful for Title");
	}
	
	@Test(dataProviderClass =RedBusDataProvider.class,dataProvider = "data", priority =1)
	public void verifyRydeLink(CasesVO casesVO,InputVO inputVO,ExpectVO expectVO) throws InterruptedException {
		HomePageFactory homepage=new HomePageFactory(driver);
		Assert.assertTrue(homepage.getRydeElementHREF().equals(casesVO.getProperties().getProperty("rydeLink")));	
		logger.info("Test Successful for Ryde Link Verification");
	}
	@Test(dataProviderClass =RedBusDataProvider.class,dataProvider = "data", priority =1)
	public void verifyRedRailLink(CasesVO casesVO,InputVO inputVO,ExpectVO expectVO) throws InterruptedException {
		HomePageFactory homepage=new HomePageFactory(driver);
		Assert.assertTrue(homepage.getHREFAttribute(homepage.getRedRailElement()).equals(casesVO.getProperties().getProperty("redRailLink")));	
		logger.info("Test Successful for Red Rail Link Verification");
	}
	@Test(dataProviderClass =RedBusDataProvider.class,dataProvider = "data", priority =1)
	public void verifyHelpLink(CasesVO casesVO,InputVO inputVO,ExpectVO expectVO) throws InterruptedException {
		HomePageFactory homepage=new HomePageFactory(driver);
		Assert.assertTrue(homepage.getHREFAttribute(homepage.getHelpElement()).equals(casesVO.getProperties().getProperty("helpLink")));	
		logger.info("Test Successful for Help Link Verification");
	}
	@AfterTest
	public void quit() {
		driver.quit();
	}
}
