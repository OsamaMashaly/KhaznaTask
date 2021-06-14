package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import utils.ExcelToDataProvider;
import utils.Utilities;
import pageObjects.DashBoard;


public class CreateIssue {

	RemoteWebDriver driver; // declare driver

	
	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/macbookpro/Downloads/chromedriver 2");
		 driver = new ChromeDriver();
		driver.get("https://www.atlassian.com/software/jira");
	}
	
	 @DataProvider(name = "CreateNewIssue")
	  public static Object[][] createNewIssue() throws Exception {
	        return ExcelToDataProvider.getNewIssueData("/Users/macbookpro/Desktop/testKhazna.xlsx", "Sheet1"); 
	  }
	
	@Test(dataProvider = "CreateNewIssue")
	public void creatNewIssue(String sUsername, String sPassword , String issueName , String issueDescription) {
		
		
//		login 
		
		LoginPage test = new LoginPage(driver);
		test.clickmyAccount().clickLogin().fillEnterEmail(sUsername).clickContinueButton()
		.clickPassword().fillPassword(sPassword)
		.clickLoginButton();
		
//		open dash board and create new issue 
		DashBoard t = new DashBoard(driver);
		t.clickJiraSoftware().clickSearchButton()
		.clickCreateMain()
		.fillSummary(issueName).fillDescription(issueDescription).clickCreateSub()
		.fillSearchButton(issueName).enterSearchButton();
		String elementToCheck = "//*[@title='"+issueName + "']"; 
		By assertCheck = By.xpath(elementToCheck);
		boolean d = Utilities.checkDisplayed(driver, assertCheck);


//		check the newly created issue 
		Assert.assertEquals(true, d);
		
	}
	
	 @DataProvider(name = "SearchNewIssue")
	  public static Object[][] searchIssue() throws Exception {
	        return ExcelToDataProvider.getSearchIssueData("/Users/macbookpro/Desktop/SearchIssue.xlsx", "Sheet1"); 
	  }
	 
	 @Test(dataProvider = "SearchNewIssue")
		public void searchIssue( String sUsername, String sPassword , String issueName ) {
			
			
//			login 
			
			LoginPage test = new LoginPage(driver);
			test.clickmyAccount().clickLogin().fillEnterEmail(sUsername).clickContinueButton()
			.clickPassword().fillPassword(sPassword)
			.clickLoginButton();
			
//			open dash board and create new issue 
			DashBoard t = new DashBoard(driver);
			t.clickJiraSoftware().clickSearchButton()
			.fillSearchButton(issueName).enterSearchButton();
			String elementToCheck = "//*[@title='"+issueName + "']"; 
			By assertCheck = By.xpath(elementToCheck);
			boolean d = Utilities.checkDisplayed(driver, assertCheck);


//			check the newly created issue 
			Assert.assertEquals(true, d);
			
		}
	
	@AfterMethod
	public void afterMethod() throws Exception {
		driver.quit();
	}

}
