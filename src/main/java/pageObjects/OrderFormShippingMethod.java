package pageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class OrderFormShippingMethod extends BasePage {

    public WebDriver driver;

    By clickAndCollect = By.cssSelector(".delivery-options .js-delivery-option:nth-of-type(1) .float-xs-left span");
    By myCarrier = By.cssSelector(".delivery-options .js-delivery-option:nth-of-type(4) [type]");
    By deliveryMsgTextBox = By.cssSelector("textarea#delivery_message");
    By continueBtn = By.cssSelector("[name='confirmDeliveryOption']");

    public OrderFormShippingMethod() throws IOException {
        super();
    }

    public WebElement getClickAndCollect() {
        this.driver = getDriver();
        return driver.findElement(clickAndCollect);
    }

    public WebElement getMyCarrier() {
        this.driver = getDriver();
        return driver.findElement(myCarrier);
    }

    public WebElement getDeliveryMsgBox() {
        this.driver = getDriver();
        return driver.findElement(deliveryMsgTextBox);
    }

    public WebElement getContinueBtn() {
        this.driver = getDriver();
        return driver.findElement(continueBtn);
    }
}
