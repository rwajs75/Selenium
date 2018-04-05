package pl.isol;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class DodawanieArtykulu {

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
    public void testSprawdzanieSortowaniaKrajow() {
        driver.get("http://localhost/litecart/admin/");
        wprowadzTekst(By.xpath("//input[@name='username']"), "root");
        wprowadzTekst(By.xpath("//input[@name='password']"), "root");
        klik(By.xpath("//button[@name='login']"));
        klik(By.xpath("//span[contains(.,'Catalog')]"));
        klik(By.xpath("//a[contains(.,' Add New Product')]"));
        klik(By.xpath("//input[@name='status'][@value='1']"));
        Date date = new Date();
        long aktualnyCzas = date.getTime();
        String nazwa = "Kaczka " + aktualnyCzas;
        wprowadzTekst(By.name("name[en]"), nazwa);
        wprowadzTekst(By.name("code"), Long.toString(aktualnyCzas));
        Random random = new Random();
        klik(By.xpath("//input[@name='categories[]'][@value='" + Integer.toString(random.nextInt(1) + 1) + "']"));
        klik(By.xpath("//input[@name='product_groups[]'][@value='1-" + Integer.toString(random.nextInt(2) + 1) + "']"));
        wyczyscPoleIWprowadzDane(By.name("quantity"), Integer.toString(random.nextInt(30)));
        File obrazek = new File("src/test/resources/tester.png");
        wprowadzTekst(By.name("new_images[]"), obrazek.getAbsolutePath());
        wprowadzTekst(By.name("date_valid_from"), "0020180101");
        wprowadzTekst(By.name("date_valid_to"), "0020181231");
        //Zakładka Information
        klik(By.xpath("//a[contains(.,'Information')]"));
        klik(By.name("manufacturer_id"));
        klik(By.xpath("//option[contains(.,'ACME Corp.')]"));
        wprowadzTekst(By.name("short_description[en]"), Long.toString(aktualnyCzas));
        wprowadzTekst(By.xpath("//div[@class='trumbowyg-editor']"), Long.toString(aktualnyCzas));
        wprowadzTekst(By.name("head_title[en]"), Long.toString(aktualnyCzas));
        wprowadzTekst(By.name("meta_description[en]"), Long.toString(aktualnyCzas));
        //Zakładka Prices
        klik(By.xpath("//a[contains(.,'Prices')]"));
        wyczyscPoleIWprowadzDane(By.name("purchase_price"), Integer.toString(random.nextInt(30)));
        klik(By.name("purchase_price_currency_code"));
        klik(By.xpath("//option[@value='EUR']"));
        wyczyscPoleIWprowadzDane(By.name("gross_prices[USD]"), Integer.toString(random.nextInt(30)));
        wyczyscPoleIWprowadzDane(By.name("gross_prices[EUR]"), Integer.toString(random.nextInt(30)));
        klik(By.xpath("//button[@name='save']"));
        String nazwaNaLiscie = driver.findElement(By.xpath("//a[contains(.,'" + nazwa + "')]")).getText();
        Assert.assertEquals(nazwaNaLiscie, nazwa);
    }

    private void wyczyscPoleIWprowadzDane(By lokalizator, String tekst) {
        driver.findElement(lokalizator).clear();
        driver.findElement(lokalizator).sendKeys(tekst);
    }

    private void wprowadzTekst(By lokalizator, String tekst) {
        driver.findElement(lokalizator).sendKeys(tekst);
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
