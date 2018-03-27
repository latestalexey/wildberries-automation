package by.wildberries;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends PageObject {

    @FindBy(xpath = "//*[@id=\"basketContent\"]/ul[1]/li[1]/a")
    private WebElement myCabinetButton;

    @FindBy(xpath = "//*[@id=\"top-menu\"]/ul/li[1]/a")
    private WebElement womenSection;

    //@FindBy(id = "tbSrch")
    private WebElement searchField;

    @FindBy(id = "btnSrch")
    private WebElement searchButton;


    @FindBy(xpath = "//*[@id=\"top-menu\"]/ul/li[1]/ul/li[1]/a")
    private WebElement menuClothes; // после ннаведения курсора Женщинам - Одежда

    @FindBy(xpath = "//*[@id=\"main-catalog-menu\"]/ul/li[2]/a")
    private WebElement clothesTab; //после клика Женщинам - Одежда


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isMyCabinetButtonDisplayed() {
        return myCabinetButton.isDisplayed();
    }

    public void clickWomenSection() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(womenSection));
        this.womenSection.click();
    }

    public void setSearchField(String search) {
        if (!driver.findElements(By.xpath("/html/body/div[8]/div/ul/li[1]/div")).isEmpty()) {//popup
            driver.findElement(By.xpath("/html/body/div[8]/div/ul/li[1]/div/button[1]")).click();
        }

       // Wait wait = new WebDriverWait(driver, 10);
       // wait.until(ExpectedConditions.visibilityOf(searchField));

        searchField = driver.findElement(By.id("tbSrch"));
        clearAndSendKeys(searchField, search);
    }

    public SearchResult clickSearchButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        return new SearchResult(driver);
    }

    public SearchResult searchItem(String search) {
        this.setSearchField(search);
        this.searchButton.click();
        return new SearchResult(driver);
    }


    public void hoverWomenSection() {
        Actions action = new Actions(driver);
        action.moveToElement(womenSection).build().perform(); // наведение на меню
    }


    public void clickTabClothes() {
        this.clothesTab.click(); //после клика раздела Женщинам
    }

    public void clickMenuClothes() {
        this.menuClothes.click(); //после наведения курсора на раздел Женщинам
    }


}
