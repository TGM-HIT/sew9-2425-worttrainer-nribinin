import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test für den Rechtschreibtrainer
 * @author Nathaniel Ribinin
 * @version 2024-10-16
 */
public class WortTrainerTest {

    private WortTrainer trainer;
    @DisplayName("Vor jedem Test muss ein Rechtschreibtrainer existierten")
    @BeforeEach
    public void setUp() {
        trainer = new WortTrainer();
    }

    @DisplayName("Es wird geprüft ob auch wirklich ein Paar ausgewählt wird")
    @Test
    public void testWaehleZufaelligesPaar_NonEmptyList() {
        trainer.getRandomWortEintrag();
        assertNotNull(trainer.getWortEintrag(), "Ein zufälliges Paar sollte ausgewählt worden sein.");
    }
    @DisplayName("Es wird geprüft ob eine passende Exception geworfen wird, sollte die Liste doch mal leer sein")
    @Test
    public void testWaehleZufaelligesPaar_EmptyList() {
        trainer.getWortListe().clear(); // Leere die Liste

        assertThrows(NullPointerException.class, () -> trainer.getRandomWortEintrag(), "Eine leere Liste sollte eine NullPointerException werfen.");
    }
    @DisplayName("Es wird geprüft ob die Statistik bei richtiger Eingabe passt")
    @Test
    public void testRateWort_CorrectGuess() {
        trainer.getRandomWortEintrag();
        WortEintrag paar = trainer.getWortEintrag();
        boolean result = trainer.rateWort(paar.getWort());
        assertTrue(result, "Die Eingabe sollte korrekt sein.");
        assertEquals("Stats - Gesamt: 1, Richtig: 1, Falsch: 0", trainer.getAktuellerStand(), "Ein richtiger Versuch sollte gezählt werden.");
    }
    @DisplayName("Es wird geprüft ob die Statistik bei falscher Eingabe passt")
    @Test
    public void testRateWort_IncorrectGuess() {
        trainer.getRandomWortEintrag();
        boolean result = trainer.rateWort("falschesWort");
        assertFalse(result, "Die Eingabe sollte falsch sein.");
        assertEquals("Stats - Gesamt: 1, Richtig: 0, Falsch: 1", trainer.getAktuellerStand(), "Ein falscher Versuch sollte gezählt werden.");
    }
    @DisplayName("Es wird geprüft ob die Statistik bei verschiedenen Eingaben passt")
    @Test
    public void testStatistik() {
        trainer.getRandomWortEintrag();
        trainer.rateWort("falschesWort");
        trainer.rateWort(trainer.getWortEintrag().getWort());
        String expectedStats = "Stats - Gesamt: 2, Richtig: 1, Falsch: 1";
        assertEquals(expectedStats, trainer.getAktuellerStand(), "Die Statistik sollte korrekt sein.");
    }
}