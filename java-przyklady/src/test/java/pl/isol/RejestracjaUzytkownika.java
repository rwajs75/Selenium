package pl.isol;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RejestracjaUzytkownika {

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
    public void testRejestracjaUzytkownika() {
        driver.get("http://localhost/litecart/");
        driver.findElement(By.xpath("//form[@name='login_form']//a")).click();
        Date date = new Date();
        long aktualnyCzas = date.getTime();
        String imie = "Imie" + Long.toString(aktualnyCzas);
        String nazwisko = "Nazwisko"  + Long.toString(aktualnyCzas);
        String mail = imie + "@test.pl";
        String password = "test";
        wpiszDane(By.xpath("//input[@name='firstname']"), imie);
        wpiszDane(By.xpath("//input[@name='lastname']"), nazwisko);
        wpiszDane(By.xpath("//input[@name='address1']"), "Miejska 2");
        wpiszDane(By.xpath("//input[@name='postcode']"), "01-234");
        wpiszDane(By.xpath("//input[@name='city']"), "Warszawa");
        wpiszDane(By.xpath("//input[@name='email']"), mail);
        wpiszDane(By.xpath("//input[@name='phone']"), "+48123456789");
        wpiszDane(By.xpath("//input[@name='password']"), password);
        wpiszDane(By.xpath("//input[@name='confirmed_password']"), password);
        driver.findElement(By.xpath("//button[@name='create_account']")).click();
        driver.findElement(By.xpath("//a[contains(.,'Logout')]")).click();
        sprawdzCzyWylogowany();
        wpiszDane(By.xpath("//input[@name='email']"), mail);
        wpiszDane(By.xpath("//input[@name='password']"), password);
        driver.findElement(By.xpath("//button[@name='login']")).click();
        String czyZalogowany = driver.findElement(By.xpath("//h3[contains(.,'Account')]")).getText();
        Assert.assertEquals(czyZalogowany, "Account");
        driver.findElement(By.xpath("//a[contains(.,'Logout')]")).click();
        sprawdzCzyWylogowany();
        System.out.println(Long.toString(aktualnyCzas));
    }

    private void sprawdzCzyWylogowany() {
        String czyWylogowany = driver.findElement(By.xpath("//h3[contains(.,'Login')]")).getText();
        Assert.assertEquals(czyWylogowany, "Login");
    }

    private void wpiszDane(By lokalizator, String nazwa) {
        driver.findElement(lokalizator).sendKeys(nazwa);
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
