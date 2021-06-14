package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.Utilities;


public class LoginPage {

	
	RemoteWebDriver driver; // declare driver
	
	public LoginPage(RemoteWebDriver driver) {
		this.driver = driver ;
	}
	
	By myAccount = By.xpath("//*[@id='imkt-jsx--3642d018']");
	By login = By.xpath("//*[@class='sc-kkGfuU IatsZ']");
	By enterEmail = By.xpath("//*[@id='username']");
	By continueButton = By.xpath("//*[@id='login-submit']");
	By password = By.xpath("//*[@id='password']");
//	By password = By.xpath("//*[@class= 'Content-ve26fj-1 kmGRCO']");
	By loginButton = By.xpath("//*[@id='login-submit']");
	By project  = By.xpath("//*[@class='sc-bZQynM kuPakf']");
	
	
	public LoginPage clickProject() {
		Utilities.clickOnElement(driver, project);
		return this;
	}
	
	public LoginPage clickmyAccount() {
		
		Utilities.clickOnElement(driver, myAccount);
		return this;
	}
	
	public LoginPage clickLogin() {
		
		Utilities.clickOnElement(driver, login);
		return this;
	}
	
	public LoginPage fillEnterEmail(String userName) {
		
		Utilities.fillElement(driver, enterEmail, userName);
		return this;
	}
	
	public LoginPage clickContinueButton () {
		Utilities.clickOnElement(driver, continueButton);
		return this;
	}
	

	public LoginPage clickPassword() {
		Utilities.clickOnElement(driver, password);
		return this;
	}
	
	public LoginPage fillPassword(String password) {
		
		Utilities.fillElement(driver, this.password, password);
		return this;
	}
	
	public LoginPage clickLoginButton () {
		Utilities.clickOnElement(driver, loginButton);
		return this;
	}
	
	
	
}
