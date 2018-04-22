package pl.isol.testy;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.BrowserType;
import pl.isol.appmanager.ManagerAplikacji;

public class TestBazowy {

    protected static final ManagerAplikacji app = new ManagerAplikacji(BrowserType.CHROME);

    @Before
    public void start() throws Exception {
        app.start();
    }

    @After
    public void tearDown() throws InterruptedException {
        app.stop();
    }

    public ManagerAplikacji getApp() {
        return app;
    }
}
