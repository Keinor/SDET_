package tests;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.YandexPage;
import java.util.concurrent.TimeUnit;

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
        yandexPage.buttonPasswordClick("");//пароль
        checkAuthorization();

        int numberThemes = yandexPage.getLettersCount("Simbirsoft theme");

        checkLettersCount();
        yandexPage.inputThemetext("Simbirsoft theme \n");
        yandexPage.inputMail(yandexPage.getLettersCount("Simbirsoft theme"));
        yandexPage.buttonSendClick();
        numberOfThemeToBe(numberThemes);

    }

    @Step("Проверка авторизации: логин AnstyTest  пароль ")
    public static void checkAuthorization(){
        yandexPage.buttonLoginClick();
    }

    @Step("Проверка, что нажата кнопка Написать")
    public static void checkLettersCount(){
        yandexPage.spanMailClick();
    }

    @Step("Проверка, что письмо с темой отправлено")
    public static void numberOfThemeToBe(int numberThemes){
        yandexPage.waitNumberOfThemeToBe("'Simbirsoft theme'", numberThemes + 1);
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
