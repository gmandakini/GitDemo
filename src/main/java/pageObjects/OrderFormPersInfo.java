package pageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class OrderFormPersInfo extends BasePage {

    public WebDriver driver;

    By genderMr = By.cssSelector("label:nth-of-type(1)  input[name='id_gender']");
    By genderMrs = By.cssSelector("label:nth-of-type(2)  input[name='id_gender']");
    By firstName = By.cssSelector("input#field-firstname");
    By lastName = By.cssSelector("input#field-lastname");
    By email = By.cssSelector("input#field-email");
    By password = By.cssSelector("input#field-password");
    By birthday = By.cssSelector("input#field-birthday");
    By receiveOfferCheckbox = By.cssSelector(".tab-content .row:nth-child(8) [class] label");
    By agreeTermsCheckbox = By.cssSelector(".tab-content .row:nth-child(9) [class] label");
    By signupNewsLetterCheckbox = By.cssSelector(".tab-content .row:nth-child(10) [class] label");
    By continueButton = By.cssSelector(".tab-content [role='tabpanel']:nth-of-type(1) [name='continue']");

    public OrderFormPersInfo() throws IOException {
        super();
    }

    public WebElement getGenderMr() {
        this.driver = getDriver();
        return driver.findElement(genderMr);
    }

    public WebElement getGenderMrs() {
        this.driver = getDriver();
        return driver.findElement(genderMrs);
    }

    public WebElement getFirstName() {
        this.driver = getDriver();
        return driver.findElement(firstName);
    }

    public WebElement getLastName() {
        this.driver = getDriver();
        return driver.findElement(lastName);
    }

    public WebElement getEmail() {
        this.driver = getDriver();
        return driver.findElement(email);
    }

    public WebElement getPassword() {
        this.driver = getDriver();
        return driver.findElement(password);
    }

    public WebElement getBirthday() {
        this.driver = getDriver();
        return driver.findElement(birthday);
    }

    public WebElement getReceiveOfferCheckbox() {
        this.driver = getDriver();
        return driver.findElement(receiveOfferCheckbox);
    }

    public WebElement getAgreeTermsCheckbox() {
        this.driver = getDriver();
        return driver.findElement(agreeTermsCheckbox);
    }

    public WebElement getSignupNewsLetterCheckbox() {
        this.driver = getDriver();
        return driver.findElement(signupNewsLetterCheckbox);
    }

    public WebElement getContinueBtn() {
        this.driver = getDriver();
        return driver.findElement(continueButton);
    }
}
