package pl.isol;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LogowanieLitecart {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("unexpectedAlertBehaviour", "dismiss");
        //caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        //caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        //caps.setCapability(FirefoxDriver.MARIONETTE, false);
        driver = new FirefoxDriver(new FirefoxOptions(caps).setLegacy(true));
        //driver = new FirefoxDriver(new FirefoxBinary(new File("c:\\Program Files\\Nightly\\firefox.exe")), new FirefoxProfile(), caps);
        //driver = new ChromeDriver(caps);
        //driver = new InternetExplorerDriver(caps);
        System.out.println(((HasCapabilities) driver).getCapabilities());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testLogowanieLitecart() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("root");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("root");
        wait.until(titleIs("My Store"));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
