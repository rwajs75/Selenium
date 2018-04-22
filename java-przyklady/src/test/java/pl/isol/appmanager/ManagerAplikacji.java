package pl.isol.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ManagerAplikacji {
    WebDriver driver;
    WebDriverWait wait;

    private PomocnikKoszyka pomocnikKoszyka;
    private String browser;

    public ManagerAplikacji(String browser) {
        this.browser = browser;
    }

    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost/litecart/");
        pomocnikKoszyka = new PomocnikKoszyka(driver, wait);
    }

    public void stop() {
        driver.quit();
        driver = null;
    }

    public PomocnikKoszyka getPomocnikKoszyka() {
        return pomocnikKoszyka;
    }
}
