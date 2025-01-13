package uk.co.automationtesting;

import Base.Hooks;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;


@Listeners(resources.Listeners.class)
public class AddRemoveItemBasketTest extends Hooks {

    public AddRemoveItemBasketTest() throws IOException {
        super();
    }

    @Test
    public void addRemoveItem() throws IOException {
        Homepage home = new Homepage();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click()", home.getTestStoreLink());

        ShopHomepage shopHome = new ShopHomepage();
        shopHome.getProdOne().click();

        ShopProductPage shopProd = new ShopProductPage();
        Select option = new Select(shopProd.getSizeOption());
        option.selectByVisibleText("M");
        shopProd.getQuantityIncrease().click();
        shopProd.getAddToCartBtn().click();

        ShopContentPanel cPanel = new ShopContentPanel();
        cPanel.getContinueShoppingBtn().click();
        shopProd.getHomepageLink().click();
        shopHome.getProdTwo().click();
        shopProd.getAddToCartBtn().click();
        cPanel.getCheckoutBtn().click();

        ShoppingCart sCart = new ShoppingCart();
        sCart.getDeleteItemTwo().click();
        waitForElementInvisible(sCart.getDeleteItemTwo(), 10);
        Assert.assertEquals(sCart.getTotalValue().getText(),"$45.24");


    }
}
