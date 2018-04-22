package pl.isol.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class PomocnikKoszyka extends PomocnikBazowy {

    public PomocnikKoszyka(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void pokazKoszyk() {
        klik(By.xpath("//a[contains(.,'Checkout »')]"));
    }

    public void usunProduktZKoszyka(int j) {
        klik(By.xpath("//button[@value='Remove']"));
        wait.until(numberOfElementsToBe(By.xpath("//tbody//td[@class='item']"), j));
    }

    public void dodajProduktDoKoszyka(int i) {
        klik(By.xpath("//div[@id='box-most-popular']//a[@class='link']"));
        if (czyJestWidocznyElement(By.xpath("//select[@name='options[Size]']"))) {
            klik(By.xpath("//select[@name='options[Size]']"));
            klik(By.xpath("//option[@value='Medium']"));
        }
        klik(By.xpath("//button[@name='add_cart_product']"));
        wait.until(textToBePresentInElement(By.xpath("//span[@class='quantity']"), Integer.toString(i)));
    }

    public void powrotNaStroneGlowna() {
        klik(By.xpath("//img[@alt='My Store']"));
    }
}
