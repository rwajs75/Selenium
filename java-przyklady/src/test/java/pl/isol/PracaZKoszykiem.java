package pl.isol;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class PracaZKoszykiem {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testPracyZKoszykiem() {
        driver.get("http://localhost/litecart/");
        for (int i = 1; i < 4; i++) {
            driver.findElement(By.xpath("//div[@id='box-most-popular']//a[@class='link']")).click();
            if (czyJestWidocznyElement(By.xpath("//select[@name='options[Size]']"))) {
                klik(By.xpath("//select[@name='options[Size]']"));
                klik(By.xpath("//option[@value='Medium']"));
            }
            klik(By.xpath("//button[@name='add_cart_product']"));
            wait.until(textToBePresentInElement(By.xpath("//span[@class='quantity']"), Integer.toString(i)));
            klik(By.xpath("//img[@alt='My Store']"));
        }
        klik(By.xpath("//a[contains(.,'Checkout »')]"));
        for (int j = 2; j > -1; j--) {
            klik(By.xpath("//button[@value='Remove']"));
            wait.until(numberOfElementsToBe(By.xpath("//tbody//td[@class='item']"), j));
        }
    }

    private boolean czyJestWidocznyElement(By lokalizator) {
        try {
            driver.findElement(lokalizator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    private void klik(By lokalizator) {
        driver.findElement(lokalizator).click();
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
