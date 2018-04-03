package pl.isol;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestSprawdzenieKrajow {

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
    public void testSprawdzanieSortowaniaKrajow() throws InterruptedException {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("root");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("root");
        driver.findElement(By.xpath("//button[@name='login']")).click();
        int liczbaPanstw = driver.findElements(By.xpath("//table/tbody/tr[@class='row']")).size();
        System.out.println(liczbaPanstw);
        ArrayList<Panstwo> listaPanstw = new ArrayList<Panstwo>();
        for (int i = 1; i < liczbaPanstw + 1; i++) {
            Panstwo panstwoObj = new Panstwo();
            panstwoObj.nazwaPanstwa = driver.findElement(By.xpath("//table/tbody/tr[@class='row'][" + i + "]/td[5]")).getText();
            panstwoObj.liczbaStanow = driver.findElement(By.xpath("//table/tbody/tr[@class='row'][" + i + "]/td[6]")).getText();
            if (!panstwoObj.liczbaStanow.equals("0")) {
                driver.findElement(By.xpath("//table/tbody/tr[@class='row'][" + i + "]/td[5]/a")).click();
                int liczbaStanow = driver.findElements(By.xpath("//form/table/tbody/tr/td[3]")).size();
                ArrayList<Stan> listaStanow = new ArrayList<Stan>();
                for (int j = 2; j < liczbaStanow + 1; j++) {
                    Stan stanObj = new Stan();
                    stanObj.nazwaStanu = driver.findElement(By.xpath("//form/table/tbody/tr[" + j + "]/td[3]")).getText();
                    listaStanow.add(stanObj);
                    System.out.println(stanObj.nazwaStanu);
                }
                ArrayList<Stan> posortowanaListaStanow = new ArrayList<Stan>(listaStanow);
                posortowanaListaStanow.sort((stan1, stan2) -> stan1.nazwaStanu.compareTo(stan2.nazwaStanu));
                Assert.assertEquals(listaStanow, posortowanaListaStanow);
                driver.findElement(By.xpath("//button[@name='cancel']")).click();
            }
            listaPanstw.add(panstwoObj);
            System.out.println(panstwoObj.nazwaPanstwa + ", " + panstwoObj.liczbaStanow);
        }
        ArrayList<Panstwo> posortowanaListaPanstw = new ArrayList<Panstwo>(listaPanstw);
        posortowanaListaPanstw.sort((panstwo1, panstwo2) -> panstwo1.nazwaPanstwa.compareTo(panstwo2.nazwaPanstwa));
        Assert.assertEquals(listaPanstw, posortowanaListaPanstw);
        System.out.println(listaPanstw.size());
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
