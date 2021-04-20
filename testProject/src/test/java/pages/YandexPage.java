package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class YandexPage {

    public YandexPage(WebDriver driver){
        this.driver = driver;
    }

    private WebDriver driver;

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

    @FindBy(css = "span[title='Simbirsoft theme']")
    private List<WebElement> themes;
    @FindBy(css = "span.mail-ComposeButton-Text")
    private WebElement spanMail;
    @FindBy(xpath = "(//div[@data-class-bubble])[1]")
    private WebElement fieldMail;
    @FindBy(xpath = "(//div[@class=\"ComposeContactsList-Item ContactsSuggestItemDesktop\"])[1]")
    private WebElement fieldMailWhom;
    @FindBy(css ="input.composeTextField ")
    private WebElement inputTheme;
    String count;
    @FindBy(xpath ="//div[@role=\"textbox\"]/div")
    private WebElement textareaMail;
    @FindBy(xpath = "//button[@aria-disabled='false']")
    private WebElement buttonSend;



    public void buttonMailClick(){
        buttonMail.click();
    }
    public void inputTypeLogin(String login){
        inputLogin.sendKeys(login);
    }
    public void buttonLoginClick(){
        buttonLogin.click();
    }
    public void buttonPasswordClick(String password){
        inputPassword.sendKeys(password);
    }

    public String countLetters(){
      System.out.println( themes.size());
      count = String.valueOf(themes.size());
      return count;
    }
    public void spanMailClick(){
        spanMail.click();
        fieldMail.click();
        fieldMailWhom.click();
    }
    public void inputThemetext(String themetxt){
        inputTheme.sendKeys(themetxt);
        inputTheme.click();

    }
    public void inputMail(String inputtxt) {
        textareaMail.sendKeys("Найдено "+inputtxt+" писем"+'/'+"ьма");
    }
    public void buttonSendClick(){
        buttonSend.click();
    }



}
