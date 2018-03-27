package by.wildberries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResult extends PageObject {

    public SearchResult(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"catalog-content\"]/div[4]/div[1]")
    private WebElement firstSearchItem;

    public ItemDetails clickFirstSearchItem() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(firstSearchItem));
        this.firstSearchItem.click();
        return new ItemDetails(driver);
    }
}