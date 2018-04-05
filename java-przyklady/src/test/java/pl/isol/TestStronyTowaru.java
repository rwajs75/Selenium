package pl.isol;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class TestStronyTowaru {

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
    public void testSprawdzanieStronyTowaru() {
        driver.get("http://localhost/litecart/");
        String nazwa = driver.findElement(By.xpath("//div[@id='box-campaigns']//div[@class='name']")).getText();
        String nowaCena = odczytanaWartosc(By.xpath("//div[@id='box-campaigns']//strong[@class='campaign-price']"));
        String staraCena = odczytanaWartosc(By.xpath("//div[@id='box-campaigns']//s[@class='regular-price']"));
        String cena = odczytanaWartosc(By.xpath("//div[@id='box-campaigns']//span[@class='price']"));
        driver.findElement(By.xpath("//div[@id='box-campaigns']//a[@class='link']")).click();
        String nazwaStrona = odczytanaWartosc(By.xpath("//h1"));
        String nowaCenaStrona = odczytanaWartosc(By.xpath("//div[@id='box-product']//strong[@class='campaign-price']"));
        String staraCenaStrona = odczytanaWartosc(By.xpath("//div[@id='box-product']//s[@class='regular-price']"));
        String cenaStrona = odczytanaWartosc(By.xpath("//div[@id='box-product']//span[@class='price']"));
        Assert.assertEquals(nazwa, nazwaStrona);
        Assert.assertEquals(nowaCena, nowaCenaStrona);
        Assert.assertEquals(staraCena, staraCenaStrona);
        Assert.assertEquals(cena, cenaStrona);
        System.out.println(nazwaStrona);
    }

    private String odczytanaWartosc(By lokalizator) {
        String nowaCena = "";
        if (driver.findElements(lokalizator).size() > 0) {
            nowaCena = driver.findElement(lokalizator).getText();
        }
        return nowaCena;
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
