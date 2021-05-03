package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {
    static public void waitUntilLoad(WebDriver driver, Integer waitTime, Integer number, String locator){
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(locator), number));
    }
}
