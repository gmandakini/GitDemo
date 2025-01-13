package uk.co.automationtesting;

import Base.BasePage;

import java.io.IOException;

import Base.Hooks;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.*;

@Listeners(resources.Listeners.class)
public class OrderCompleteTest extends Hooks {

    public OrderCompleteTest() throws IOException {
        super();
    }

    @Test
    public void endToEndTest() throws InterruptedException, IOException {
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
        cPanel.getCheckoutBtn().click();
        ShoppingCart sCart = new ShoppingCart();
        sCart.getHavePromo().click();
        sCart.getPromoTextBox().sendKeys("20OFF");
        sCart.getPromoAddBtn().click();
        sCart.getProceedToCheckoutBtn().click();

        OrderFormPersInfo pInfo = new OrderFormPersInfo();
        pInfo.getGenderMr().click();
        pInfo.getFirstName().sendKeys("John");
        pInfo.getLastName().sendKeys("Smith");
        pInfo.getEmail().sendKeys("johnsmith1@test.com");
        pInfo.getAgreeTermsCheckbox().click();
        pInfo.getContinueBtn().click();

        OrderFormDelivery orderDelivery = new OrderFormDelivery();
        orderDelivery.getAddressField().sendKeys("123 Main Street");
        orderDelivery.getCityField().sendKeys("Houston");
        Select state = new Select(orderDelivery.getCountryDropdown());
        state.selectByVisibleText("Texas");
        orderDelivery.getPostcodeField().sendKeys("77021");
        orderDelivery.getContinueBtn().click();

        OrderFormShippingMethod orderShipping = new OrderFormShippingMethod();
        orderShipping.getDeliveryMsgBox().sendKeys("This is Order Form Shipping Test");
        orderShipping.getContinueBtn().click();

        OrderFormPayment orderPayment = new OrderFormPayment();
        orderPayment.getPayByCheckRadioBtn().click();
        orderPayment.getTermsConditionsCheckbox().click();
        orderPayment.getOrderBtn().click();
    }
}
