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

public class TestSprawdzeniaStref {

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
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("root");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("root");
        driver.findElement(By.xpath("//button[@name='login']")).click();
        int liczbaStref = driver.findElements(By.xpath("//table/tbody/tr[@class='row']")).size();
        System.out.println(liczbaStref);
        ArrayList<Strefa> listaStref = new ArrayList<Strefa>();
        for (int i = 1; i < liczbaStref + 1; i++) {
            Strefa strefaObj = new Strefa();
            strefaObj.nazwaStrefy = driver.findElement(By.xpath("//table/tbody/tr[@class='row'][" + i + "]/td[3]")).getText();
            driver.findElement(By.xpath("//table/tbody/tr[@class='row'][" + i + "]/td[3]/a")).click();
            int liczbaWierszy = driver.findElements(By.xpath("//form/table/tbody/tr/td[3]")).size();
            System.out.println(liczbaWierszy);
            ArrayList<EdycjaStrefy> listaEdycjiStref = new ArrayList<EdycjaStrefy>();
            int k = 0;
            for (int j = 2; j < liczbaWierszy + 2; j++) {
                EdycjaStrefy edycjaStrefyObj = new EdycjaStrefy();
                String id = driver.findElement(By.xpath("//*[@id='table-zones']/tbody/tr[" + j + "]/td[1]")).getText();
                edycjaStrefyObj.nazwaKraju = driver.findElement(
                         By.xpath("//select[@name='zones[" + id + "][country_code]']/option[@selected='selected']")).getText();
                if (driver.findElement(By.xpath("//select[@name='zones[" + id + "][zone_code]']")).isEnabled()) {
                    edycjaStrefyObj.nazwaStrefy = driver.findElement(
                            By.xpath("//select[@name='zones[" + id + "][zone_code]']/option[@selected='selected']")).getText();
                    k++;
                }
                listaEdycjiStref.add(edycjaStrefyObj);
                System.out.println(edycjaStrefyObj.nazwaKraju + ", " + edycjaStrefyObj.nazwaStrefy);
            }
            ArrayList<EdycjaStrefy> posortowanaListaEdycjiStref = new ArrayList<EdycjaStrefy>(listaEdycjiStref);
            if (k == 0) {
                posortowanaListaEdycjiStref.sort((edycja1, edycja2) -> edycja1.nazwaKraju.compareTo(edycja2.nazwaKraju));
            } else {
                posortowanaListaEdycjiStref.sort((edycja1, edycja2) -> edycja1.nazwaStrefy.compareTo(edycja2.nazwaStrefy));
            }
            Assert.assertEquals(listaEdycjiStref, posortowanaListaEdycjiStref);
            listaStref.add(strefaObj);
            driver.findElement(By.xpath("//button[@name='cancel']")).click();
        }
        ArrayList<Strefa> posortowanaListaStef = new ArrayList<Strefa>(listaStref);
        posortowanaListaStef.sort((strefa1, strefa2) -> strefa1.nazwaStrefy.compareTo(strefa2.nazwaStrefy));
        Assert.assertEquals(listaStref, posortowanaListaStef);
        System.out.println(listaStref.size());
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}
