package pl.isol;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class PierwszyTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void googleTest() {
        driver.get("http://google.pl");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium");
        driver.findElement(By.xpath("//input[@name='btnK']")).click();
        wait.until(titleIs("Selenium - Szukaj w Google"));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
