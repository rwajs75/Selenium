package pl.isol;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static java.lang.Thread.sleep;

public class SprawdzanieWLogach {

    private EventFiringWebDriver driver;
    private WebDriverWait wait;

    public class MyListner extends AbstractWebDriverEventListener {
        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by + " - element został znaleziony");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            System.out.println(throwable);
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String teraz = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            try {
                FileUtils.copyFile(scrFile,new File("src/test/resources/ZrzutyEkranu/wystapilBlad" + teraz + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Plik ze zrzutem ekranu błędu: wystapilBlad" + teraz + ".png");
        }

        @Override
        public void beforeNavigateTo(String url, WebDriver driver) {
            System.out.println(url);
        }

        @Override
        public void afterNavigateTo(String url, WebDriver driver) {
            System.out.println(url);
        }
    }

    @Before
    public void start() {
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        driver = new EventFiringWebDriver(new ChromeDriver(cap));
        driver.register(new MyListner());
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testSprawdzanieSortowaniaKrajow() throws InterruptedException {
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        System.out.println(driver.manage().logs().getAvailableLogTypes());
        driver.manage().logs().get("performance").forEach(l -> System.out.println(l));
        wprowadzTekst(By.xpath("//input[@name='username']"), "root");
        wprowadzTekst(By.xpath("//input[@name='password']"), "root");
        klik(By.xpath("//button[@name='login']"));
        List<WebElement> listaProduktow = driver.findElements(By.xpath("//tbody//td/a[@title='Edit']"));
        System.out.println(listaProduktow.size());
        for (int i = 1; i < listaProduktow.size(); i++) {
            listaProduktow.get(i).click();
            klik(By.name("cancel"));
            listaProduktow = driver.findElements(By.xpath("//tbody//td/a[@title='Edit']"));
        }
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
