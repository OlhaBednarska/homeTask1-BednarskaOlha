package lesson1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class HomeTaskImageTest {
    @Test
    public void verifyImageTabContainsImages() throws IOException {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://google.com/");
        driver.findElement(By.name("q")).sendKeys(("la la land" + Keys.ENTER));
        driver.findElement(By.xpath("//div[@class='hdtb-mitem']//a[contains(@href,'isch')]")).click();
        driver.findElement(By.xpath("//img[@class='rg_i Q4LuWd']")).click();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='mJxzWe']")));
        File scrFile = element.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(scrFile, new File("./src/screenshot/element.png"));
        Assert.assertTrue(element.isDisplayed());

        driver.quit();
    }
}
