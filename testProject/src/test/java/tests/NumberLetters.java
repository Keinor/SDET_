package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.YandexPage;

import java.util.concurrent.TimeUnit;

import static helpers.Waiters.waitUntilLoad;

public class NumberLetters {
    public static YandexPage yandexPage;
    private static WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();

        yandexPage = new YandexPage(driver);

        driver.get("http://yandex.ru");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void searchTest() {
        yandexPage.buttonMailClick();
        yandexPage.inputTypeLogin("AnstyTest"); //логин
        yandexPage.buttonLoginClick();
        yandexPage.buttonPasswordClick("Ssf!!77117711");//пароль
        yandexPage.buttonLoginClick();

        int numberThemes = yandexPage.getLettersCount("Simbirsoft theme");

        yandexPage.spanMailClick();
        yandexPage.inputThemetext("Simbirsoft theme \n");
        yandexPage.inputMail(yandexPage.getLettersCount("Simbirsoft theme"));
        yandexPage.buttonSendClick();
        yandexPage.waitNumberOfThemeToBe("'Simbirsoft theme'", numberThemes + 1);
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
