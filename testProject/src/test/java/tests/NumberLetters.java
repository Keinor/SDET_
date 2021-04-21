package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.YandexPage;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import static helpers.Waiters.waitUntilLoad;
public class NumberLetters {
    private static WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("http://yandex.ru");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void searchTest() throws InterruptedException {
        YandexPage yandexPage = PageFactory.initElements(driver, YandexPage.class);
        yandexPage.buttonMailClick();
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());//Получение списка табов
        driver.switchTo().window((String) tabs2.get(1));//Переключение на второй таб в браузере
        yandexPage.inputTypeLogin(""); //логин
        yandexPage.buttonLoginClick();
        yandexPage.buttonPasswordClick("");//пароль
        yandexPage.buttonLoginClick();
        Integer yp = Integer.valueOf(yandexPage.getLettersCount());
        yandexPage.spanMailClick();
        yandexPage.inputThemetext("Simbirsoft theme \n");
        yandexPage.inputMail(yandexPage.getLettersCount());
        yandexPage.buttonSendClick();
        waitUntilLoad(driver, 1000,String.valueOf(yp+1) );
        Assert.assertEquals(yandexPage.getLettersCount(),String.valueOf(yp+1));
    }
    @AfterMethod
    public void after() {
        driver.quit();
    }
}
