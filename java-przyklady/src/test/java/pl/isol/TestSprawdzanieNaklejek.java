package pl.isol;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class TestSprawdzanieNaklejek {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {

        //driver = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testSprawdzanieNaklejek() {
        driver.get("http://localhost/litecart/");
        int liczbaBlokow = driver.findElements(By.className("products")).size();
        for (int i = 1; i < liczbaBlokow + 1; i++) {
            String nazwaBloku = driver.findElement(
                    By.xpath("//ul[@class='listing-wrapper products']/../../../div[@class='box'][" + Integer.toString(i) + "]"))
                    .getAttribute("id");
            int liczbaArtukulowWBloku = driver.findElements(By.xpath("//div[@id='" + nazwaBloku + "']//li")).size();
            for (int j = 1; j < liczbaArtukulowWBloku +1; j++) {
                int sticker = driver.findElements(
                        By.xpath("//div[@id='" + nazwaBloku + "']//li[" + Integer.toString(j) + "]//div/div")).size();
                Assert.assertTrue(sticker == 1);
            }
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}