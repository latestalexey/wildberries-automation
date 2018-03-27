package by.wildberries;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MainPage extends PageObject {


    @FindBy(xpath = "//*[@id=\"basketContent\"]/ul[1]/li[2]/a")
    private WebElement enterButton;


    @FindBy(xpath = "/html/body/ul/li[1]/label/span")
    private WebElement loginViaEmail;

    @FindBy(xpath = "//*[@id=\"basketContent\"]/ul[1]/li[1]/a")
    private WebElement signupButton;

    //   @FindBy(id = "login")
    private WebElement loginField;

    //    @FindBy(id = "password")
    private WebElement passwordField;

    // @FindBy(id = "phoneMobile")
    private WebElement phoneField;


    @FindBy(id = "signIn")
    private WebElement submitButton;

    @FindBy(xpath = "/html/body/ol/li[6]/a")
    private WebElement notRememberPassword;

    @FindBy(id = "rememberMe")
    private WebElement memoryCheckbox;

    @FindBy(xpath = "//*[@id=\"authorize\"]/div/div/div/a")
    private WebElement signUpButton;

    @FindBy(id = "phoneCode")
    private WebElement selectCode;


    @FindBy(xpath = "/html/body/div[1]/a[1]")
    private WebElement vkEntrance;

    @FindBy(xpath = "/html/body/div[1]/a[2]")
    private WebElement facebookEntrance;

    @FindBy(xpath = "/html/body/div[1]/a[5]")
    private WebElement googleEntrance;

    @FindBy(xpath = "/html/body/ul/li[2]/label/span")
    private WebElement loginViaPhone;

    @FindBy(xpath = "//*[@id=\"error\"]/span")
    private WebElement msgAfterIncorrectLogin;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginViaEmail() {
        this.loginViaEmail.click();

    }

    public void clickLoginViaPhone() {
        this.loginViaPhone.click();
    }

    private void enterLogin(String login) {
        loginField = driver.findElement(By.id("login"));
        clearAndSendKeys(loginField, login);
    }

    private void enterPassword(String password) {
        passwordField = driver.findElement(By.id("password"));
        clearAndSendKeys(passwordField, password);
    }

    private void enterPhone(String phone) {
        this.phoneField = driver.findElement(By.id("phoneMobile"));
        clearAndSendKeys(phoneField, phone);
    }

    public ForgotPassword clickForgotPassword() {
        notRememberPassword.click();
        return new ForgotPassword(driver);
    }


    public boolean isMsgAfterIncorrectLoginDisplayed() {
        return msgAfterIncorrectLogin.isDisplayed();
    }

    public HomePage login(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        this.enterButton.click();
        WebElement loginFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginFrame > iframe")));
        driver.switchTo().frame(loginFrame);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        enterLogin(email);
        enterPassword(password);
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
        driver.switchTo().parentFrame();
        return new HomePage(driver);
    }

    public void wrongLogin(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        this.enterButton.click();
        WebElement loginFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginFrame > iframe")));
        driver.switchTo().frame(loginFrame);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        enterLogin(email);
        enterPassword(password);
        submitButton.click();
    }

    public HomePage loginViaPhone(String phone, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        this.enterButton.click();
        WebElement loginFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginFrame > iframe")));
        driver.switchTo().frame(loginFrame);
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        loginViaPhone.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phoneMobile")));
        enterPhone(phone);
        enterPassword(password);
        submitButton.click();
        driver.switchTo().parentFrame();
        return new HomePage(driver);
    }

    public void loginViaWrongPhone(String phone, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        this.enterButton.click();
        WebElement loginFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginFrame > iframe")));
        driver.switchTo().frame(loginFrame);
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        loginViaPhone.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phoneMobile")));
        enterPhone(phone);
        enterPassword(password);
        submitButton.click();
    }

}



