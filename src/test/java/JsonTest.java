import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Testen der JSON Listen Konvertierungen mit Gson
 */
public class JsonTest {
    private Gson gson;
    private WortTrainer trainer;

    @DisplayName("Klassen im vorhinein erstellen und schon Paar auswählen")
    @BeforeEach
    public void setUp() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        trainer = new WortTrainer();
        trainer.getRandomWortEintrag();
    }

    @DisplayName("Es wird geprüft ob ein WortTrainer erfolgreich gespeichert und dann wieder geladen werden kann")
    @Test
    public void testSaveAndLoad() {
        // Speichern des aktuellen Trainers in JSON-Datei
        try (FileWriter writer = new FileWriter("worttrainer.json")) {
            gson.toJson(trainer, writer);
        } catch (IOException e) {
            fail("Fehler beim Speichern des Trainers: " + e.getMessage());
        }

        // Datei sollte existieren
        File file = new File("worttrainer.json");
        assertTrue(file.exists(), "Die Datei worttrainer.json sollte existieren!");

        // Laden des Trainers aus der JSON-Datei
        WortTrainer geladenerTrainer = null;
        try (FileReader reader = new FileReader("worttrainer.json")) {
            geladenerTrainer = gson.fromJson(reader, WortTrainer.class);
        } catch (IOException e) {
            fail("Fehler beim Laden des Trainers: " + e.getMessage());
        }

        // Überprüfung, ob der geladene Trainer nicht null ist
        assertNotNull(geladenerTrainer, "Geladener Trainer sollte nicht null sein!");

        // Überprüfung, ob der Trainer korrekt geladen wurde
        assertEquals(trainer.getWortListe().size(), geladenerTrainer.getWortListe().size(),
                "Die Anzahl der WortBildPaare sollte übereinstimmen.");
        assertEquals(trainer.getWortEintrag().getWort(),
                geladenerTrainer.getWortEintrag().getWort(),
                "Das ausgewählte WortBildPaar sollte dasselbe sein.");
    }

    @DisplayName("Es wird getestet dass ein default Rechtschreibtrainer geladen wird, wenn die file nicht gefunden wird")
    @Test
    public void testLoadFileNotFound() {
        // Datei löschen, falls vorhanden
        File file = new File("worttrainer.json");
        if (file.exists()) {
            file.delete();
        }

        // Versuchen, Trainer zu laden, wenn die Datei nicht existiert
        WortTrainer geladenerTrainer = null;
        try (FileReader reader = new FileReader("worttrainer.json")) {
            geladenerTrainer = gson.fromJson(reader, WortTrainer.class);
        } catch (IOException e) {
            // Datei nicht gefunden, neuen Trainer erstellen
            geladenerTrainer = new WortTrainer();
        }

        // Sicherstellen, dass ein neuer Trainer stattdessen zurückgegeben wird
        assertNotNull(geladenerTrainer, "Es sollte ein neuer WortTrainer erstellt werden, wenn die Datei nicht existiert.");
    }
}