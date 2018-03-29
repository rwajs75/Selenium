package pl.isol;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Logotype')]"));
        Assert.assertEquals(getH1(), "Logotype");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Catalog')]"));
        Assert.assertEquals(getH1(), "Catalog");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Product Groups')]"));
        Assert.assertEquals(getH1(), "Product Groups");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Option Groups')]"));
        Assert.assertEquals(getH1(), "Option Groups");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Manufacturers')]"));
        Assert.assertEquals(getH1(), "Manufacturers");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Suppliers')]"));
        Assert.assertEquals(getH1(), "Suppliers");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Delivery Statuses')]"));
        Assert.assertEquals(getH1(), "Delivery Statuses");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Sold Out Statuses')]"));
        Assert.assertEquals(getH1(), "Sold Out Statuses");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Quantity Units')]"));
        Assert.assertEquals(getH1(), "Quantity Units");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'CSV Import/Export')]"));
        Assert.assertEquals(getH1(), "CSV Import/Export");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Countries')]"));
        Assert.assertEquals(getH1(), "Countries");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Currencies')]"));
        Assert.assertEquals(getH1(), "Currencies");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Customers')]"));
        Assert.assertEquals(getH1(), "Customers");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'CSV Import/Export')]"));
        Assert.assertEquals(getH1(), "CSV Import/Export");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Newsletter')]"));
        Assert.assertEquals(getH1(), "Newsletter");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Geo Zones')]"));
        Assert.assertEquals(getH1(), "Geo Zones");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Languages')]"));
        Assert.assertEquals(getH1(), "Languages");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Storage Encoding')]"));
        Assert.assertEquals(getH1(), "Storage Encoding");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Modules')]"));
        Assert.assertEquals(getH1(), "Job Modules");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//a[@href='http://localhost/litecart/admin/?app=modules&doc=customer']"));
        Assert.assertEquals(getH1(), "Customer Modules");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Shipping')]"));
        Assert.assertEquals(getH1(), "Shipping Modules");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Payment')]"));
        Assert.assertEquals(getH1(), "Payment Modules");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Order Total')]"));
        Assert.assertEquals(getH1(), "Order Total Modules");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Order Success')]"));
        Assert.assertEquals(getH1(), "Order Success Modules");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Order Action')]"));
        Assert.assertEquals(getH1(), "Order Action Modules");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Orders')]"));
        Assert.assertEquals(getH1(), "Orders");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Order Statuses')]"));
        Assert.assertEquals(getH1(), "Order Statuses");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Pages')]"));
        Assert.assertEquals(getH1(), "Pages");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Reports')]"));
        Assert.assertEquals(getH1(), "Monthly Sales");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Most Sold Products')]"));
        Assert.assertEquals(getH1(), "Most Sold Products");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Most Shopping Customers')]"));
        Assert.assertEquals(getH1(), "Most Shopping Customers");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Settings')]"));
        Assert.assertEquals(getH1(), "Settings");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Defaults')]"));
        Assert.assertEquals(getH1(), "Settings");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'General')]"));
        Assert.assertEquals(getH1(), "Settings");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Listings')]"));
        Assert.assertEquals(getH1(), "Settings");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Images')]"));
        Assert.assertEquals(getH1(), "Settings");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Checkout')]"));
        Assert.assertEquals(getH1(), "Settings");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Advanced')]"));
        Assert.assertEquals(getH1(), "Settings");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Security')]"));
        Assert.assertEquals(getH1(), "Settings");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Slides')]"));
        Assert.assertEquals(getH1(), "Slides");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Tax')]"));
        Assert.assertEquals(getH1(), "Tax Classes");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Tax Rates')]"));
        Assert.assertEquals(getH1(), "Tax Rates");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Translations')]"));
        Assert.assertEquals(getH1(), "Search Translations");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Scan Files')]"));
        Assert.assertEquals(getH1(), "Scan Files For Translations");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'CSV Import/Export')]"));
        Assert.assertEquals(getH1(), "CSV Import/Export");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'Users')]"));
        Assert.assertEquals(getH1(), "Users");
        Assert.assertTrue(czyJest1Element());
        klik(By.xpath("//span[contains(.,'vQmods')]"));
        Assert.assertEquals(getH1(), "vQmods");
    }

    private void klik(By lokalizator) {
        driver.findElement(lokalizator).click();
    }

    private String getH1() {
        return driver.findElement(By.tagName("h1")).getText();
    }

    private boolean czyJest1Element () {
        return driver.findElements(By.xpath("//span[@class='fa-stack icon-wrapper']")).size() == 1;
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
