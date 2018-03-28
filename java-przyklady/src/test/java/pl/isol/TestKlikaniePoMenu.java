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

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class TestKlikaniePoMenu {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testKlikaniePoMenu() throws InterruptedException {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("root");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("root");
        klik(By.xpath("//button[@name='login']"));
        wait.until(titleIs("My Store"));
        klik(By.xpath("//span[contains(.,'Appearence')]"));
        Assert.assertEquals(getH1(), "Template");
        klik(By.xpath("//span[contains(.,'Logotype')]"));
        Assert.assertEquals(getH1(), "Logotype");
        klik(By.xpath("//span[contains(.,'Catalog')]"));
        Assert.assertEquals(getH1(), "Catalog");
        klik(By.xpath("//span[contains(.,'Product Groups')]"));
        Assert.assertEquals(getH1(), "Product Groups");
        klik(By.xpath("//span[contains(.,'Option Groups')]"));
        Assert.assertEquals(getH1(), "Option Groups");
        klik(By.xpath("//span[contains(.,'Manufacturers')]"));
        Assert.assertEquals(getH1(), "Manufacturers");
        klik(By.xpath("//span[contains(.,'Suppliers')]"));
        Assert.assertEquals(getH1(), "Suppliers");
        klik(By.xpath("//span[contains(.,'Delivery Statuses')]"));
        Assert.assertEquals(getH1(), "Delivery Statuses");
        klik(By.xpath("//span[contains(.,'Sold Out Statuses')]"));
        Assert.assertEquals(getH1(), "Sold Out Statuses");
        klik(By.xpath("//span[contains(.,'Quantity Units')]"));
        Assert.assertEquals(getH1(), "Quantity Units");
        klik(By.xpath("//span[contains(.,'CSV Import/Export')]"));
        Assert.assertEquals(getH1(), "CSV Import/Export");
        klik(By.xpath("//span[contains(.,'Countries')]"));
        Assert.assertEquals(getH1(), "Countries");
        klik(By.xpath("//span[contains(.,'Currencies')]"));
        Assert.assertEquals(getH1(), "Currencies");
        klik(By.xpath("//span[contains(.,'Customers')]"));
        Assert.assertEquals(getH1(), "Customers");
        klik(By.xpath("//span[contains(.,'CSV Import/Export')]"));
        Assert.assertEquals(getH1(), "CSV Import/Export");
        klik(By.xpath("//span[contains(.,'Newsletter')]"));
        Assert.assertEquals(getH1(), "Newsletter");
        klik(By.xpath("//span[contains(.,'Geo Zones')]"));
        Assert.assertEquals(getH1(), "Geo Zones");
        klik(By.xpath("//span[contains(.,'Languages')]"));
        Assert.assertEquals(getH1(), "Languages");
        klik(By.xpath("//span[contains(.,'Storage Encoding')]"));
        Assert.assertEquals(getH1(), "Storage Encoding");
        klik(By.xpath("//span[contains(.,'Modules')]"));
        Assert.assertEquals(getH1(), "Job Modules");
        klik(By.xpath("//a[@href='http://localhost/litecart/admin/?app=modules&doc=customer']"));
        Assert.assertEquals(getH1(), "Customer Modules");
        klik(By.xpath("//span[contains(.,'Shipping')]"));
        Assert.assertEquals(getH1(), "Shipping Modules");
        klik(By.xpath("//span[contains(.,'Payment')]"));
        Assert.assertEquals(getH1(), "Payment Modules");
        klik(By.xpath("//span[contains(.,'Order Total')]"));
        Assert.assertEquals(getH1(), "Order Total Modules");
        klik(By.xpath("//span[contains(.,'Order Success')]"));
        Assert.assertEquals(getH1(), "Order Success Modules");
        klik(By.xpath("//span[contains(.,'Order Action')]"));
        Assert.assertEquals(getH1(), "Order Action Modules");
        klik(By.xpath("//span[contains(.,'Orders')]"));
        Assert.assertEquals(getH1(), "Orders");
        klik(By.xpath("//span[contains(.,'Order Statuses')]"));
        Assert.assertEquals(getH1(), "Order Statuses");
        klik(By.xpath("//span[contains(.,'Pages')]"));
        Assert.assertEquals(getH1(), "Pages");
        klik(By.xpath("//span[contains(.,'Reports')]"));
        Assert.assertEquals(getH1(), "Monthly Sales");
        klik(By.xpath("//span[contains(.,'Most Sold Products')]"));
        Assert.assertEquals(getH1(), "Most Sold Products");
        klik(By.xpath("//span[contains(.,'Most Shopping Customers')]"));
        Assert.assertEquals(getH1(), "Most Shopping Customers");
        klik(By.xpath("//span[contains(.,'Settings')]"));
        Assert.assertEquals(getH1(), "Settings");
        klik(By.xpath("//span[contains(.,'Defaults')]"));
        Assert.assertEquals(getH1(), "Settings");
        klik(By.xpath("//span[contains(.,'General')]"));
        Assert.assertEquals(getH1(), "Settings");
        klik(By.xpath("//span[contains(.,'Listings')]"));
        Assert.assertEquals(getH1(), "Settings");
        klik(By.xpath("//span[contains(.,'Images')]"));
        Assert.assertEquals(getH1(), "Settings");
        klik(By.xpath("//span[contains(.,'Checkout')]"));
        Assert.assertEquals(getH1(), "Settings");
        klik(By.xpath("//span[contains(.,'Advanced')]"));
        Assert.assertEquals(getH1(), "Settings");
        klik(By.xpath("//span[contains(.,'Security')]"));
        Assert.assertEquals(getH1(), "Settings");
        klik(By.xpath("//span[contains(.,'Slides')]"));
        Assert.assertEquals(getH1(), "Slides");
        klik(By.xpath("//span[contains(.,'Tax')]"));
        Assert.assertEquals(getH1(), "Tax Classes");
        klik(By.xpath("//span[contains(.,'Tax Rates')]"));
        Assert.assertEquals(getH1(), "Tax Rates");
        klik(By.xpath("//span[contains(.,'Translations')]"));
        Assert.assertEquals(getH1(), "Search Translations");
        klik(By.xpath("//span[contains(.,'Scan Files')]"));
        Assert.assertEquals(getH1(), "Scan Files For Translations");
        klik(By.xpath("//span[contains(.,'CSV Import/Export')]"));
        Assert.assertEquals(getH1(), "CSV Import/Export");
        klik(By.xpath("//span[contains(.,'Users')]"));
        Assert.assertEquals(getH1(), "Users");
        klik(By.xpath("//span[contains(.,'vQmods')]"));
        Assert.assertEquals(getH1(), "vQmods");
    }

    private void klik(By lokalizator) {
        driver.findElement(lokalizator).click();
    }

    private String getH1() {
        return driver.findElement(By.tagName("h1")).getText();
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
