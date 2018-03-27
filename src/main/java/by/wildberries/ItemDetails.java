package by.wildberries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ItemDetails extends PageObject {

    @FindBy(css = ".cart-btn-wrap button.j-add-to-card")
    private WebElement addToBasketButton;

    @FindBy(css = ".cart-btn-wrap .j-go-to-basket")
    private WebElement goToCartButton;


    public ItemDetails(WebDriver driver) {
        super(driver);
    }

    public void selectSize() {
        List<WebElement> activeSizeButtons = driver.findElements(By.cssSelector("#GoodCharacteristic > .j-size:not(.disabled)"));

        if (activeSizeButtons.isEmpty()) {
            throw new RuntimeException("No sizes available to select");
        }

        WebElement firstActiveSizeButton = activeSizeButtons.get(0);

        firstActiveSizeButton.click();
    }

    public CartPage goToCart() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(addToBasketButton));
        this.addToBasketButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(goToCartButton));
        this.goToCartButton.click();
        return new CartPage(driver);
    }

}
