package Base;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BasePage {
    private String url;
    private Properties prop;

    public BasePage() throws IOException {
        prop = new Properties();
        System.out.println(System.getProperty("user.dir"));
        FileInputStream data = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\config.properties");
        prop.load(data);
    }
    public static WebDriver getDriver() {
        return WebDriverInstance.getDriver();
    }

    public String getUrl() {
        url = prop.getProperty("url");
        return url;
    }

    public void takeSnapshot(String name) throws IOException {
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

        File destFile = new File(System.getProperty("user.dir") + "\\target\\screenshots\\" + timestamp() + ".png");

        FileUtils.copyFile(srcFile, destFile);
    }

    public String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    public static void waitForElementInvisible(WebElement element, int timer) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timer));
        wait.until(ExpectedConditions.invisibilityOfAllElements(element));

    }

}
