package by.wildberries;

import org.junit.Assert;
import org.junit.Test;

public class AddToCardTest extends FunctionalTest {

    User user = new User();

    @Test
    public void addToCardTest() {
       MainPage mainPage = new MainPage(driver);
        HomePage homePage = mainPage.login(user.getEmail(), user.getPassword());
        SearchResult searchResult = homePage.searchItem(user.getSearchParameter());
        ItemDetails itemDetails = searchResult.clickFirstSearchItem();
        itemDetails.selectSize();
        CartPage cartPage = itemDetails.goToCart();
        Assert.assertTrue(driver.getCurrentUrl().startsWith("https://lk.wildberries.by/basket"));
    }

}
