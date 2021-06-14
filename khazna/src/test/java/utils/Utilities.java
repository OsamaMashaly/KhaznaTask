package utils;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {


	public static void clickOnElement(RemoteWebDriver driver, By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            while (!element.isDisplayed()) {
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            }
            driver.findElement(by).click();



        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println("Error!! Could not find Clickable Element for the first time");
        }
    }
	
	public static void fillElement(RemoteWebDriver driver, By element, String text) {
		if (text != null || text.equalsIgnoreCase("")) {
            WebDriverWait wait = new WebDriverWait(driver, 50);
            WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(element));



            try {
                while (!el.isDisplayed()) {
                    el = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
                }
                el.clear();
                el.sendKeys(text);


            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Error!! Could not find visible element to enter text into it ");
            }
        } else {
            System.out.println("The entered Text is null or empty !!");
        }
    }
	
	public static String extractTextFromElement(RemoteWebDriver driver, By element) {
		WebElement elem = null;

		String extractedText = null;
		try {
			WebElement result = new WebDriverWait(driver, 5)
					.until(ExpectedConditions.visibilityOfElementLocated(element));
			elem = driver.findElement(element);

			extractedText = elem.getText();

		} catch (Exception e) {
			System.out.println("could not find text");
		}
		return extractedText;

	}
	
	public static boolean checkDisplayed(RemoteWebDriver driver, By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            while (!element.isDisplayed()) {
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            }
            return driver.findElement(by).isDisplayed();



        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println("Error!! Could not find Element for the first time");
            return false;
        }
    }
	
	public static void pressEnter(RemoteWebDriver driver, By element) {
		
            WebDriverWait wait = new WebDriverWait(driver, 50);
            WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(element));



            try {
                while (!el.isDisplayed()) {
                    el = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
                }
               
                el.sendKeys(Keys.ENTER);


            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Error!! Could not find visible element to enter");
            }
       
    }
	
	



	
}
