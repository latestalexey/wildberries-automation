package by.wildberries;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest extends FunctionalTest {

    User user = new User();


    @Test
    public void successLogin (){
        MainPage mainPage = new MainPage(driver);
        HomePage homePage = mainPage.login(user.getEmail(), user.getPassword());
        Assert.assertTrue("'My cabinet' button should be visible.", homePage.isMyCabinetButtonDisplayed());
    }

    @Test
    public void unSuccessLogin(){
        MainPage mainPage = new MainPage(driver);
        mainPage.wrongLogin(user.getWrongEmail(), user.getWrongPassword());
        Assert.assertTrue("'Incorrect password/email' msg should be visible.", mainPage.isMsgAfterIncorrectLoginDisplayed());

    }

    @Test
    public void loginViaPhone(){
        MainPage mainPage = new MainPage(driver);
        HomePage homePage = mainPage.loginViaPhone(user.getPhoneNumber(), user.getPassword());
        Assert.assertTrue("'My cabinet' button should be visible.", homePage.isMyCabinetButtonDisplayed());
    }

    @Test
    public void loginViaWrongPhone(){
        MainPage mainPage = new MainPage(driver);
        mainPage.loginViaWrongPhone(user.getWrongPhoneNumber(), user.getWrongPassword());
        Assert.assertTrue("'Incorrect password/email' msg should be visible.", mainPage.isMsgAfterIncorrectLoginDisplayed());

    }
}
