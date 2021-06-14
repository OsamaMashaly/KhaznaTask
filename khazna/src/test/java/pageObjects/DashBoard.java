package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.Utilities;

public class DashBoard {

	
	RemoteWebDriver driver; 

	public DashBoard(RemoteWebDriver driver) {
		this.driver = driver ;
	}
	
	By jiraSoftware  = By.xpath("//*[@class='sc-bZQynM kuPakf']");
	By createMain = By.xpath("//*[@id='createGlobalItem']");
	By summary = By.xpath("//*[@id='summary']");
	By description = By.xpath("//*[@id='description-wiki-edit']");
	By createSub = By.xpath("//*[@id='create-issue-submit']");

	By searchButton = By.xpath("//*[@data-test-id='search-dialog-input']");
	
	
	
	
	
	public DashBoard clickJiraSoftware() {
		Utilities.clickOnElement(driver, jiraSoftware);
		return this;
	}
	

	public DashBoard clickCreateMain() {
		Utilities.clickOnElement(driver, createMain );
		return this;
	}
	
	public DashBoard fillSummary(String summaryText) {
	
	Utilities.fillElement(driver, summary, summaryText);
	return this;
	}
	
	public DashBoard fillDescription(String descriptionText) {
		
		Utilities.fillElement(driver, description, descriptionText);
		return this;
		}
	
	public DashBoard clickCreateSub() {
		Utilities.clickOnElement(driver, createSub );
		return this;
	}
	

	public DashBoard clickSearchButton() {
		Utilities.clickOnElement(driver, searchButton);
		return this;
	
	}
	public DashBoard fillSearchButton(String searchKey) {
		
		Utilities.fillElement(driver, searchButton, searchKey);
		return this;
		}
	public DashBoard enterSearchButton() {
		
		Utilities.pressEnter(driver, searchButton);
		return this;
		}
}
