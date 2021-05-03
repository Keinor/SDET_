package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;
import static helpers.Waiters.waitUntilLoad;

public class YandexPage {

    private final WebDriver driver;

    Integer count;

    @FindBy(xpath = "(//div[@class='desk-notif-card__login-new-item-title'])[2]")
    private WebElement buttonMail;

    @FindBy(css = "input[id='passp-field-login']")
    private WebElement inputLogin;

    @FindBy(css = "input[id='passp-field-passwd']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@data-t='button:action']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//button[@data-t='button:pseudo']")
    private WebElement buttonNotNow;

    @FindBy(css = "span.mail-MessageSnippet-Item_subject")
    private List<WebElement> themes;

    @FindBy(css = "span.mail-ComposeButton-Text")
    private WebElement spanMail;

    @FindBy(xpath = "(//div[@data-class-bubble])[1]")
    private WebElement fieldMail;

    @FindBy(xpath = "(//div[@class=\"ComposeContactsList-Item ContactsSuggestItemDesktop\"])[1]")
    private WebElement fieldMailWhom;

    @FindBy(css = "input.composeTextField ")
    private WebElement inputTheme;

    @FindBy(xpath = "//div[@role=\"textbox\"]/div")
    private WebElement textareaMail;

    @FindBy(xpath = "//button[@aria-disabled='false']")
    private WebElement buttonSend;

    @FindBy(xpath = "//a[@href=\"#inbox\"]")
    private WebElement linkClose;

    @FindBy(xpath = "//span[@data-click-action='mailbox.check']")
    private WebElement checkLetters;

    public YandexPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void buttonMailClick() {
        buttonMail.click();
        List<String> tabs2;
        tabs2 = new ArrayList(driver.getWindowHandles());//Получение списка табов
        driver.switchTo().window((String) tabs2.get(1));//Переключение на второй таб в браузере
    }

    public void inputTypeLogin(String login) {
        inputLogin.sendKeys(login);
    }

    public void buttonLoginClick() {
        buttonLogin.click();
    }

    public void buttonPasswordClick(String password) {
        inputPassword.sendKeys(password);
    }

    public Integer getLettersCount(String theme) {
        count = 0;
        for (WebElement i : themes) {
            if (i.getText().equals(theme)) {
                count++;
            }
        }
        return count;
    }

    public void spanMailClick() {
        spanMail.click();
        fieldMail.click();
        fieldMailWhom.click();
    }

    public void inputThemetext(String themetxt) {
        inputTheme.sendKeys(themetxt);
        inputTheme.click();
    }

    public void inputMail(Integer inputtxt) {
        textareaMail.sendKeys("Найдено " + inputtxt + " писем" + '/' + "ьма");
    }

    public void buttonSendClick() {
        buttonSend.click();
        linkClose.click();
        checkLetters.click();
    }

    public void waitNumberOfThemeToBe(String theme, int number) {
        String topicSearch = "span[title=" + theme + "]";
        waitUntilLoad(driver, 1000, number, topicSearch);
    }
}
