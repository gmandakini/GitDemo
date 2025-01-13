package pageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ShoppingCart extends BasePage {

    public WebDriver driver;

    By havePromo = By.cssSelector(".promo-code-button .collapse-button");
    By promoTextbox = By.cssSelector("input[name='discount_name']");
    By promoAddBtn = By.cssSelector("form[method='post']  span");
    By proceedToCheckoutBtn = By.linkText("PROCEED TO CHECKOUT");
    By deleteItemOne = By.cssSelector(".cart-items .cart-item:nth-of-type(1) .float-xs-left");
    By deleteItemTwo = By.cssSelector(".cart-items .cart-item:nth-of-type(2) .float-xs-left");
    By totalValue = By.cssSelector(".cart-total .value");

    public ShoppingCart() throws IOException {
        super();
    }

    public WebElement getHavePromo() {
        this.driver = getDriver();
        return driver.findElement(havePromo);
    }

    public WebElement getPromoTextBox() {
        this.driver = getDriver();
        return driver.findElement(promoTextbox);
    }

    public WebElement getPromoAddBtn() {
        this.driver = getDriver();
        return driver.findElement(promoAddBtn);
    }

    public WebElement getProceedToCheckoutBtn() {
        this.driver = getDriver();
        return driver.findElement(proceedToCheckoutBtn);
    }

    public WebElement getDeleteItemOne() {
        this.driver = getDriver();
        return driver.findElement(deleteItemOne);
    }

    public WebElement getDeleteItemTwo() {
        this.driver = getDriver();
        return driver.findElement(deleteItemTwo);
    }

    public WebElement getTotalValue() {
        this.driver = getDriver();
        return driver.findElement(totalValue);
    }
}
