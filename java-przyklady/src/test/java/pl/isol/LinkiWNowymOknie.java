package pl.isol;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LinkiWNowymOknie {

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
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        wprowadzTekst(By.xpath("//input[@name='username']"), "root");
        wprowadzTekst(By.xpath("//input[@name='password']"), "root");
        klik(By.xpath("//button[@name='login']"));
        int liczbaKrajow = driver.findElements(By.xpath("//*[@id='content']/form/table/tbody//td[7]/a")).size();
        int i = new Random().nextInt(liczbaKrajow + 2);
        klik(By.xpath("//*[@id='content']/form/table/tbody/tr[" + i + "]/td[7]/a"));
        Set<String> stareOkna = driver.getWindowHandles();
        String biezaceOkno = driver.getWindowHandle();
        System.out.println("Tytuł okna: " + driver.getTitle());
        List<WebElement> zewnetrzneLinki = driver.findElements(By.cssSelector(".fa-external-link"));
        for (int j = 0; j < zewnetrzneLinki.size(); j++) {
            zewnetrzneLinki.get(j).click();
            String noweOkno = wait.until(thereIsWindowOtherThan(stareOkna));
            driver.switchTo().window(noweOkno);
            System.out.println("Tytuł okna: " + driver.getTitle());
            driver.close();
            driver.switchTo().window(biezaceOkno);
            System.out.println("Tytuł okna: " + driver.getTitle());
        }
    }

    private ExpectedCondition<String> thereIsWindowOtherThan(Set<String> stareOkna) {
        return input -> {
            Set<String> handles = input.getWindowHandles();
            handles.removeAll(stareOkna);
            return handles.size() > 0 ? handles.iterator().next() : null;
        };
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
