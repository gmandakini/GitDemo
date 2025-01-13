package pageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ShopContentPanel extends BasePage {

    public WebDriver driver;

    By continueShoppingBtn = By.cssSelector(".cart-content-btn [data-dismiss]");
    By checkoutBtn = By.cssSelector(".cart-content-btn .btn-primary");

    public ShopContentPanel() throws IOException {
        super();
    }

    public WebElement getContinueShoppingBtn() {
        this.driver = getDriver();
        return driver.findElement(continueShoppingBtn);
    }

    public WebElement getCheckoutBtn() {
        this.driver = getDriver();
        return driver.findElement(checkoutBtn);
    }
}
