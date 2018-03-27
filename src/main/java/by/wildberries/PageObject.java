package by.wildberries;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    protected WebDriver driver;


    public PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected static void clearAndSendKeys(final WebElement element, final String keys) {
        element.clear();
        element.sendKeys(keys);
    }


}
