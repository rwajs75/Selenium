package pl.isol.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PomocnikBazowy {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public PomocnikBazowy(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    protected boolean czyJestWidocznyElement(By lokalizator) {
        try {
            driver.findElement(lokalizator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    protected void klik(By lokalizator) {
        driver.findElement(lokalizator).click();
    }
}
