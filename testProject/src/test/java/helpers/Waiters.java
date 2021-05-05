package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {
    static public void waitUntilClickable(WebDriver driver, Integer waitTime, WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    static public void waitUntilLoad(WebDriver driver, Integer waitTime, Integer number, String locator){
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(locator), number));
    }
}
