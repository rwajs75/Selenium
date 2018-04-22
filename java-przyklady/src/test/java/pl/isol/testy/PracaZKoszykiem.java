package pl.isol.testy;

import org.junit.Test;

public class PracaZKoszykiem extends TestBazowy {

    @Test
    public void testPracyZKoszykiem() throws InterruptedException {
        for (int i = 1; i < 4; i++) {
            app.getPomocnikKoszyka().dodajProduktDoKoszyka(i);
            app.getPomocnikKoszyka().powrotNaStroneGlowna();
        }
        app.getPomocnikKoszyka().pokazKoszyk();
        for (int j = 2; j > -1; j--) {
            app.getPomocnikKoszyka().usunProduktZKoszyka(j);
        }
    }
}
