import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import javax.swing.*;

/**
 * Implementierung der Speicherstrategie mit Gson
 */
class GsonSpeichern implements Speichern {
    private static final String DATEI_PFAD = "worttrainer.json";
    private Gson gson;

    public GsonSpeichern() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void save(WortTrainer trainer) {
        try (FileWriter writer = new FileWriter(DATEI_PFAD)) {
            gson.toJson(trainer, writer);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Fehler beim Speichern der Daten.");
        }
    }

    @Override
    public WortTrainer load() {
        try (FileReader reader = new FileReader(DATEI_PFAD)) {
            return gson.fromJson(reader, WortTrainer.class);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Fehler beim Laden der Daten. Eine neue Datei wird erstellt.");
            return new WortTrainer(); // Gibt einen neuen Trainer zurück, falls das Laden fehlschlägt
        }
    }
}