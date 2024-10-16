import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test für das WortBildPaar
 * @author Nathaniel Ribinin
 * @version 2024-10-16
 */
public class WortEintragTest {
    @DisplayName("Es wird geprüft ob die wirklichen Werte zurückgegeben werden")
    @Test
    public void testConstructor_ValidWortAndURL() {
        WortEintrag paar = new WortEintrag("TestWort", "https://valid.url.com/image.png");
        assertEquals("TestWort", paar.getWort(), "Das Wort sollte korrekt gespeichert werden.");
        assertEquals("https://valid.url.com/image.png", paar.getUrl(), "Der Bild-URL sollte korrekt gespeichert werden.");
    }
    @DisplayName("Es wird geprüft ob eine Nullpointer Exception bei null Wort ausgegeben wird")
    @Test
    public void testConstructor_InvalidWort() {
        assertThrows(NullPointerException.class, () -> {
            new WortEintrag(null, "https://valid.url.com/image.png");
        }, "Ein null-Wert für das Wort sollte eine NullPointerException werfen.");
    }
    @DisplayName("Es wird geprüft ob eine IllegalArgumentException Exception bei invalidem URL ausgegeben wird")
    @Test
    public void testConstructor_InvalidURL() {
        assertThrows(IllegalArgumentException.class, () -> {
            new WortEintrag("TestWort", "invalid-url");
        }, "Ein ungültiger URL sollte eine IllegalArgumentException werfen.");
    }
    @DisplayName("Es wird geprüft ob das Wort aktualisiert werden kann")
    @Test
    public void testSetWort() {
        WortEintrag paar = new WortEintrag("TestWort", "https://valid.url.com/image.png");
        paar.setWort("NeuesWort");
        assertEquals("NeuesWort", paar.getWort(), "Das Wort sollte aktualisiert werden.");
    }
    @DisplayName("Es wird geprüft ob der URL aktualisiert werden kann")
    @Test
    public void testSetBildURL_Valid() {
        WortEintrag paar = new WortEintrag("TestWort", "https://valid.url.com/image.png");
        paar.setUrl("https://new.url.com/image.png");
        assertEquals("https://new.url.com/image.png", paar.getUrl(), "Der URL sollte aktualisiert werden.");
    }
    @DisplayName("Es wird geprüft ob ein invalider URL beim setzten geprüft werden kann")
    @Test
    public void testSetBildURL_Invalid() {
        WortEintrag paar = new WortEintrag("TestWort", "https://valid.url.com/image.png");
        assertThrows(IllegalArgumentException.class, () -> paar.setUrl("invalid-url"), "Ein ungültiger URL sollte eine IllegalArgumentException werfen.");
    }
    @DisplayName("Es wird geprüft ob ein valider URL beim setzten geprüft werden kann")
    @Test
    public void testIsValid_ValidURL() {
        assertTrue(WortEintrag.checkUrl("https://valid.url.com/image.png"), "Der URL sollte als gültig erkannt werden.");
    }
    @DisplayName("Es wird geprüft ob ein invalider URL passend geprüft wird")
    @Test
    public void testIsValid_InvalidURL() {
        assertFalse(WortEintrag.checkUrl("invalid-url"), "Der URL sollte als ungültig erkannt werden.");
    }
}